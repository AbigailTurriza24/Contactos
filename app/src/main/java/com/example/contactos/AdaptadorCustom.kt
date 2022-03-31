package com.example.contactos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorCustom(var contexto: Context, items:ArrayList<Contacto>):BaseAdapter() {
   var items:ArrayList<Contacto>?=null
    init {
        this.items=items
    }

    override fun getCount(): Int {
        return this.items?.count()!!
    }

    override fun getItem(p0: Int): Any {
        return this.items?.get(p0)!!
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var viewHolder:ViewHolder?=null
        var vista:View?=p1
        if(vista==null){
            vista =LayoutInflater.from(contexto).inflate(R.layout.template_contactos,null)
            viewHolder=ViewHolder(vista)
            vista.tag=viewHolder

        }else{
            viewHolder=vista.tag as? ViewHolder
        }
        val item=getItem(p0) as Contacto
        viewHolder?.nombre?.text=item.nombre +" "+item.apellido
        viewHolder?.empresa?.text=item.empresa
        viewHolder?.foto?.setImageResource(item.foto)

        return vista!!


    }
    private class ViewHolder(vista:View){
        var nombre: TextView?=null
        var empresa: TextView?=null
        var foto: ImageView?=null
        init {
            nombre=vista.findViewById(R.id.txtNombre)
            foto=vista.findViewById(R.id.imgFoto)
            empresa=vista.findViewById(R.id.txtEmpresa)
        }
    }

}