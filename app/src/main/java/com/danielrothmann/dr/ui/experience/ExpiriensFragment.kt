package com.danielrothmann.dr.ui.experience


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielrothmann.dr.R
import com.danielrothmann.dr.domain.Experience

class ExpiriensFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExperienceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_expiriens, container, false)
        setupRecyclerView(view)
        return view
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.experienceRecyclerView)
        adapter = ExperienceAdapter(getExperiences())

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ExpiriensFragment.adapter
        }
    }

    private fun getExperiences(): List<Experience> {
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
}