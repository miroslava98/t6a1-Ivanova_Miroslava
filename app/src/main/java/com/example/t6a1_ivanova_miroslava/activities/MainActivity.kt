package com.example.t6a1_ivanova_miroslava.activities

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.t6a1_ivanova_miroslava.R
import com.example.t6a1_ivanova_miroslava.adapters.OnClickDiscoListener
import com.example.t6a1_ivanova_miroslava.databinding.ActivityMainBinding
import com.example.t6a1_ivanova_miroslava.fragments.CancionFragment
import com.example.t6a1_ivanova_miroslava.fragments.DiscoFragment
import com.example.t6a1_ivanova_miroslava.fragments.DiscosListener
import com.example.t6a1_ivanova_miroslava.pojos.Disco

class MainActivity : AppCompatActivity(), DiscosListener {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var discoFragment: DiscoFragment
    private lateinit var cancionFragment: CancionFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (savedInstanceState == null) {
                discoFragment = DiscoFragment()
                loadFragment(discoFragment)
                discoFragment.setDiscosListener(this)

            } else {
                if (savedInstanceState == null) {
                    loadFragment(DiscoFragment(), R.id.frgDiscos)
                    loadFragment(CancionFragment(), R.id.frgCanciones)
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(mBinding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadFragment(fragment: Fragment, containerId: Int = R.id.frgDiscos) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onDiscoSeleccionado(disco: Disco) {
        if (disco != null) {
            var hayCancion = supportFragmentManager.findFragmentById(R.id.frgCanciones) != null

            if (hayCancion) {
                cancionFragment = CancionFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frgCanciones, cancionFragment)
                transaction.commitNow()
                cancionFragment.mostrarDetalle(disco.getCanciones())
            } else {
                cancionFragment = CancionFragment.newInstance(disco.getCanciones())
                loadFragment(cancionFragment)
            }
        }

    }
}