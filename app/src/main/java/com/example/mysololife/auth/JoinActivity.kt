package com.example.mysololife.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mysololife.MainActivity
import com.example.mysololife.R
import com.example.mysololife.databinding.ActivityJoinBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)

        val joinBtn = binding.signUpBtn;

        joinBtn.setOnClickListener {

            var isGoToJoin = true

            val email = binding.emailArea.text.toString()
            val password = binding.passwordArea.text.toString()
            val passwordCheck = binding.passwordCheckArea.text.toString()


            if(email.isEmpty()) {
                Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if(password.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if(passwordCheck.isEmpty()) {
                Toast.makeText(this, "비밀번호확인을 입력해주세요.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if(!password.equals(passwordCheck)) {
                Toast.makeText(this, "비밀번호와 비밀번호확인이 다릅니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if (password.length < 6) {
                Toast.makeText(this, "비밀번호는 최소 6자리 이상이어야 합니다.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if (isGoToJoin) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            Toast.makeText(this, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }



        }




    }
}