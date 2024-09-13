package com.example.aula05

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_constraint)

        val nome = findViewById<TextView>(R.id.nome_pessoa)
        nome.setText("Professor Luan")

        val idade = findViewById<TextView>(R.id.idade_pessoa)
        idade.setText("34")

        val profissao = findViewById<TextView>(R.id.profissao_pessoa)
        profissao.setText("Professor sofrido")
    }
}