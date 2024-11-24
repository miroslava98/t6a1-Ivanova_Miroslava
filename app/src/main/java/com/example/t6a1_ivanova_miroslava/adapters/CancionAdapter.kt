package com.example.t6a1_ivanova_miroslava.adapters

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.t6a1_ivanova_miroslava.R
import com.example.t6a1_ivanova_miroslava.databinding.ListItemCancionBinding
import com.example.t6a1_ivanova_miroslava.pojos.Cancion
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancionAdapter(private val canciones: List<Cancion>) :
    RecyclerView.Adapter<CancionAdapter.ViewHolder>() {

    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_cancion, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = canciones.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val cancion = canciones.get(position)
        with(holder) {
            setListener(cancion)
            binding.nombreCancion.text = cancion.getId().toString() + "." + cancion.getNombre()
            binding.textoDetalleCancion.text = cancion.getDuracion().toString()
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ListItemCancionBinding.bind(view)

        fun setListener(cancion: Cancion) {
            binding.root.setOnClickListener {
                val dialogView =
                    LayoutInflater.from(itemView.context).inflate(R.layout.dialog_cancion, null)
                val tvCancionNombre = dialogView.findViewById<TextView>(R.id.tnumCancionNombre)
                tvCancionNombre.text = cancion.getId().toString() + "." + cancion.getNombre()

                val tvDuracionCancion = dialogView.findViewById<TextView>(R.id.tDuracionCancion)
                tvDuracionCancion.text = cancion.getDuracion().toString()

                MaterialAlertDialogBuilder(itemView.context)
                    .setTitle("Canción seleccionada: ")
                    .setView(dialogView)
                    .setPositiveButton(
                        "Aceptar", DialogInterface.OnClickListener { dialog, i ->
                            dialog.cancel()
                        })

                    .setCancelable(false)
                    .show()


            }
        }
    }
}