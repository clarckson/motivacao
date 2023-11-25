package com.pmse.motivao

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pmse.motivao.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoria = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //
        binding.button.setOnClickListener(this)
        binding.imageView1 .setOnClickListener(this)
        binding.imageView2.setOnClickListener(this)
        binding.imageView3.setOnClickListener(this)
        binding.textView2.setOnClickListener(this)

        // Escondendo a barra de navegação - Nome da Aplicação
        supportActionBar?.hide()

        //Recuperando o nome
        handleUserName()

        //Selecionando um dos icones para já comecçar com as frases
        mudaCores(R.id.imageView1)

    }


    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }
    override fun onDestroy() {
        super.onDestroy()
    }


    private fun handleUserName() {
        val nome = SalvaPreferencias(this).recuperaNome(MotivacaoKeys.KEYS.USER_NAME)
        binding.textView2.text = getString(R.string.ola_usuario, nome)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button){
            handleNovaFrase()
//            Toast.makeText(this, "Botão acionado", Toast.LENGTH_SHORT).show()
//            println("Fui clicado")
        } else if (v.id in listOf(R.id.imageView1, R.id.imageView2, R.id.imageView3 )) {
            mudaCores(v.id)
        } else if (v.id == R.id.textView2){
            SalvaPreferencias(this).limpaNome(MotivacaoKeys.KEYS.USER_NAME)
            startActivity(Intent(this, UserActivity::class.java))
            finish()
        }
    }

    private fun handleNovaFrase() {
        val fraseNova = Mock().getFrase(categoria)
        binding.textView.text = fraseNova
        Log.w("testeckm", "O valor da categoria foi $categoria")
    }

    private fun mudaCores(id: Int) {
        binding.imageView1.setColorFilter(ContextCompat.getColor(this, R.color.apagado))
        binding.imageView2.setColorFilter(ContextCompat.getColor(this, R.color.apagado))
        binding.imageView3.setColorFilter(ContextCompat.getColor(this, R.color.apagado))
        when (id) {
            R.id.imageView1 -> {
                binding.imageView1.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoria = MotivacaoKeys.CATEGORIAS.INFINITO
            }
            R.id.imageView2 -> {
                binding.imageView2.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoria = MotivacaoKeys.CATEGORIAS.FELIZ
            }
            R.id.imageView3 -> {
                binding.imageView3.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoria = MotivacaoKeys.CATEGORIAS.SOL
            }
        }
        val fraseNova = Mock().getFrase(categoria)
        binding.textView.text = fraseNova
    }
}