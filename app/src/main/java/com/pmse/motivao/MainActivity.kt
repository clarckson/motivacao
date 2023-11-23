package com.pmse.motivao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pmse.motivao.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //
        binding.button.setOnClickListener(this)

        // Escondendo a barra de navegação - Nome da Aplicação
        supportActionBar?.hide()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button){
            Toast.makeText(this, "Botão avionado", Toast.LENGTH_SHORT).show()
//            println("Fui clicado")
        }
    }
}