package com.example.asyncthread

import android.os.AsyncTask
import kotlin.math.*

class Async : AsyncTask<String, Void, Int>() {
    private var count:Int = 0
    private var max = 0
    private var stop = 0

    override fun doInBackground(vararg params: String?): Int {
        println("CP 1")
        max = Integer.parseInt(params[0])
        stop = ceil(sqrt(max.toFloat())).toInt()
        println("CP 2")
//        println("param:${max}")
//        println("stop:${stop}")
        if (stop < 2){
            return count
        }
        else if (stop == 2){
            return ++count
        }
        //var prime = Array((round(max/2)-1).toInt()) { arrayOf(true,it*2+3)}

        println("CP 3")
        //array of numbers from 0 to max
        var prime = Array(max+1){true}
        prime[0] = false
        prime[1] = false
        println("CP 4")
        for(i in 2..stop) {
            println("\ni:${i}")
            for (j in 2..(max / i).toInt()) {
                try{
                    print("${j} ")
                    prime[i * j] = false
                }
                catch (e: Exception){
                    print("/${j} ")
                }
            }
        }

        count = prime.count { it.and(true) }
        return count
    }

    override fun onPostExecute(result: Int?) {
        //super.onPostExecute(result)
    }

    fun getValue(): Int{
        return count
    }
}