package com.example.t6a1_ivanova_miroslava.pojos

import android.content.ClipData.Item
import java.io.Serializable

class Cancion(private var id: Int, private var nombre: String, private var duracion: Float) : Serializable{

    fun getId(): Int {
        return id
    }

    fun getNombre(): String {
        return nombre
    }

    fun getDuracion(): Float {
        return duracion
    }


}