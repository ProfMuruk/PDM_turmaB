package com.example.aula05.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.aula05.model.Pessoa

class PessoaDAO(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_NAME = "pessoa.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_PESSOAS = "Pessoas"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "nome"
        private const val COLUMN_PROFISSAO = "profissao"
        private const val COLUMN_ALTURA = "altura"
        private const val COLUMN_IDADE = "idade"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = """
            CREATE TABLE $TABLE_PESSOAS(
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT NOT NULL,
                $COLUMN_ALTURA REAL NOT NULL,
                $COLUMN_IDADE INTEGER NOT NULL,
                $COLUMN_PROFISSAO TEXT NOT NULL
            )
        """.trimIndent()
    }

    fun adicionar(pessoa : Pessoa){
        pessoas.add(pessoa)
    }
    fun buscarPessoas() : List<Pessoa>{
        return pessoas.toList()
    }

}