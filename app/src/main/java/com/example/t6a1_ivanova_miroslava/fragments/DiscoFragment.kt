package com.example.t6a1_ivanova_miroslava.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6a1_ivanova_miroslava.adapters.DiscoAdapter
import com.example.t6a1_ivanova_miroslava.adapters.OnClickListener
import com.example.t6a1_ivanova_miroslava.databinding.FragmentDiscoBinding
import com.example.t6a1_ivanova_miroslava.pojos.Disco
import com.example.t6a1_ivanova_miroslava.pojos.DiscoDatos


class DiscoFragment : Fragment(), OnClickListener {
    private lateinit var discoAdapter: DiscoAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    private lateinit var binding: FragmentDiscoBinding
    private lateinit var listener: DiscosListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiscoBinding.inflate(inflater, container, false)


        discoAdapter = DiscoAdapter(DiscoDatos.DISCOS, this)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        binding.recyclerIdDisco.apply {
            layoutManager = linearLayoutManager
            adapter = discoAdapter
            addItemDecoration(itemDecoration)
        }

        return binding.root
    }


    fun setDiscosListener(listener: DiscosListener) {
        this.listener = listener
    }

    override fun onClick(disco: Disco) {
        if (listener != null) {
            listener.onDiscoSeleccionado(disco)
        }
    }


}
