package com.example.kotlindavn10.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kotlindavn10.R
import java.net.URI
import java.net.URL

class FirstFragment : Fragment(R.layout.first_fragment),SharedPreferences.OnSharedPreferenceChangeListener {
    private var sharedPref:SharedPreferences? = null
    private lateinit var emailText:TextView
    private lateinit var nameText:TextView
    private lateinit var imageView: ImageView
    private lateinit var sharedView:View;
     private var url:String? = null;
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        sharedPref?.registerOnSharedPreferenceChangeListener(this)
        imageView = view.findViewById(R.id.imageView)
        emailText = view.findViewById(R.id.emailTextView)
        nameText = view.findViewById(R.id.nameTextView)
        url = sharedPref?.getString("url","No Data")
        emailText.text = sharedPref?.getString("email","no Data")
        nameText.text = sharedPref?.getString("name","no Data")
        sharedView = view
        Glide.with(sharedView)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imageView)



    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        emailText.text = sharedPref?.getString("email","no Data")
        nameText.text = sharedPref?.getString("name","no Data")
        url=sharedPreferences?.getString("url","No Data")
        Glide.with(sharedView)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imageView)

    }

}