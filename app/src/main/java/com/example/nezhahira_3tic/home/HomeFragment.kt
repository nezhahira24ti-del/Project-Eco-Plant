package com.example.nezhahira_3tic.home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.nezhahira_3tic.DetailActivity
import com.example.nezhahira_3tic.LoginActivity
import com.example.nezhahira_3tic.databinding.FragmentHomeBinding
import com.example.nezhahira_3tic.home.pertemuan_5.LimaActivity
import com.example.nezhahira_3tic.home.pertemuan_6.EnamActivity
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = requireContext().getSharedPreferences("EcoPlantPrefs", MODE_PRIVATE)

        binding.btnDetailHome.setOnClickListener {
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        binding.tvLihatSemua.setOnClickListener {
            Snackbar.make(view, "Menampilkan semua daftar tanaman", Snackbar.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.putBoolean("isLogin", false)
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        binding.button.setOnClickListener {
            Snackbar.make(view, "Membuka Materi Pertemuan 5 (Toolbar & NestedScrollView)", Snackbar.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(), LimaActivity::class.java))
        }

        binding.btnPert6.setOnClickListener {
            Snackbar.make(view, "Membuka Materi Pertemuan 6 (Dynamic Fragment)", Snackbar.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(), EnamActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
