# Resume App - Android приложение-резюме

Мобильное приложение с информацией о моем опыте работы, проектах и навыках Android разработчика.

## 📥 Скачать приложение

[![Download APK](https://img.shields.io/badge/Download-APK-blue?style=for-the-badge&logo=android)](https://github.com/Rothmann-Daniel/Resume/releases/download/v1.0/app-release.apk)

**Или перейдите на:** [Страницу Releases](https://github.com/Rothmann-Daniel/Resume/releases)

---

## ✨ Возможности

- 👤 **Профиль** - контактная информация и фото
- 💼 **Опыт работы** - детальное описание 17+ лет опыта
- 🚀 **Проекты** - портфолио с ссылками на GitHub
- 🎓 **Образование** - высшее образование, курсы и сертификаты
- 🛠 **Навыки** - технические навыки по категориям
- 📄 **Поделиться резюме** - экспорт в PDF формате
- 💬 **Рекомендации** - контакты рекомендателей

## 🛠 Технологии

### Architecture & Patterns
- **MVVM** - архитектурный паттерн
- **Clean Architecture** - разделение на слои
- **Single Activity** - навигация через фрагменты
- **Repository Pattern** - работа с данными

### Core
- **Kotlin** - основной язык разработки
- **Koin** - dependency injection

### UI
- **Material Design 3** - современный дизайн
- **ViewBinding** - безопасная работа с UI
- **RecyclerView** - списки и адаптеры


## 📱 Системные требования

- Android 7.0 (API 24) или выше
- ~10 MB свободного места

## 🚀 Установка

1. Скачайте [app-release.apk](https://github.com/Rothmann-Daniel/Resume/releases/download/v1.0/app-release.apk)
2. Откройте файл на Android устройстве
3. Разрешите установку из неизвестных источников (если требуется)
4. Установите приложение

## 📸 Скриншоты

<details>
<summary>Посмотреть скриншоты</summary>



<img width="453" height="876" alt="Снимок экрана 2025-11-11 в 15 14 46" src="https://github.com/user-attachments/assets/bbed85ee-14d3-4baf-ae3d-4ed335b57c09" />
<img width="585" height="816" alt="Снимок экрана 2026-01-21 в 20 16 42" src="https://github.com/user-attachments/assets/6ac6cb56-abbb-4c1c-b35e-a4eb62929233" />





</details>

## 🏗 Структура проекта

```
app/
├── data/                    # Слой данных
│   ├── repository/         # Репозитории
├── di/                     # Koin DI (module)
├── domain/                  # Бизнес-логика
│   ├── models/             # Domain модели
│   └── repository/         # Интерфейсы репозиториев
└── util/                    # Утилиты
└── ui/                      # Presentation слой
    ├── profile/            # Экран профиля
    ├── experience/         # Экран опыта
    ├── education/          # Экран образования
    ├── skills/             # Экран навыков
    └── projects/           # Экран проектов
```

## 🔧 Сборка проекта

### Клонирование

```bash
git clone https://github.com/Rothmann-Daniel/Resume.git
cd Resume
```

### Запуск

1. Откройте проект в Android Studio
2. Синхронизируйте Gradle
3. Запустите на эмуляторе или реальном устройстве

### Сборка Release APK

```bash
./gradlew assembleRelease
```

APK будет в: `app/build/outputs/apk/release/`

## 👨‍💻 Автор

**Данила Ротман** - Android Developer

- 📧 Email: danilarothmann@gmail.com
- ☎️ +7 921 568 68 55
- 💼 LinkedIn: [@Daniel Rothmann](https://www.linkedin.com/in/daniel-rothmann/)
- 📱 Telegram: [@danielrothmann](https://t.me/danielrothmann)
- 🌐 GitHub: [@Rothmann-Daniel](https://github.com/Rothmann-Daniel)

