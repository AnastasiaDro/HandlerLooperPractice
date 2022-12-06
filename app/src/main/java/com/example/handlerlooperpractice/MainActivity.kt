package com.example.handlerlooperpractice

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val LOG_TAG = "myLogs"

    lateinit var handler: Handler
    lateinit var tvInfo: TextView
    lateinit var brnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInfo = findViewById(R.id.tvInfo)
    }


    fun onclick(v: View) {
        when (v.id) {
            R.id.btnStart -> {
                for (i in 1..10) {
                    //long process
                    downloadFile()
                    // update textView
                    tvInfo.text = "Закачано файлов: $i"
                    //Logging
                    Log.d(LOG_TAG, "Закачано файлов: $i")
                }
            }
            R.id.btnTest -> {
                Log.d(LOG_TAG, "Тест")
            }
        }
    }

    fun downloadFile() {
        // пауза - 1 секунда
        try {
            TimeUnit.SECONDS.sleep(1)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}