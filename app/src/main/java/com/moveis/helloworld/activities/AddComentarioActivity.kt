package com.moveis.helloworld.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.ProgressBar
import com.moveis.helloworld.R
import com.moveis.helloworld.restservice.Comentario
import com.moveis.helloworld.restservice.ForumWebClient
import com.moveis.helloworld.restservice.ICallbackResponse
import kotlinx.android.synthetic.main.activity_add_comentario.*


class AddComentarioActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_comentario)

        // Ativando action bar de voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        buttonSave.setOnClickListener { save() }
    }

    fun save() {
        // Ativando progress bar
        progressbar.visibility = ProgressBar.VISIBLE

        val cat = Comentario(autor = editTextAutor.text.toString(), comentario = editTextComentario.text.toString(), topico = editTextIdTopico.text.toString().toInt())
        ForumWebClient().insertComentarios(cat, object : ICallbackResponse<Comentario> {
            override fun success(instance: Comentario) {
                // Desativando progress bar
                progressbar.visibility = ProgressBar.INVISIBLE
                editTextAutor.setText("")
                editTextComentario.setText("")
                editTextIdTopico.setText("")
                toast("Salvo com sucesso!")
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == R.id.home) {
            // Trata o click do botão voltar
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
