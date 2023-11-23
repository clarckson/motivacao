package com.pmse.motivao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pmse.motivao.databinding.ActivityMainBinding
import com.pmse.motivao.databinding.ActivityUserBinding



class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.hide()
       binding.buttonSalvar.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_salvar){
            Toast.makeText(this, "Mudando de tela", Toast.LENGTH_SHORT).show()
        }
    }
}