package com.example.asyncthread
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiateProgram()
    }

    private fun initiateProgram(){
        button1.setOnClickListener{
            var thread = Async()
            var text = input1.text.toString()
            var num = Integer.parseInt(text)
            thread.execute(text)
            Thread.sleep(((ceil(((num/100).toDouble()))+2)*200).toLong())
            var value = thread.getValue()
            textview1.setText("Total Count: ${value}")
        }
    }
}