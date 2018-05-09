package com.moveis.helloworld.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ProgressBar
import android.widget.TextView
import com.moveis.helloworld.R
import com.moveis.helloworld.restservice.Topico
import com.moveis.helloworld.restservice.ForumWebClient
import com.moveis.helloworld.restservice.ICallbackResponse

class ListTopicoAdapter(private val activity: Activity) : BaseAdapter() {

    var list: List<Topico>? = null
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

        ForumWebClient().getTopicos(object: ICallbackResponse<List<Topico>> {
            override fun success(instance: List<Topico>) {
                list = instance
                // Ajusta alterações
                this@ListTopicoAdapter.notifyDataSetChanged()
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

    override fun getItem(i: Int): Topico? {
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
            view = this.mInflator.inflate(R.layout.topico_row, parent, false)
        } else {
            view = convertView
        }

        var labelTitulo = view?.findViewById<TextView>(R.id.Titulo)
        labelTitulo?.text = getItem(i)?.titulo
        return view
    }
}