package com.moveis.helloworld.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ProgressBar
import com.moveis.helloworld.R
import com.moveis.helloworld.restservice.Categoria
import com.moveis.helloworld.restservice.ForumWebClient
import com.moveis.helloworld.restservice.ICallbackResponse
import kotlinx.android.synthetic.main.activity_add_categoria.*

class AddComentarioActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_categoria)

        // Ativando action bar de voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        buttonSave.setOnClickListener { save() }
    }

    fun save(){
        // Ativando progress bar
        progressbar.visibility = ProgressBar.VISIBLE

        val cat = Categoria(nome=editTextNome.text.toString())
        ForumWebClient().insertCategoria(cat, object: ICallbackResponse<Categoria> {
            override fun success(instance: Categoria) {
                // Desativando progress bar
                progressbar.visibility = ProgressBar.INVISIBLE
                toast("Salvo com sucesso!")
            }
        })
        editTextNome.setText("")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if(id == R.id.home){
            // Trata o click do botão voltar
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
