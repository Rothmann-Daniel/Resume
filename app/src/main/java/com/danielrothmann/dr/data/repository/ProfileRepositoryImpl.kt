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
                company = "ООО \"Криогентех\"",
                position = "Ведущий инженер по реализации проектов",
                period = "Октябрь 2008 — сейчас",
                duration = "17 лет 2 месяца",
                summary = "Полный цикл проектов под ключ. Работа с ведущими медицинскими центрами России.",
                skills = listOf("Проектирование", "Пусконаладка", "Сервис", "Криогенное оборудование", "Ведение проектов", "Техническая экспертиза"),
                fullDescription = "Выполнение работ по проектированию, строительству и обслуживанию организаций. Разработка методических и нормативных документов, технической документации. Проведение технико-экономического анализа, комплексного обоснования принимаемых и реализуемых решений.",
                achievements = listOf(
                    "Участие в проектных группах ведущих криобанков России (ФМБА, Клиника Ава-Петер)",
                    "Обучение в ведущих криобанках Европы и Англии",
                    "Участник международных конференций",
                    "Развитие творческой инициативы и рационализации"
                ),
                isCurrent = true
            ),
            Experience(
                id = 2,
                company = "ООО \"БОКС\"",
                position = "Генеральный директор",
                period = "Ноябрь 2018 — Март 2021",
                duration = "2 года 5 месяцев",
                summary = "Запуск и управление компанией по сервису и инсталляции медицинского оборудования.",
                skills = listOf("Управление", "Тендеры", "Сервис", "Бизнес-развитие", "Поиск клиентов", "Ведение переговоров"),
                fullDescription = "Поиск клиентов для заключения договоров на сервисное обслуживание и инсталляцию. Участие в тендерах. Ведение деловой переписки. Проведение гарантийного и послегарантийного обслуживания оборудования.",
                achievements = listOf(
                    "Запуск компании с нуля",
                    "Налаживание процессов сервисного обслуживания",
                    "Успешное участие в государственных тендерах"
                ),
                isCurrent = false
            ),
            Experience(
                id = 3,
                company = "ООО \"ПетроСтрой\"",
                position = "Руководитель проекта",
                period = "Март 2018 — Январь 2021",
                duration = "2 года 11 месяцев",
                summary = "Управление строительными проектами, составление планов и контроль выполнения.",
                skills = listOf("Управление проектами", "Планирование", "Контроль качества", "Составление смет", "Подбор команды"),
                fullDescription = "Определение состава работ, необходимого для ведения проекта. Составление план-графика работ и контроль за его выполнением. Составление сметы проекта. Подбор команды.",
                achievements = listOf(
                    "Успешная реализация строительных проектов",
                    "Оптимизация процессов планирования",
                    "Эффективное управление проектными командами"
                ),
                isCurrent = false
            ),
            Experience(
                id = 4,
                company = "СКБ \"Титан\"",
                position = "Начальник отдела снабжения и сбыта",
                period = "Август 2016 — Март 2018",
                duration = "1 год 8 месяцев",
                summary = "Руководство отделом снабжения, организация материально-технического обеспечения.",
                skills = listOf("Снабжение", "Логистика", "Госзаказ", "223-ФЗ", "44-ФЗ", "Управление отделом"),
                fullDescription = "Руководство отделом снабжения. Организация работы по обеспечению предприятия необходимым сырьем, материалами. Обеспечение контроля за состоянием сырьевых запасов. Разработка планов по материально-техническому снабжению компании.",
                achievements = listOf(
                    "Сдача ГОЗ (гособоронзаказ) по текущим проектам в срок",
                    "Оптимизация процессов снабжения",
                    "Успешная работа по 223-ФЗ, 44-ФЗ, 275-ФЗ"
                ),
                isCurrent = false
            ),
            Experience(
                id = 5,
                company = "ООО НПО \"Тюменькриобанк\"",
                position = "Заместитель генерального директора по производству",
                period = "Май 2011 — Сентябрь 2014",
                duration = "3 года 5 месяцев",
                summary = "Запуск компании с нуля, вывод на рентабельность, управление производством.",
                skills = listOf("Запуск производства", "R&D", "Управление", "Бизнес-планирование", "Подбор персонала"),
                fullDescription = "Руководство производственной деятельностью. Формирование производственной политики и стратегии развития производства. Разработка бизнес-планов. Контроль за рациональным использованием производственных ресурсов.",
                achievements = listOf(
                    "Организация работы компании с нуля",
                    "Вывод компании на рентабельность за 2,5 года",
                    "Создание банка хранения частного биоматериала",
                    "Организация производственной линии репаративного препарата"
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
                id = 3,
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
                    "Retrofit 2 - для сетевых запросов к API",
                    "Gson - для парсинга JSON ответов",
                    "OkHttp3 - HTTP клиент с логированием запросов",
                    "Coil - для загрузки и кэширования изображений"
                )
            ),
            Skill(
                id = 2,
                category = "Architecture & DI",
                skills = listOf(
                    "Kotlin - основной язык разработки",
                    "MVVM - архитектурный паттерн",
                    "Koin - dependency injection",
                    "Single Activity + Fragments - навигация",
                    "Jetpack Navigation Component - управление навигацией",
                    "Lifecycle & ViewModel - управление жизненным циклом"
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
                    "ViewPager2 - для swipe интерфейсов"
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
