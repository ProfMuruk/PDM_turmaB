package com.example.aula05.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.aula05.model.Pessoa
import java.math.BigDecimal

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

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PESSOAS")
        onCreate(db)
    }

    fun adicionar(pessoa : Pessoa){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, pessoa.nome)
            put(COLUMN_ALTURA, pessoa.altura.toDouble())
            put(COLUMN_IDADE, pessoa.idade)
            put(COLUMN_PROFISSAO, pessoa.profissao)
        }

        db.insert(TABLE_PESSOAS, null, values)
        db.close()
    }
    fun buscarPessoas() : List<Pessoa>{
        val pessoas = mutableListOf<Pessoa>()
        val db = readableDatabase
        val cursor : Cursor = db.rawQuery("SELECT * FROM $TABLE_PESSOAS", null)

        if(cursor.moveToFirst()){
            do{
                val nome = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
                val idade = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IDADE))
                val profissao = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PROFISSAO))
                val altura = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALTURA))

                pessoas.add(Pessoa(nome, idade.toInt(), profissao, BigDecimal(altura)))
            }while(cursor.moveToNext())
        }
        cursor.close()
        db.close()

        return pessoas
    }

}