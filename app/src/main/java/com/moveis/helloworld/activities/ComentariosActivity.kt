package com.moveis.helloworld.activities

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import com.moveis.helloworld.R
import com.moveis.helloworld.adapters.ListComentarioAdapter
import kotlinx.android.synthetic.main.activity_comentarios.*

class ComentariosActivity : BaseActivity() {
    var listComentarioAdapter: ListComentarioAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comentarios)

        // Inicializa o adaptar
        listComentarioAdapter = ListComentarioAdapter(this)
        // list é pego automático pelo ID na View
        // Seta o adapter na view
        list.adapter = listComentarioAdapter

        // Definir evento
        list.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            toast("Comentario: ${listComentarioAdapter!!.getItem(i)!!.comentario}")
        }

        // Atualiza a listagem
        swipeToRefresh.setOnRefreshListener {
            swipeToRefresh.isRefreshing = false
            listComentarioAdapter!!.dataUpdate()
        }

        // Ativando o FloatingActionButton
        buttonadd.setOnClickListener() {
            var intent = Intent(this, AddComentarioActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        // Atualia os dados do adapter na view
        listComentarioAdapter!!.dataUpdate()
    }

}
