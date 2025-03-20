package com.example.mysololife

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mysololife.auth.IntroActivity
import com.example.mysololife.databinding.ActivityIntroBinding
import com.example.mysololife.databinding.ActivityMainBinding
import com.example.mysololife.fragments.HomeFragment
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var auth: FirebaseAuth

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        auth = Firebase.auth

        if (savedInstanceState == null) {  // ✅ 앱이 처음 실행될 때만 Fragment 추가
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, HomeFragment())
                .commit()
        }

        // 로그 추가하여 NavHostFragment가 정상적으로 로드되는지 확인


//        val logoutBtn = binding.logoutBtn
//
//        logoutBtn.setOnClickListener {
//            auth.signOut()
//            val intent = Intent(this, IntroActivity::class.java)
//            startActivity(intent)
//        }

    }
}