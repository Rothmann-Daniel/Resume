
package com.danielrothmann.dr.ui.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielrothmann.dr.R
import com.danielrothmann.dr.domain.models.Education
import com.danielrothmann.dr.domain.models.EducationType

class EducationFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EducationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_education, container, false)
        setupRecyclerView(view)
        return view
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.educationRecyclerView)
        adapter = EducationAdapter(getEducationList())

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@EducationFragment.adapter
        }
    }

    private fun getEducationList(): List<Education> {
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
                description = "Высшее и дополнительно повышение квалификации. Техническое образование в области энергетики и энергоснабжения.",
                type = EducationType.COLLEGE,
                skills = listOf("Энергетика", "Техническое обслуживание", "Электротехника")
            ),
            Education(
                id = 4,
                institution = "ЧОУ ДПО \"Академия медицинского образования имени Ф.И. Иноземцева\"",
                specialty = "Инфекционная безопасность. Инфекционный контроль. Порядок обращения с медицинскими отходами.",
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
                specialty = "Лазерные технологии в косметологии",
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
                description = "Дополнительное профессиональное образование по специализированным программам.",
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
}
