package com.moveis.helloworld.activities

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import com.moveis.helloworld.R
import com.moveis.helloworld.adapters.ListTopicoAdapter
import kotlinx.android.synthetic.main.activity_topicos.*

class TopicosActivity : BaseActivity() {
    var listTopicoAdapter: ListTopicoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topicos)


        // Inicializa o adaptar
        listTopicoAdapter = ListTopicoAdapter(this)
        // list é pego automático pelo ID na View
        // Seta o adapter na view
        list.adapter = listTopicoAdapter

        // Definir evento
        list.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            toast("Tópico: ${listTopicoAdapter!!.getItem(i)!!.titulo}")
        }

        // Atualiza a listagem
        swipeToRefresh.setOnRefreshListener {
            swipeToRefresh.isRefreshing = false
            listTopicoAdapter!!.dataUpdate()
        }

        // Ativando o FloatingActionButton
        buttonadd.setOnClickListener() {
            var intent = Intent(this, AddTopicoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        // Atualia os dados do adapter na view
        listTopicoAdapter!!.dataUpdate()
    }

}
