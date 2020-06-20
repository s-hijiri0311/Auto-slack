package com.hijiri.autoslack

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : Fragment() {


    fun sendMessage(webhook:String) {
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
        arguments?.let {


            //            textView.setText(num.toString())
//
//            up.setOnClickListener {
//                num++
//                val editor = dataStore.edit()
//                editor.putInt("num", num)
//                //editor.commit();
//                editor.apply()
//
//
//                textView.setText((num).toString())
//            }
//
//            down.setOnClickListener {
//                num--
//                val editor = dataStore.edit()
//                editor.putInt("num", num)
//
//                //editor.commit();
//                editor.apply()
//                textView.setText((num).toString())
//            }
//
//
//
//
//
//
//



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)


        view.button_config.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_configFragment)
        }

        view.button_light.setOnClickListener {
            sendMessage("")
        }


        return view
    }
}




