package com.ashleyLeung.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.ashleyLeung.MyName
import com.ashleyLeung.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var myName : MyName = MyName("Ashley Leung222")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //        setContentView(R.layout.activity_main)//databinding的时候这句一定要删掉
//        findViewById<Button>(R.id.button).setOnClickListener {
//            addNickName(it)
//        }
//        val starImage = findViewById<ImageView>(R.id.star_image);

    /*viewbinding

     binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.starImage.visibility = View.GONE
        binding.button.setOnClickListener {
            Log.d("name", "aaaa");
            addNickName(it)
        }*/
        //databinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.myName = myName


        binding.button.setOnClickListener {

            addNickName(it)
            Log.d("name", myName.name+","+myName.nickname);
        }
    }

    private fun addNickName(view: View) {
//        Log.d("name", "bbbb");
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)

//        nickNameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nickNameTextView.visibility = View.VISIBLE

     /*viewbinding
     binding.apply {
           Log.d("name", "cccc");
            binding.nicknameText.text = binding.nicknameEdit.text
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
           Log.d("name", "dddd");
        }*/

        binding.apply {
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            button.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}