package com.saotome.applicationcontentproviderclient

import android.annotation.SuppressLint
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ClienteAdapter (private val mCursor: Cursor): RecyclerView.Adapter<ClienteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder =
        ClienteViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.cliente_item, parent, false))


    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.clienteTitulo.text = mCursor.getString(mCursor.getColumnIndex("titulo") as Int)
        holder.clienteDescricao.text = mCursor.getString(mCursor.getColumnIndex("descricao") as Int)
    }

    override fun getItemCount(): Int = mCursor.count
}

class ClienteViewHolder(itemView: View): RecyclerView.ViewHolder (itemView) {
    val clienteTitulo = itemView.findViewById(R.id.cliente_item_titulo) as TextView
    val clienteDescricao = itemView.findViewById(R.id.cliente_item_descricao) as TextView
}