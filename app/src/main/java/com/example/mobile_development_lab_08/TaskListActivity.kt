package com.example.mobile_development_lab_08

import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.mobile_development_lab_08.ui.TaskListFragment

class TaskListActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Включаем режим строгой политики (StrictMode) для выявления потенциальных проблем с производительностью
        StrictMode.enableDefaults()

        // Устанавливаем макет активности из ресурса XML
        setContentView(R.layout.activity_task_list)

        // Проверяем, пуст ли контейнер для фрагмента (savedInstanceState будет null при первом создании активности)
        val isFragmentContainerEmpty = savedInstanceState == null

        // Если контейнер пуст, добавляем новый фрагмент
        if (isFragmentContainerEmpty) {
            supportFragmentManager // Получаем экземпляр FragmentManager для управления фрагментами
                .beginTransaction() // Начинаем транзакцию фрагментов
                .add(R.id.fragmentContainer, TaskListFragment.newInstance()) // Добавляем новый экземпляр фрагмента в контейнер
                .commit() // Подтверждаем транзакцию
        }
    }
}