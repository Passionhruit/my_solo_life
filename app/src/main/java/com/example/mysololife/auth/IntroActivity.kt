package com.example.mysololife.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.mysololife.MainActivity
import com.example.mysololife.R
import com.example.mysololife.databinding.ActivityIntroBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class IntroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntroBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        auth = Firebase.auth

        val signInBtn = binding.signInBtn

        signInBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity:: class.java)
            startActivity(intent)
        }

        val signUpBtn = binding.signUpBtn

        signUpBtn.setOnClickListener {
            val intent = Intent(this, JoinActivity:: class.java)
            startActivity(intent)
        }

        val nmSignInBtn = binding.nmSignInBtn

        nmSignInBtn.setOnClickListener {

            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "로그인에 성공하였습니다", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity:: class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "로그인에 실패하였습니다", Toast.LENGTH_SHORT).show()

                    }
                }

        }

    }
}