package com.ashleyLeung.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.ashleyLeung.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(R.layout.activity_main)
//        findViewById<Button>(R.id.button).setOnClickListener {
//            addNickName(it)
//        }
        binding.starImage.visibility = View.GONE
        binding.button.setOnClickListener {
            Log.d("name", "aaaa");
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        Log.d("name", "bbbb");
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)

//        nickNameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nickNameTextView.visibility = View.VISIBLE

       binding.apply {
           Log.d("name", "cccc");
            binding.nicknameText.text = binding.nicknameEdit.text
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
           Log.d("name", "dddd");
        }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}