package com.moveis.helloworld.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import com.moveis.helloworld.R
import com.moveis.helloworld.restservice.Categoria
import com.moveis.helloworld.restservice.ForumWebClient
import com.moveis.helloworld.restservice.ICallbackResponse
import com.moveis.helloworld.restservice.Topico
import kotlinx.android.synthetic.main.activity_add_topico.*

class AddTopicoActivity : BaseActivity() {

    var listCategorias: List<Categoria>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_topico)

        // Ativando action bar de voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        buttonSave.setOnClickListener { save() }

    }

    fun save() {
        // Ativando progress bar
        progressbar.visibility = ProgressBar.VISIBLE

        val topico = Topico(titulo = editTextTitulo.text.toString(), autor = editTextAutor.text.toString(), descricao = editTextDescricao.text.toString(), categoria = editTextCategoria.text.toString().toInt())
        ForumWebClient().insertTopico(topico, object : ICallbackResponse<Topico> {
            override fun success(instance: Topico) {

                // Desativando progress bar
                progressbar.visibility = ProgressBar.INVISIBLE
                toast("Salvo com sucesso!")
                limparCampos()
            }
        })

    }

    fun limparCampos() {
        editTextTitulo.setText("")
        editTextAutor.setText("")
        editTextDescricao.setText("")
        editTextCategoria.setText("")
    }

//    fun carregarListaCategorias() {
//        // Ativando progress bar
//        progressbar.visibility = ProgressBar.VISIBLE
//
//        ForumWebClient().getCategorias(object : ICallbackResponse<List<Categoria>> {
//            override fun success(instance: List<Categoria>) {
//                listCategorias = instance
//
//                // Seta invisible no progress bar
//                progressbar.visibility = ProgressBar.INVISIBLE
//            }
//        })
//    }

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
