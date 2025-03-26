package sanchez.abel.examen2_sanchezabel

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleContacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_contacto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var bundle: Bundle? = intent.extras

        val nombre: TextView = findViewById(R.id.tv_nombreDetalle)
        val compania: TextView = findViewById(R.id.tv_companiaDetalle)
        val correo: TextView = findViewById(R.id.tv_correoDetalle)
        val telefono: TextView = findViewById(R.id.tv_telefonoDetalle)
        val btnLlamar: Button = findViewById(R.id.btn_llamar)

        if(bundle!=null){
            nombre.setText(bundle.getString("nombre")+" "+bundle.getString("apellido"))
            compania.setText(bundle.getString("compania"))
            correo.setText(bundle.getString("correo"))
            telefono.setText(bundle.getString("telefono"))
            btnLlamar.setText("Llamar a "+bundle.getString("nombre"))
        }
    }
}