package sanchez.abel.examen2_sanchezabel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var contactos = ArrayList<Contacto>()
    var adapter: ContactoAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        construirContactos()

        var listView: ListView = findViewById(R.id.lv_contactos)

        adapter = ContactoAdapter(this, contactos)

        listView.adapter = adapter

    }


    fun construirContactos() {
        contactos.add(Contacto("Juan", "Pérez", "juan.perez@gmail.com", "555-123-4567","#FFFFF","Ley"))
        contactos.add(Contacto("Ana López","López", "ana.lopez@hotmail.com", "555-987-6543","#FFFFF","Ley"))
        contactos.add(Contacto("Carlos Ramírez", "Ramírez", "carlos.ramirez@yahoo.com", "555-222-3333","#FFFFF","Ley"))
        contactos.add(Contacto("Laura Gómez", "Gómez", "laura.gomez@outlook.com", "555-444-5555","#FFFFF","Ley"))
    }
}


class ContactoAdapter: BaseAdapter {
    var context: Context? = null
    var contactos = ArrayList<Contacto>()

    constructor(context: Context, juegos: ArrayList<Contacto>){
        this.context = context
        this.contactos = juegos
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var contacto = contactos[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.item_contacto, null)

        var nombre: TextView = vista.findViewById(R.id.tv_nombreContacto)  as TextView
        var compania: TextView = vista.findViewById(R.id.tv_nombreCompania)  as TextView
        var contenedor: LinearLayout = vista.findViewById(R.id.ll_contenedorContacto)  as LinearLayout


        nombre.setText(contacto.nombre)
        compania.setText(contacto.apellido)

        contenedor.setOnClickListener{
            var intent: Intent = Intent(context, DetalleContacto::class.java)
            intent.putExtra("nombre", contacto.nombre)
            intent.putExtra("apellido", contacto.apellido)
            intent.putExtra("correo", contacto.email)
            intent.putExtra("telefono", contacto.telefono)
            intent.putExtra("compania", contacto.compania)
            intent.putExtra("color", contacto.color)

            context!!.startActivity(intent)
        }

        return vista
    }

    override fun getCount(): Int {
        return contactos.size
    }

    override fun getItem(position: Int): Any {
        return contactos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}