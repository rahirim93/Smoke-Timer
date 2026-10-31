package com.example.smoketimer

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.smoketimer.database.SmokeEntity
import com.example.smoketimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val smokeViewModel: SmokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button.setOnClickListener {
            smokeViewModel.addItem(SmokeEntity())
        }

        val smokeObserver = Observer<List<SmokeEntity>>{ items ->
            items.forEachIndexed { index, entity ->
                runOnUiThread {
                    binding.textView.append("$index \t ${(entity.date.timeInMillis)/1000}\n")
                }
            }
        }
        smokeViewModel.listItemsLiveData.observe(this, smokeObserver)

        /**
         * Не обязательно работать в фоне. Достаточно запомнить какой-то момент времени и от него считать до текущего момента количество секунд.
         * Запись в БД делается только по нажатию. Количество секунд между точками высчитывается. В фоне ничего не происходит. Секунды "тикают"
         * только когда активити видимо.
         * Алгоритм.
         *  - сделать функцию добавления в БД;
         *  - сделать кнопку добавления записи в БД;
         *  - придумать как удалять запись;
         *  - сделать отображение последних 10 записей что увидеть что все работает;
         */

        Log.d("myTag", "Hello World")
    }
}