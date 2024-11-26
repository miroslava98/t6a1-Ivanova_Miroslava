package com.example.t6a1_ivanova_miroslava.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6a1_ivanova_miroslava.R
import com.example.t6a1_ivanova_miroslava.adapters.OnClickListener
import com.example.t6a1_ivanova_miroslava.databinding.ActivityMainBinding
import com.example.t6a1_ivanova_miroslava.fragments.CancionFragment
import com.example.t6a1_ivanova_miroslava.fragments.CancionFragment.Companion.newInstance
import com.example.t6a1_ivanova_miroslava.fragments.DiscoFragment
import com.example.t6a1_ivanova_miroslava.fragments.DiscosListener
import com.example.t6a1_ivanova_miroslava.pojos.Cancion
import com.example.t6a1_ivanova_miroslava.pojos.Disco

class MainActivity : AppCompatActivity(), DiscosListener {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var cancionFragment: CancionFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        cancionFragment = CancionFragment()
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        if (savedInstanceState == null) {
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
            ) {
                loadFragment(DiscoFragment())
                loadFragment(CancionFragment())

            } else {
                loadFragment(DiscoFragment())

            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(mBinding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frgDiscos, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

//
//        cancionFragment = CancionFragment.newInstance(disco.getCanciones())
//        loadFragment(cancionFragment)


    override fun onDiscoSeleccionado(disco: Disco) {

        val frgDiscos: DiscoFragment =
            supportFragmentManager.findFragmentById(mBinding.frgDiscos.id) as DiscoFragment
        frgDiscos.setDiscosListener(this)
    }
}
