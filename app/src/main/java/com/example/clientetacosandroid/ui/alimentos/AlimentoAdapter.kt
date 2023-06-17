package com.example.clientetacosandroid.ui.alimentos

import android.graphics.BitmapFactory
import android.icu.text.DecimalFormat
import android.icu.text.DecimalFormatSymbols
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clientetacosandroid.R
import com.example.clientetacosandroid.data.model.Alimento

class AlimentoAdapter (private val onClick: (Alimento) -> Unit) :
    RecyclerView.Adapter<AlimentoAdapter.ViewHolder>() {

    class ViewHolder(view: View, val onClick: (Alimento) -> Unit) : RecyclerView.ViewHolder(view) {
        //val txtId: TextView
        val txtNombre: TextView
        val txtPrecio: TextView
        val imagen: ImageView
        var alimentoAsignado: Alimento? = null;

        init {
            //txtId = view.findViewById(R.id.txtId)
            txtNombre = view.findViewById(R.id.txtNombre)
            txtPrecio = view.findViewById(R.id.txtPrecio)
            imagen = view.findViewById(R.id.imagen)
            view.setOnClickListener( {
                alimentoAsignado?.let {
                    onClick(it)
                }
            })
        }
    }

    lateinit var alimentos: Array<Alimento>

    var contador = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        var layout = R.layout.alimento_elemento_layout

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(layout, viewGroup, false)

        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val alimento: Alimento = alimentos[position]
        //viewHolder.txtId.text = alimento.descripcion;
        viewHolder.txtNombre.text = alimento.nombre;

        val symbols = DecimalFormatSymbols()
        symbols.setGroupingSeparator('\'')
        symbols.setDecimalSeparator('.')
        val decimalFormat = DecimalFormat("$ #,###.00", symbols)

        viewHolder.txtPrecio.text = decimalFormat.format(alimento.precio)

        val imagenByteArray: ByteArray =
            Base64.decode(alimento.imagen?.imagenBytes, Base64.DEFAULT)
        if (imagenByteArray != null) {
            var imagenBitmap =
            BitmapFactory.decodeByteArray(
                imagenByteArray,
                0,
                imagenByteArray.size
            )
            viewHolder.imagen.setImageBitmap(imagenBitmap)
        }
        viewHolder.alimentoAsignado = alimento
        Log.d("hi",":D");
    }

    override fun getItemCount() = alimentos.size

    fun asignarCursos(cursos: List<Alimento>) {
        this.alimentos = cursos.toTypedArray()
        notifyDataSetChanged()
    }
}