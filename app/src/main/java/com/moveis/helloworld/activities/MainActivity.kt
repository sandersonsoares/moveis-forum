package com.moveis.helloworld.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.moveis.helloworld.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    /* Abrir tela de categorias */
    fun categorias(view: View) {
        val intent = Intent(this, CategoriasActivity::class.java)
        startActivity(intent)
    }

    /* Abrir tela de topicos */
    fun topicos(view: View) {
        val intent = Intent(this, TopicosActivity::class.java)
        startActivity(intent)
    }

    /* Abrir tela de comentarios */
    fun comentarios(view: View) {
        val intent = Intent(this, ComentariosActivity::class.java)
        startActivity(intent)
    }

}
