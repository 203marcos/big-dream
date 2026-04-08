# Instructions - What to Study and Understand

This guide is for you (Hugo and Marcos) to learn the key concepts used in this project. Go through each section, read the linked resources, and explore the matching code in the project.

---

## 1. Kotlin Basics

Before diving into Android, make sure you're comfortable with these Kotlin features used throughout the project:

- **Data classes** - Used for all our models (`User`, `Post`, `AuthToken`). They auto-generate `equals()`, `hashCode()`, `toString()`, and `copy()`.
  - Look at: `domain/model/User.kt`
  - Read: https://kotlinlang.org/docs/data-classes.html

- **Sealed classes** - Used for navigation routes (`Screen`). They restrict which subclasses can exist.
  - Look at: `presentation/ui/navigation/Screen.kt`
  - Read: https://kotlinlang.org/docs/sealed-classes.html

- **Null safety** - Kotlin's `?` and `?.` operators prevent null pointer crashes. Notice how `AuthToken?` is used when the user might not be logged in.
  - Look at: `data/local/SessionManager.kt` (`getToken()` returns `AuthToken?`)
  - Read: https://kotlinlang.org/docs/null-safety.html

- **Extension functions** - `toDomain()` in `UserRepositoryImpl` is an extension on `UserResponse`.
  - Look at: `data/repository/UserRepositoryImpl.kt`
  - Read: https://kotlinlang.org/docs/extensions.html

- **Lambda functions** - Used everywhere in Compose (`onClick = { ... }`, `items.forEach { ... }`).
  - Look at: `presentation/ui/BigDreamNavHost.kt`
  - Read: https://kotlinlang.org/docs/lambdas.html

- **Result type** - We wrap API responses in `Result<T>` to handle success/failure cleanly.
  - Look at: `domain/repository/AuthRepository.kt` and `data/repository/AuthRepositoryImpl.kt`
  - Read: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-result/

---

## 2. Coroutines and Suspend Functions

All our API calls and database operations use coroutines. This is how Android handles async work without blocking the UI.

- **`suspend` keyword** - Every repository method is `suspend` because it does network/disk I/O.
  - Look at: `domain/repository/AuthRepository.kt`

- **`runTest`** - Used in unit tests to run suspend functions.
  - Look at: `LoginUseCaseTest.kt`

- **Key concept**: A `suspend` function can pause and resume without blocking the thread. Retrofit handles the threading for you — just mark the function as `suspend`.

- Study: https://kotlinlang.org/docs/coroutines-basics.html

---

## 3. Clean Architecture

This is the most important architectural concept in the project. Understand **why** we separate code into layers:

```
presentation  -->  domain  <--  data
(UI, ViewModels)   (pure logic)  (API, database)
```

- **Domain layer** has NO Android dependencies. It defines what the app *does*.
- **Data layer** implements *how* it does it (Retrofit, DataStore).
- **Presentation layer** shows it to the user (Compose, ViewModels).

### The key rule: dependencies point inward

- `presentation` depends on `domain` (ViewModels call use cases)
- `data` depends on `domain` (repositories implement domain interfaces)
- `domain` depends on **nothing** — it's pure Kotlin

### What to study in the code

1. **Repository pattern**: Compare `domain/repository/AuthRepository.kt` (interface) with `data/repository/AuthRepositoryImpl.kt` (implementation). The domain defines *what*, the data layer defines *how*.

2. **Use cases**: Look at `domain/usecase/LoginUseCase.kt`. It's a single action that calls the repository. Use cases keep the ViewModel thin.

3. **DTOs vs Domain models**: Compare `data/remote/dto/UserDto.kt` with `domain/model/User.kt`. DTOs match the API JSON. Domain models are what the app actually uses. The repository converts between them.

---

## 4. Dependency Injection with Hilt

Hilt automatically creates and provides objects where they're needed, instead of you manually creating them.

- **`@HiltAndroidApp`** on the Application class enables Hilt.
  - Look at: `BigDreamApp.kt`

- **`@AndroidEntryPoint`** on Activities lets them receive injected dependencies.
  - Look at: `MainActivity.kt`

- **`@Inject constructor`** tells Hilt how to create a class.
  - Look at: `LoginUseCase.kt`, `AuthRepositoryImpl.kt`

- **`@Module` + `@Provides`** teaches Hilt how to create things it can't figure out alone (like Retrofit).
  - Look at: `di/NetworkModule.kt`

- **`@Binds`** connects an interface to its implementation.
  - Look at: `di/RepositoryModule.kt`

- Study: https://developer.android.com/training/dependency-injection/hilt-android

---

## 5. Jetpack Compose

All UI is built with Compose — a declarative UI framework. Instead of XML layouts, you write Kotlin functions that describe what the screen looks like.

- **`@Composable`** annotation marks a UI function.
- **`remember` + `mutableStateOf`** hold state that triggers UI updates when changed.
  - Look at: `LoginScreen.kt` (email and password fields)

- **`Modifier`** controls layout, size, padding, clicks, etc.
- **`MaterialTheme`** provides consistent colors and typography.
  - Look at: `presentation/ui/theme/Theme.kt`

- Study: https://developer.android.com/develop/ui/compose/documentation

---

## 6. Navigation Compose

How the app moves between screens (Login -> Feed -> Profile, etc.).

- **`NavHost`** defines all possible destinations.
- **`navController.navigate()`** moves to a screen.
- **`popUpTo`** clears the back stack (so pressing back from Feed doesn't go back to Login).
  - Look at: `BigDreamNavHost.kt`

- Study: https://developer.android.com/guide/navigation/get-started

---

## 7. Retrofit + API Communication

Retrofit turns your API interface into actual HTTP calls.

- **Interface methods** map to HTTP endpoints using annotations like `@GET`, `@POST`, `@Path`, `@Body`.
  - Look at: `data/remote/api/AuthApi.kt`

- **DTOs with `@Serializable`** define the JSON structure.
  - Look at: `data/remote/dto/AuthDtos.kt`

- **OkHttp Interceptor** automatically adds the JWT token to every request.
  - Look at: `di/NetworkModule.kt` (the `authInterceptor`)

- Study: https://square.github.io/retrofit/

---

## 8. DataStore

Replaces SharedPreferences for storing small key-value data (like the auth token).

- Look at: `data/local/SessionManager.kt`
- Study: https://developer.android.com/topic/libraries/architecture/datastore

---

## Suggested Learning Path

Work through these in order:

1. **Kotlin basics** - data classes, nulls, lambdas (1-2 days)
2. **Coroutines** - understand suspend and basic flow (1 day)
3. **Jetpack Compose** - build small UI experiments (2-3 days)
4. **Clean Architecture** - trace a feature from screen to API (1 day)
5. **Hilt** - understand how DI wires things together (1 day)
6. **Retrofit** - make API calls and see the results (1 day)
7. **Navigation** - add a new screen and navigate to it (1 day)

---

## First Tasks to Try

Once you've studied the concepts above, try these to get hands-on:

1. **Add a ViewModel** - Create `LoginViewModel` that calls `LoginUseCase` and exposes state to `LoginScreen`
2. **Build out FeedScreen** - Display a list of posts using `LazyColumn`
3. **Add error handling in the UI** - Show a `Snackbar` when login fails
4. **Create ProfileScreen** - Show user info and an edit button
5. **Write a test** - Look at `LoginUseCaseTest.kt` and write a similar test for `GetFeedUseCase`
