package com.example.alexklim_23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val items = listOf(
            Item("Начало", "С чего всё началось и к чему привело", "В небольшом городке жил-был программист по имени Алекс. Он всегда мечтал создать приложение, которое помогло бы людям находить единомышленников для занятий спортом. Алекс заметил, что многие его друзья часто жаловались на отсутствие компании для тренировок, и решил, что пришло время действовать.\n" +
                    "Алекс начал с составления плана. Он определил основные функции приложения: возможность создания профиля, поиск пользователей по интересам и геолокация для нахождения ближайших спортивных мероприятий. После этого он создал макеты интерфейса и продумал пользовательский опыт. Это был важный этап, так как от удобства использования зависела популярность приложения.\n"),
            Item("Развитие", "Непростой выбор", "Алекс выбрал язык программирования Kotlin, который идеально подходил для разработки под Android. Он установил Android Studio и погрузился в изучение необходимых библиотек и фреймворков. Каждый день он проводил часы за кодированием, тестированием и исправлением ошибок. Процесс разработки был не всегда гладким. Иногда возникали сложности с интеграцией API для геолокации и работы с базами данных. Но Алекс не сдавался. Он активно искал решения на форумах, использовал документацию и даже общался с более опытными разработчиками.\n" +
                    "После нескольких месяцев упорной работы приложение было готово к тестированию. Алекс собрал группу друзей, чтобы они протестировали его творение. Обратная связь была очень полезной: некоторые функции нужно было доработать, а интерфейс сделать более интуитивным. Алекс учел все замечания и внес необходимые изменения.\n"),
            Item("Заключение", "К чему видёт упорный труд", "Наконец, настал долгожданный момент — запуск приложения в Google Play. Алекс тщательно подготовил описание, скриншоты и видео-презентацию. Он также создал страницу в социальных сетях для продвижения своего проекта.\n" +
                    "Сначала приложение не набрало большой популярности, но Алекс не терял надежды. Он активно продвигал его через социальные сети, участвовал в спортивных мероприятиях и делал акцент на уникальных функциях своего приложения. Постепенно количество загрузок начало расти. Спустя несколько месяцев приложение стало популярным среди любителей спорта в его городе. Пользователи начали находить друг друга для совместных тренировок, а Алекс получил множество положительных отзывов.\n" +
                    "История Алекса — это пример того, как идея может стать реальностью благодаря упорству и труду. Его приложение не только помогло людям находить единомышленников, но и изменило его жизнь к лучшему. Алекс понял, что разработка программ — это не только кодирование, но и умение слушать пользователей и адаптироваться к их потребностям.\n")
        )

        adapter = ItemAdapter(items) { item ->
            val detailFragment = DetailFragment().apply {
                arguments = Bundle().apply {
                    putString("item_name", item.name)
                    putString("item_description", item.description)
                    putString("item_text", item.text)
                }
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.adapter = adapter
    }
}
