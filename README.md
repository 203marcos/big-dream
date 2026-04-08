# 📱 Big Dream - Professional Network Mobile App

## 🚀 Overview

Big Dream is a mobile application inspired by LinkedIn, designed to help users build their professional identity, showcase skills, and connect with other developers.

This project focuses on modern Android development using Kotlin and clean architecture principles.

---

## 🎯 Purpose

The goal of this project is to demonstrate real-world mobile development skills required for junior developer positions, including:

* API integration
* Clean architecture
* State management
* Authentication
* UI/UX design

---

## 📱 Features

### 🔐 Authentication

* User registration
* Login with JWT
* Persistent session using DataStore

### 👤 Profile

* Profile creation and editing
* Skills management
* Projects showcase

### 📰 Feed

* Create posts
* Like posts
* Comment on posts

### 🤝 Connections

* Add connections
* View connections list

### 📊 Skill Progress (Differential)

* Track skill evolution
* Progress bars
* Learning history

### 🔔 Notifications (Optional)

* New connections
* New interactions

---

## 🧱 Architecture

This project follows **Clean Architecture + MVVM**:

```
presentation/
  view/
  viewmodel/

domain/
  model/
  usecase/

data/
  repository/
  remote/
  local/
```

### Layers

* **Presentation**: UI and ViewModels
* **Domain**: Business logic
* **Data**: API and local database

---

## ⚙️ Tech Stack

### Mobile

* Kotlin
* Jetpack Compose
* Navigation Compose

### Networking

* Retrofit
* Gson / Moshi

### Async

* Coroutines
* Flow

### Local Storage

* DataStore
* Room (optional)

### Backend Integration

* REST API (Java Spring Boot)
* JWT Authentication

---

## 🔌 API Endpoints (Example)

### Auth

* POST /auth/register
* POST /auth/login

### Users

* GET /users/{id}
* PUT /users/{id}

### Posts

* GET /posts
* POST /posts
* POST /posts/{id}/like

### Connections

* POST /connections
* GET /connections

---

## 🛠️ Setup & Installation

### Requirements

* Android Studio
* JDK 17+
* Backend API running

### Steps

```bash
git clone https://github.com/your-username/big-dream-mobile
cd big-dream-mobile
```

Open in Android Studio and run the project.

---

## 🧪 Testing

* Manual testing
* API testing with Postman
* (Optional) UI tests with Espresso

---

## ☁️ Future Improvements

* Firebase push notifications
* Dark mode
* Real-time updates (WebSocket)
* Image upload (AWS S3)

---

## 📸 Screenshots

> Add screenshots here

---

## 📄 Documentation

* Architecture decisions
* API contracts
* User flows

---

## 👨‍💻 Author

Marcos Dias

---

## ⭐ Final Notes

This project was built to simulate a real production-level mobile application and demonstrate readiness for a junior developer role.

If you found this project useful, feel free to give it a star ⭐
