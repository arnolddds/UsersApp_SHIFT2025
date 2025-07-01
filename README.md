# 👥 User List App

[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.10-blue.svg)](https://kotlinlang.org)  
[![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-1.5.0-brightgreen)](https://developer.android.com/jetpack/compose)  
[![API](https://img.shields.io/badge/API-21%2B-orange.svg)](https://android-arsenal.com/api?level=21)

Приложение для отображения списка пользователей с API [randomuser.me](https://randomuser.me), реализованное с использованием Clean Architecture, MVVM и Jetpack Compose. Поддерживается кэширование, обновление данных, переход по email, телефону и адресу.

---

## 📱 Демонстрация

<div align="center">
  <img src="screenshots/list.png" width="30%" alt="Список пользователей">
  <img src="screenshots/details.png" width="30%" alt="Экран пользователя">
  <img src="screenshots/error.png" width="30%" alt="Обработка ошибки">
</div>

---

## 🚀 Ключевые возможности

### 📋 Список пользователей
- Краткая информация: имя, фото, адрес, телефон
- Поддержка свайп-обновления

### 👤 Детальный экран
- Полная информация о пользователе
- Интенты:
  - Email → почтовое приложение
  - Телефон → набрать номер
  - Адрес → открыть в картах

### 💾 Локальное хранение
- Данные кэшируются в Room
- Не теряются при перезапуске приложения

### 🛠️ Обработка ошибок
- Snackbar при ошибках загрузки
- Обработка состояний загрузки и обновления

---

## ⚙️ Технологический стек

### Ядро
- **Kotlin**
- **Jetpack Compose**
- **Material Design 3**

### Архитектура
- **Clean Architecture**
- **MVVM + StateFlow**

### DI & Data
- **Hilt** — внедрение зависимостей
- **Retrofit + Gson** — загрузка пользователей с randomuser.me
- **Room** — локальное кэширование данных
- **Coil** — загрузка изображений

---

## 🧠 Архитектурные особенности

- **Clean Architecture** — деление на `data`, `domain`, `presentation`
- **MVVM** — управление состоянием и логикой отображения
- **Room + Coroutines** — асинхронное локальное хранение
- **Hilt** — автоматическое внедрение зависимостей
- **Navigation Compose** — безопасная навигация между экранами

---

## 🔧 Инструкция по запуску проекта

1. Установите Android Studio Arctic Fox или новее
2. Клонируйте проект:
```bash
git clone https://github.com/your-username/user-list-app.git
