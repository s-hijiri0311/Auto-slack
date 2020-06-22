package com.hijiri.autoslack

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_config.view.*
import java.util.logging.Logger
import java.util.regex.Pattern



class ConfigFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_config, container, false)


        view.textView.setText(Html.fromHtml("<a href=\"https://slack.com/apps/A0F7XDUAZ-incoming-webhooks\">Webhook URL</a>"))
        view.textView.setMovementMethod(LinkMovementMethod.getInstance())

        return view
    }
}