# Big Dream - Professional Network Mobile App

## Overview

Big Dream is a mobile application inspired by LinkedIn, designed to help users build their professional identity, showcase skills, and connect with other developers.

Built with modern Android development using **Kotlin**, **Jetpack Compose**, and **Clean Architecture**.

## Features

- **Authentication** - Registration and login with JWT, persistent sessions via DataStore
- **Profile** - Create/edit profile, manage skills, showcase projects
- **Feed** - Create posts, like, and comment
- **Connections** - Add and view connections
- **Skill Progress** - Track skill evolution with progress tracking

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Kotlin |
| UI | Jetpack Compose + Material 3 |
| Navigation | Navigation Compose |
| Architecture | Clean Architecture + MVVM |
| Networking | Retrofit + Kotlin Serialization |
| Async | Coroutines + Flow |
| DI | Hilt |
| Local Storage | DataStore Preferences |
| Backend | REST API (Java Spring Boot) + JWT |

## Project Structure

```
app/src/main/java/com/bigdream/
├── di/                  # Hilt dependency injection modules
├── data/                # Data layer
│   ├── remote/
│   │   ├── api/         # Retrofit API interfaces
│   │   └── dto/         # Data Transfer Objects
│   ├── local/           # DataStore, local storage
│   └── repository/      # Repository implementations
├── domain/              # Domain layer (pure Kotlin, no Android deps)
│   ├── model/           # Domain models
│   ├── repository/      # Repository interfaces
│   └── usecase/         # Business logic use cases
└── presentation/        # Presentation layer
    ├── ui/
    │   ├── screens/     # Compose screens (auth, feed, profile, connections)
    │   ├── components/  # Reusable UI components
    │   ├── navigation/  # Navigation routes
    │   └── theme/       # Material theme
    └── viewmodel/       # ViewModels
```

## Setup

### Requirements

- Android Studio (Hedgehog or newer)
- JDK 17+
- Backend API running (the app points to `http://10.0.2.2:8080/api/` by default — this maps to `localhost` on the Android emulator)

### Run

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle
4. Run on emulator or device

### Run Tests

```bash
./gradlew test           # Unit tests
./gradlew connectedCheck # Instrumented tests (requires device/emulator)
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /auth/register | Register new user |
| POST | /auth/login | Login |
| GET | /users/{id} | Get user profile |
| PUT | /users/{id} | Update profile |
| GET | /posts | Get feed |
| POST | /posts | Create post |
| POST | /posts/{id}/like | Like a post |
| GET | /connections | List connections |
| POST | /connections/{userId} | Add connection |

## Authors

Marcos Dias & Hugo Prado
