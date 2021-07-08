package com.nextop.project.futuretask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.FutureTask

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun futureTask(){
        // 1. FutureTask => Thread
        val ftCal = FutureTask{ // 타입추론 적용됨
            return@FutureTask "Result Runnable"
        }
        val ftRun = FutureTask({

        },"Result Callable")

        // 2. ExecutorService
        val exs = Executors.newFixedThreadPool(2)
        exs.execute(ftCal)
        exs.execute(ftRun)

        Log.e("MainActivity","" + ftCal.get())
        Log.e("MainActivity","" + ftRun.get())
    }
}
