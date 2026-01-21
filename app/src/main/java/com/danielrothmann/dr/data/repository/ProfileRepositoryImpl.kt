package com.danielrothmann.dr.data.repository

import com.danielrothmann.dr.domain.models.Education
import com.danielrothmann.dr.domain.models.EducationType
import com.danielrothmann.dr.domain.models.Experience
import com.danielrothmann.dr.domain.models.PersonalInfo
import com.danielrothmann.dr.domain.models.Project
import com.danielrothmann.dr.domain.models.Recommendation
import com.danielrothmann.dr.domain.models.Skill
import com.danielrothmann.dr.domain.repository.ProfileRepository

class ProfileRepositoryImpl : ProfileRepository {

    override fun getExperiences(): List<Experience> {
        return listOf(
            Experience(
                id = 1,
                company = "\"Криогентех\"",
                position = "Инженер по реализации проекта",
                period = "Сентябрь 2024  — Ноябрь 2025",
                duration = "1 год и 3 месяца",
                summary = "Разрабатывал Android-приложение для удаленного мониторинга и визуализации данных с медицинских систем, непосредственно взаимодействуя с инженерной командой производителя оборудования.",
                skills = listOf("Kotlin, MVVM, Room, JSON, MQTT"),
                fullDescription = "Android-разработчик приложения для мониторинга медицинского оборудования. " +
                        "Прямое взаимодействие с производителями оборудования, для интеграции программного обеспечения с аппаратными системами.\n" +
                        "\n" +
                        "В ключевом проекте совместно с инженерами Wendum разрабатывал и внедрял модуль получения телеметрии с датчиков по протоколу MQTT через Mosquitto..",
                achievements = listOf(
                    "Разработал и внедрил стабильный модуль получения телеметрии в реальном времени по протоколу MQTT с использованием брокера Mosquitto",
                    "Спроектировал и реализовал адаптивный пользовательский интерфейс с виджетами для наглядной визуализации данных: графики, списки последних значений и панели статусов оборудования.",
                    "Организовал надёжное локальное хранение исторических данных и кэширование с использованием Room для работы приложения при потере сетевого соединения.",
                    "Успешно интегрировал приложение в действующий комплекс инженерных систем, обеспечив взаимодействие с аппаратной частью."
                ),
                isCurrent = false
            )
        )
    }

    override fun getEducation(): List<Education> {
        return listOf(
            Education(
                id = 1,
                institution = "Яндекс Практикум",
                specialty = "Android-разработчик",
                period = "Ноябрь 2024 — Ноябрь 2025",
                description = "Профессиональное переобучение. Изучение Kotlin, Android SDK, XML, архитектурных паттернов (MVVM, Clean Architecture), работа с базами данных Room, сетью Ratrofit, и создание полноценных Android приложений.",
                type = EducationType.SELF_EDUCATION,
                skills = listOf("Kotlin", "Android SDK", "XML", "MVVM", "Clean Architecture", "Room", "Retrofit", "Coroutines")
            ),
            Education(
                id = 2,
                institution = "Санкт-Петербургский государственный университет сервиса и экономики",
                specialty = "Менеджмент организации",
                period = "2015",
                description = "Высшее образование. Изучение основ управления организациями, стратегического планирования, финансового менеджмента и управления персоналом.",
                type = EducationType.HIGHER,
                skills = listOf("Управление проектами", "Стратегическое планирование", "Финансовый менеджмент", "Управление персоналом")
            ),
            Education(
                id = 3,
                institution = "Санкт-Петербургский энергетический техникум",
                specialty = "Энергетик",
                period = "2004",
                description = "Техническое образование в области энергетики и энергоснабжения.",
                type = EducationType.COLLEGE,
                skills = listOf("Энергетика", "Техническое обслуживание", "Электротехника")
            ),
            Education(
                id = 4,
                institution = "ЧОУ ДПО \"Академия медицинского образования имени Ф.И. Иноземцева\"",
                specialty = "Инфекционная безопасность. Инфекционный контроль.",
                period = "2023",
                description = "Повышение квалификации в области инфекционной безопасности и контроля в медицинских учреждениях.",
                type = EducationType.COURSE,
                skills = listOf("Инфекционный контроль", "Медицинская безопасность", "Обращение с отходами")
            ),
            Education(
                id = 5,
                institution = "СПбГЭТУ \"ЛЭТИ\" им. В.И. Ульянова (Ленина)",
                specialty = "Техническое обслуживание медицинской техники групп классов 2а, 2б, 3 потенциального риска применения",
                period = "2021",
                description = "Специализированное обучение по техническому обслуживанию и ремонту медицинского оборудования различных классов риска.",
                type = EducationType.CERTIFICATION,
                skills = listOf("Медицинская техника", "Техническое обслуживание", "Ремонт оборудования", "Безопасность")
            ),
            Education(
                id = 6,
                institution = "Завод Изотоп",
                specialty = "Специализированное обучение",
                period = "2020",
                description = "Обучение работе со специализированным оборудованием и технологиями на производстве.",
                type = EducationType.COURSE
            ),
            Education(
                id = 7,
                institution = "Медико-технический центр \"Лазер\", Челябинск",
                specialty = "Лазерные технологии в медицине",
                period = "2020",
                description = "Обучение применению лазерных технологий в косметологии и эстетической медицине.",
                type = EducationType.COURSE,
                skills = listOf("Лазерные технологии", "Косметология", "Медицинское оборудование")
            ),
            Education(
                id = 8,
                institution = "Обучающий центр \"Коннесанс\"",
                specialty = "Специализированное обучение",
                period = "2018",
                description = "Дополнительное профессиональное образование: Бухгалтер.",
                type = EducationType.COURSE
            ),
            Education(
                id = 9,
                institution = "Eurocord-ed, Валенсия, Испания",
                specialty = "Клеточная трансплантация",
                period = "2010",
                description = "Международное обучение в области клеточной трансплантации и современных биомедицинских технологий.",
                type = EducationType.COURSE,
                skills = listOf("Клеточная трансплантация", "Биомедицина", "Международные стандарты")
            ),
            Education(
                id = 10,
                institution = "Planer pls. Ltd, Лондон, Великобритания",
                specialty = "Системы контроля и автоматики на производстве",
                period = "2010",
                description = "Международное обучение системам автоматизации и контроля производственных процессов.",
                type = EducationType.COURSE,
                skills = listOf("Автоматизация", "Системы контроля", "Производственные процессы")
            )
        )
    }

    override fun getProjects(): List<Project> {
        return listOf(
            Project(
                id = 1,
                name = "PlayList Maker",
                description = "Android приложение для проигрывания музыки с современным UI и поддержкой локальных файлов. Реализовано с использованием MVVM, Room, iTunes API.",
                technologies = listOf("Kotlin", "MVVM", "Room", "MediaPlayer", "Coroutines", "ViewBinding", "SingleActivity", "Retrofit", "Gson", "Coil", "Koin DI", "SingleActivity", "Lifecycle & ViewModel"),
                githubUrl = "https://github.com/Rothmann-Daniel/Playlist-Maker",
                stars = 0,
                forks = 0,
                language = "Kotlin",
                isFeatured = true
            ),
            Project(
                id = 2,
                name = "JobSearchApp",
                description = "Android приложение для для поиска вакансий. Реализовано с использованием MVVM, Room, API.",
                technologies = listOf("Kotlin", "MVVM", "Room", "Coroutines", "ViewBinding", "SingleActivity", "Retrofit", "Gson", "Coil", "Koin DI", "SingleActivity", "Lifecycle & ViewModel"),
                githubUrl = "https://github.com/Rothmann-Daniel/JobSearchApp",
                stars = 0,
                forks = 0,
                language = "Kotlin",
                isFeatured = false
            ),
            Project(
                id = 3,
                name = "RandomUser App",
                description = "Android приложение: Генератор пользователей",
                technologies = listOf("Kotlin", "MVVM", "Room", "ViewBinding", "SingleActivity", "Retrofit", "Gson", "Coil", "Koin DI", "SingleActivity", "Lifecycle & ViewModel"),
                githubUrl = "https://github.com/Rothmann-Daniel/RandomUser",
                stars = 0,
                forks = 0,
                language = "Kotlin",
                isFeatured = false
            ),
            Project(
                id = 4,
                name = "WeatherApp",
                description = "Android приложение для просмотра текущей погоды, просмотр прогноза на 5 дней, смена локаций.",
                technologies = listOf("Kotlin", "Volley(исп. альтернатива Retrofit)", "OpenWeather API", "Location Services", "SingleActivity", "LiveData", "Gson", "Picasso"),
                githubUrl = "https://github.com/Rothmann-Daniel/WeatherApp",
                stars = 0,
                forks = 0,
                language = "Kotlin",
                isFeatured = false
            ),
            Project(
                id = 5,
                name = "FoodDeliveryApp: BasketBite",
                description = "Android приложение для заказа и доставки еды с возможностью выбора из разнообразного меню и интеграции с различными ресторанами.",
                technologies = listOf("Kotlin", "Room", "ViewPager2", "Koin DI", "Favorites"),
                githubUrl = "https://github.com/Rothmann-Daniel/FoodDeliveryApp",
                stars = 0,
                forks = 0,
                language = "Kotlin",
                isFeatured = false
            )
        )
    }

    override fun getSkills(): List<Skill> {
        return listOf(
            Skill(
                id = 1,
                category = "Backend & Networking",
                skills = listOf(
                    "Retrofit 2 - - REST API клиент",
                    "Gson - парсинг JSON ответов",
                    "OkHttp3 - HTTP клиент с интерцепторами",
                    "Firebase -сервис авторизации, БД"
                )
            ),
            Skill(
                id = 2,
                category = "Architecture & DI",
                skills = listOf(
                    "Kotlin - основной язык разработки",
                    "MVVM- архитектурный паттерн",
                    "Clean Architecture",
                    "Koin - dependency injection",
                    "Single Activity + Fragments",
                    "Jetpack Navigation Component",
                    "Lifecycle & ViewModel - жизненный цикл"
                )
            ),
            Skill(
                id = 3,
                category = "Async & Data",
                skills = listOf(
                    "Coroutines - асинхронные операции",
                    "Flow - реактивные потоки данных",
                    "Room Database - локальное хранилище"
                )
            ),
            Skill(
                id = 4,
                category = "UI",
                skills = listOf(
                    "XML Layouts",
                    "Material Design - современный UI",
                    "ViewBinding - привязка view",
                    "AndroidX - современные компоненты",
                    "ViewPager2 - для swipe интерфейсов",
                    "Coil/Glide - загрузка и кэш изображений",
                    "Custom Views & Animations"
                )
            ),
            Skill(
                id = 6,
                category = "Development Tools",
                skills = listOf(
                    "Android Studio",
                    "Git & GitHub",
                    "Gradle - система сборки",
                    "Firebase - аналитика, crashlytics",
                    "Permissions - управление разрешениями"
                )
            ),
            Skill(
                id = 5,
                category = "Личные качества",
                skills = listOf(
                    "Коммуникабельность",
                    "Нестандартное мышление",
                    "Лидерство",
                    "Стратегическое планирование",
                    "Управление проектами",
                    "Техническая экспертиза"
                )
            )
        )
    }

    override fun getRecommendations(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 1,
                name = "Березовский Артем Арнольдович",
                position = "Заместитель генерального директора",
                company = "ООО \"ПетроСтрой\""
            ),
            Recommendation(
                id = 2,
                name = "Лесов Александр Владимирович",
                position = "Региональный директор",
                company = "ООО \"Корвет\""
            ),
            Recommendation(
                id = 3,
                name = "Гольцов Сергей Викторович",
                position = "Генеральный директор",
                company = "Холдинг NEO и НПО \"Тюменькриобанк\""
            ),
            Recommendation(
                id = 4,
                name = "Москалюк Роман Сергеевич",
                position = "Генеральный директор",
                company = "ООО \"Криомедтех\" (ООО \"Криогентех\")"
            )
        )
    }

    override fun getPersonalInfo(): PersonalInfo {
        return PersonalInfo.DEFAULT
    }
}
