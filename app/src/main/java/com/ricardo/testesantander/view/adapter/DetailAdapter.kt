package com.ricardo.testesantander.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ricardo.testesantander.R
import com.ricardo.testesantander.model.Launches
import kotlinx.android.synthetic.main.item_detail.view.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat

class DetailAdapter(
    private val context: Context,
    private var launches: Launches
) : RecyclerView.Adapter<DetailAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_detail, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = launches.statementList!!.size

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {

        val launches: Launches = launches
        p0.bind(launches, p1)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tipo: TextView = itemView.textTipo
        val descricao: TextView = itemView.textDescricao
        val data: TextView = itemView.textData
        val valor: TextView = itemView.textValor

        fun bind(launches: Launches, p1: Int) {

            val nf: NumberFormat = DecimalFormat(",##0.00")

            val dataUs: String? = launches.statementList!!.get(p1).date
            val oldFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            val newFormat: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")

            tipo.text = launches.statementList!!.get(p1).title
            descricao.text = launches.statementList!!.get(p1).desc.toString()
            data.text = newFormat.format(oldFormat.parse(dataUs))
            valor.text = nf.format(launches.statementList!!.get(p1).vvalue)
        }
    }
}