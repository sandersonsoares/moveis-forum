package com.moveis.helloworld.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ProgressBar
import android.widget.TextView
import com.moveis.helloworld.R
import com.moveis.helloworld.restservice.Categoria
import com.moveis.helloworld.restservice.ForumWebClient
import com.moveis.helloworld.restservice.ICallbackResponse

class ListCategoriaAdapter(private val activity: Activity) : BaseAdapter() {

    var list: List<Categoria>? = null
    private val mInflator: LayoutInflater

    init {
        this.mInflator = LayoutInflater.from(activity)
        dataUpdate()
    }

    fun dataUpdate(){
        // Pega o progress bar
        var progressbar = activity.findViewById<ProgressBar>(R.id.progressbar)

        // Seta visible no progress bar
        progressbar.visibility = ProgressBar.VISIBLE

        ForumWebClient().getCategorias(object: ICallbackResponse<List<Categoria>> {
            override fun success(instance: List<Categoria>) {
                list = instance
                // Ajusta alterações
                this@ListCategoriaAdapter.notifyDataSetChanged()
                // Seta invisible no progress bar
                progressbar.visibility = ProgressBar.INVISIBLE
            }
        })
    }

    override fun getCount(): Int {
        if(list == null){
            return 0
        }
        return list!!.size
    }

    override fun getItem(i: Int): Categoria? {
        if(list == null){
            return null
        }
        return list!![i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.categoria_row, parent, false)
        } else {
            view = convertView
        }

        var label = view?.findViewById<TextView>(R.id.titulo)
        label?.text = getItem(i)?.nome
        return view
    }
}