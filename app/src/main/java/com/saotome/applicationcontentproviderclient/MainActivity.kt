package com.saotome.applicationcontentproviderclient

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var notasRecycler: RecyclerView
    lateinit var notasAtualizarBotao: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notasAtualizarBotao = findViewById(R.id.cliente_botao_atualizar)
        notasRecycler = findViewById(R.id.cliente_lista)
        getContentProvider ()

        notasAtualizarBotao.setOnClickListener {
            getContentProvider()
        }

    }

    // Método responsável por fazer a consulta ao ContentProvider da outra aplicação
    private fun getContentProvider () {
        try {
            val url = "content://com.saotome.applicationcontentprovider.provider/notas"
            val data = Uri.parse(url)
            val cursor: Cursor? =
                contentResolver.query(data, null, null, null, "titulo")
            notasRecycler.apply {
                layoutManager = LinearLayoutManager (this@MainActivity)
                adapter = ClienteAdapter (cursor as Cursor)
            }
        }
        catch (ex: Exception) {
            ex.printStackTrace()
        }

    }
}