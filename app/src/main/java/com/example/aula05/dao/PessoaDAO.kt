package com.example.aula05.dao

import com.example.aula05.model.Pessoa

class PessoaDAO {

    fun adicionar(pessoa : Pessoa){
        pessoas.add(pessoa)
    }
    fun buscarPessoas() : List<Pessoa>{
        return pessoas.toList()
    }
    companion object{
        private val pessoas = mutableListOf<Pessoa>()
    }
}