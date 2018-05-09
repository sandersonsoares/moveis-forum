package com.moveis.helloworld.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ProgressBar
import android.widget.TextView
import com.moveis.helloworld.R
import com.moveis.helloworld.restservice.Comentario
import com.moveis.helloworld.restservice.ForumWebClient
import com.moveis.helloworld.restservice.ICallbackResponse

class ListComentarioAdapter(private val activity: Activity) : BaseAdapter() {

    var list: List<Comentario>? = null
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

        ForumWebClient().getComentarios(object: ICallbackResponse<List<Comentario>> {
            override fun success(instance: List<Comentario>) {
                list = instance
                // Ajusta alterações
                this@ListComentarioAdapter.notifyDataSetChanged()
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

    override fun getItem(i: Int): Comentario? {
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
            view = this.mInflator.inflate(R.layout.comentario_row, parent, false)
        } else {
            view = convertView
        }

        var labelComentario = view?.findViewById<TextView>(R.id.Comentario)
        labelComentario?.text = getItem(i)?.comentario
        return view
    }
}