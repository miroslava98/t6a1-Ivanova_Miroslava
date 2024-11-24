package com.example.t6a1_ivanova_miroslava.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t6a1_ivanova_miroslava.R
import com.example.t6a1_ivanova_miroslava.databinding.ListItemDiscoBinding
import com.example.t6a1_ivanova_miroslava.pojos.Disco

class DiscoAdapter(private val discos: List<Disco>, private val listener: OnClickListener) :
    RecyclerView.Adapter<DiscoAdapter.ViewHolder>() {

    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_disco, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = discos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val disco = discos.get(position)
        with(holder) {
            setListener(disco)
            binding.tNombreAlbum.text = disco.getNombre()
            binding.tArtistaAnyo.text = disco.getArtista() + " " + disco.getAnyo()
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ListItemDiscoBinding.bind(view)

        fun setListener(disco: Disco) {
            binding.root.setOnClickListener {
                listener.onClick(disco)
            }
        }
    }

}