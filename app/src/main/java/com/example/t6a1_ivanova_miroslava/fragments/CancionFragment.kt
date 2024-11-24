package com.example.t6a1_ivanova_miroslava.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6a1_ivanova_miroslava.R
import com.example.t6a1_ivanova_miroslava.adapters.CancionAdapter
import com.example.t6a1_ivanova_miroslava.databinding.FragmentCancionBinding
import com.example.t6a1_ivanova_miroslava.databinding.FragmentDiscoBinding
import com.example.t6a1_ivanova_miroslava.pojos.Cancion

private const val ARG_CANCIONES = "canciones"

class CancionFragment : Fragment() {


    private lateinit var binding: FragmentCancionBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration
    private lateinit var cancionAdapter: CancionAdapter

    private var canciones: List<Cancion>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CancionFragment", "Canciones recibidas: $canciones")
        if (savedInstanceState != null) {
            canciones = savedInstanceState.get(ARG_CANCIONES) as? List<Cancion>
        } else {
            arguments?.let {
                canciones = it.getSerializable(ARG_CANCIONES) as? List<Cancion>
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCancionBinding.inflate(inflater, container, false)


        if (!canciones.isNullOrEmpty()) {
            cancionAdapter = CancionAdapter(canciones!!)
            linearLayoutManager = LinearLayoutManager(context)
            itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

            binding.recyclerIdCancion.apply {
                layoutManager = linearLayoutManager
                adapter = cancionAdapter
                addItemDecoration(itemDecoration)

            }
        } else {
            Toast.makeText(context, "No hay canciones disponibles", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(ARG_CANCIONES, ArrayList(canciones))
    }

    companion object {
        @JvmStatic
        fun newInstance(canciones: List<Cancion>) =
            CancionFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CANCIONES, ArrayList(canciones))
                }
            }

    }
}