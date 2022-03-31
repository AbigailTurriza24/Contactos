package com.example.contactos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    var Lista:ListView?=null
    var adapter:AdaptadorCustom?=null
companion object{
    var contacto:ArrayList<Contacto>?=null

    fun agregarCon(contactos: Contacto){
        contacto?.add(contactos)
    }
}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        contacto= ArrayList()
        contacto!!.add(Contacto("Abigail","Turriza","Corporativo Nestle",17,70.10F,"Felipe Carrillo Puerto 77229","9837008196","abigailturrizanovelo06@gmail.com",R.drawable.foto_04))
        val lista=findViewById<ListView>(R.id.lista)
        val adapter=AdaptadorCustom(this, contacto!!)
        lista?.adapter=adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.newview->{
               val intent=Intent(this,Detalle::class.java)
                startActivity(intent)
                return true

            }else->{ return super.onOptionsItemSelected(item)}
        }

        }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }

}