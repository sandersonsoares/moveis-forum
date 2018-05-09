package com.moveis.helloworld.activities

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import com.moveis.helloworld.R
import com.moveis.helloworld.adapters.ListCategoriaAdapter
import kotlinx.android.synthetic.main.activity_categorias.*

class CategoriasActivity : BaseActivity() {
    var listCategoriaAdapter: ListCategoriaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)


        // Inicializa o adaptar
        listCategoriaAdapter = ListCategoriaAdapter(this)
        // list é pego automático pelo ID na View
        // Seta o adapter na view
        list.adapter = listCategoriaAdapter

        // Definir evento
        list.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            toast("Categoria: ${listCategoriaAdapter!!.getItem(i)!!.nome}")
        }

        // Atualiza a listagem
        swipeToRefresh.setOnRefreshListener {
            swipeToRefresh.isRefreshing = false
            listCategoriaAdapter!!.dataUpdate()
        }

        // Ativando o FloatingActionButton
        buttonadd.setOnClickListener() {
            var intent = Intent(this, AddCategoriaActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        // Atualia os dados do adapter na view
        listCategoriaAdapter!!.dataUpdate()
    }

}
