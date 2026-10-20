package com.example.nezhahira_3tic.home.pertemuan_6

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.nezhahira_3tic.R
import com.example.nezhahira_3tic.databinding.ActivityEnamBinding

class EnamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEnamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Tips & Perawatan Tanaman"
            setDisplayHomeAsUpEnabled(true)
        }

        replaceFragment(SatuFragment())

        binding.btnFrag1.setOnClickListener { replaceFragment(SatuFragment()) }
        binding.btnFrag2.setOnClickListener { replaceFragment(DuaFragment()) }
        binding.btnFrag3.setOnClickListener { replaceFragment(TigaFragment()) }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
