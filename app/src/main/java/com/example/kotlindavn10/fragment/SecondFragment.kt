package com.example.kotlindavn10.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlindavn10.R
import java.time.Duration


class SecondFragment: Fragment(R.layout.second_fragment) {
    private lateinit var urlText:EditText;
private lateinit var emailText:EditText;
private lateinit var nameText:EditText;
    private lateinit var button :Button;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()
        button = view.findViewById(R.id.button)
        nameText = view.findViewById(R.id.editTextTextPersonName2)
        urlText = view.findViewById(R.id.editTextTextPersonPhotoUrl)
        emailText = view.findViewById(R.id.editTextTextEmailAddress)




        button.setOnClickListener {
            if (emailText.text.isEmpty() || nameText.text.isEmpty()){
                Toast.makeText(this.context,"Missing Data",Toast.LENGTH_SHORT).show()
                sharedPref?.all?.toString()?.let { it1 -> Log.d("dasd", it1) }

            }else if(emailText.text.isEmpty() && nameText.text.isEmpty()&&urlText.text.toString().isEmpty()){
                editor?.clear()?.apply()
            }else{
            editor?.clear()?.putString("url",urlText.text.toString())?.putString("name",nameText.text.toString())?.putString("email",emailText.text.toString())?.apply()
            sharedPref?.all?.toString()?.let { it1 -> Log.d("dasd", it1)
                Toast.makeText(this.context,"Data Added",Toast.LENGTH_SHORT).show()
                urlText.text.clear()
                nameText.text.clear()
                emailText.text.clear()
                emailText.onEditorAction(EditorInfo.IME_ACTION_DONE)

            }
        }}
    }
}