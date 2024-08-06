package com.riverju.navigation
//com.riverju.navigation/NavActivity.kt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.Menu
import android.view.MenuItem

class NavActivity : AppCompatActivity() {
    // Fragmentos que se cargarán en la actividad
    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    private val thirdFragment = ThirdFragment()
    private val fourFragment = FourFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el layout para la actividad
        setContentView(R.layout.activity_nav)

        // Configuración de la Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Inicialización del BottomNavigationView y su listener
        val navigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Cargar el primer fragmento por defecto
        loadFragment(firstFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflar el menú de opciones
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Manejar los clics en los elementos del menú de opciones
        return when (item.itemId) {
            R.id.action_settings -> {
                // Acción al seleccionar 'settings'
                true
            }
            R.id.action_asistencia -> {
                // Acción al seleccionar 'asistencia'
                true
            }
            R.id.nav_refresh -> {
                // Acción al seleccionar 'refresh'
                true
            }
            R.id.nav_logout -> {
                // Acción al seleccionar 'settings'
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Listener para los ítems del BottomNavigationView
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.firstFragment -> {
                    loadFragment(firstFragment)
                    true
                }
                R.id.secondFragment -> {
                    loadFragment(secondFragment)
                    true
                }
                R.id.thirdFragment -> {
                    loadFragment(thirdFragment)
                    true
                }
                R.id.fourFragment -> {
                    loadFragment(fourFragment)
                    true
                }
                else -> false
            }
        }

    // Método para cargar un fragmento en el contenedor
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.commit()
    }
}
