package com.example.t6a1_ivanova_miroslava.fragments

import com.example.t6a1_ivanova_miroslava.pojos.Disco

interface DiscosListener {
    fun onDiscoSeleccionado(disco: Disco)
}