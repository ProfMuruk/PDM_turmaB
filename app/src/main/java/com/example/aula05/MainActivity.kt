package com.example.aula05

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_constraint)

        val nome = findViewById<TextView>(R.id.nomePessoa)

        nome.setText("Luan Muruk")
    }
}