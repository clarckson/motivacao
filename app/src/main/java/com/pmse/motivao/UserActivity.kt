package com.pmse.motivao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pmse.motivao.databinding.ActivityUserBinding



class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.hide()
        binding.buttonSalvar.setOnClickListener(this)
        verificaNome()
    }

    private fun verificaNome() {
        val nome = SalvaPreferencias(this).recuperaNome(MotivacaoKeys.KEYS.USER_NAME)
        if (nome != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_salvar){
            //Toast.makeText(this, "Mudando de tela", Toast.LENGTH_SHORT).show()
            handleSave() // Função salvar nome
        }
    }

    private fun handleSave() {
       val nome =  binding.editTextTextPersonName.text.toString()
        if (nome != "") {
            SalvaPreferencias(this).storeNome(MotivacaoKeys.KEYS.USER_NAME, nome)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Insira um nome.", Toast.LENGTH_SHORT).show()
        }
    }


}