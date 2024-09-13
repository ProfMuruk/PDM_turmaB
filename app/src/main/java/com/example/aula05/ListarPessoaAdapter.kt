package com.example.aula05

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aula05.model.Pessoa
import java.text.DecimalFormat

class ListarPessoaAdapter(private val pessoas : List<Pessoa>)
    : RecyclerView.Adapter<ListarPessoaAdapter.ViewHolder>() {

        class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
            val nomePessoa: TextView = itemView.findViewById(R.id.nome_pessoa)
            val idadePessoa: TextView = itemView.findViewById(R.id.idade_pessoa)
            val profissaoPessoa: TextView = itemView.findViewById(R.id.profissao_pessoa)
            val alturaPessoa : TextView = itemView.findViewById(R.id.altura_pessoa)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.pessoa_activity, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val formatador = DecimalFormat("#,###.00")

        val pessoa = pessoas[position]

        val alturaFormatada = formatador.format(pessoa.altura)

        holder.nomePessoa.text = pessoa.nome
        holder.idadePessoa.text = pessoa.idade.toString()
        holder.profissaoPessoa.text = pessoa.profissao
        holder.alturaPessoa.text = alturaFormatada


    }

    override fun getItemCount(): Int = pessoas.size

}