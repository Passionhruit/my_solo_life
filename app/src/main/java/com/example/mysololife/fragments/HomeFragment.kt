package com.example.mysololife.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.mysololife.R
import com.example.mysololife.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("NavDebug", "onViewCreated 호출됨!")

        // 버튼 클릭 시 안전하게 findNavController() 사용
        binding.tipTab.setOnClickListener {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
            try {
                findNavController().navigate(R.id.action_homeFragment_to_tipFragment)
                Log.d("NavDebug", "탭 클릭 후 네비게이션 성공!")
            } catch (e: Exception) {
                Log.e("NavDebug", "네비게이션 오류 발생!", e)
            }
        }
    }
}
