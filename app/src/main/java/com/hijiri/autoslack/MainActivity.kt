package com.hijiri.autoslack

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {




    fun sendMessage() {
        val webhook: String = "https://hooks.slack.com/services/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"
        val body: String = "{ \"text\" : \"homebot send pi(light)\" }"
        Fuel.post(webhook).body(body).responseString { _, response, result ->
            result.fold({ _ ->
                Log.d("res", response.toString())
            }, { err ->
                Log.e("err", err.toString())
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // "DataStore"という名前でインスタンスを生成
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        // "num"から読み出す
        var num = dataStore.getInt("num",27)

        textView.setText(num.toString())

        up.setOnClickListener {
            num++
            val editor = dataStore.edit()
            editor.putInt("num", num)
            //editor.commit();
            editor.apply()


            textView.setText((num).toString())
        }

        down.setOnClickListener {
            num--
            val editor = dataStore.edit()
            editor.putInt("num", num)

            //editor.commit();
            editor.apply()
            textView.setText((num).toString())
        }







        button_light.setOnClickListener {
            sendMessage()
        }
    }



}