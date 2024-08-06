package com.riverju.navigation
//com.riverju.navigation/NavActivity.kt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem

class NavActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    // Fragmentos que se cargarán en la actividad
    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    private val thirdFragment = ThirdFragment()

    // DrawerLayout para el Navigation Drawer
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el layout para la actividad
        setContentView(R.layout.activity_nav)

        // Configuración de la Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Inicialización del DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)

        // Configuración del ActionBarDrawerToggle para manejar la apertura y cierre del drawer
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

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
                else -> false
            }
        }

    // Método para cargar un fragmento en el contenedor
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.commit()
    }

    // Manejar los clics en los ítems del Navigation Drawer
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                // Acción al seleccionar 'profile'
            }
            R.id.nav_info -> {
                // Acción al seleccionar 'info'
            }
            R.id.nav_logout -> {
                // Acción al seleccionar 'logout'
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    // Manejar el comportamiento del botón de retroceso
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

