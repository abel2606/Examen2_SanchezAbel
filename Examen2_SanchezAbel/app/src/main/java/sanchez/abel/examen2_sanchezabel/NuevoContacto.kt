package sanchez.abel.examen2_sanchezabel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NuevoContacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_contacto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGuardar: Button = findViewById(R.id.btn_guardar)
        btnGuardar.setOnClickListener {
            val nombre = findViewById<EditText>(R.id.et_nuevoNombre).text.toString()
            val apellido = findViewById<EditText>(R.id.et_nuevoApellido).text.toString()
            val email = findViewById<EditText>(R.id.et_nuevoEmail).text.toString()
            val telefono = findViewById<EditText>(R.id.et_nuevoTelefono).text.toString()
            val color = generarColorAleatorio()
            val compania = findViewById<EditText>(R.id.et_nuevaCompania).text.toString()

            val nuevoContacto = Contacto(nombre, apellido, email, telefono, color, compania)
            MainActivity.contactos.add(nuevoContacto)

            finish()
        }

    }

    fun generarColorAleatorio(): String {
        val random = (0..255)
        val r = random.random()
        val g = random.random()
        val b = random.random()

        return String.format("#%02X%02X%02X", r, g, b)
    }

}