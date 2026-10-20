package com.example.nezhahira_3tic.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nezhahira_3tic.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sampleMessages = listOf(
            MessageModel("Monstera", "Tanaman hias daun berlubang unik.", "https://images.unsplash.com/photo-1614594975525-e45190c55d0b?w=200"),
            MessageModel("Lidah Mertua", "Pembersih udara alami di dalam ruangan.", "https://images.unsplash.com/photo-1599598425947-4408f6578d38?w=200"),
            MessageModel("Lidah Buaya", "Kaya manfaat untuk kulit dan rambut.", "https://images.unsplash.com/photo-1509423350716-97f9360b4e09?w=200"),
            MessageModel("Kunyit", "Tanaman rimpang obat tradisional.", "https://images.unsplash.com/photo-1615485290382-441e4d049cb5?w=200"),
            MessageModel("Cabai", "Tanaman sayur pedas penambah nafsu makan.", "https://images.unsplash.com/photo-1588883622613-54f0bac9d50a?w=200"),
            MessageModel("Kemangi", "Daun aromatik pelengkap lalapan.", "https://images.unsplash.com/photo-1618160702438-9b02ab6515c9?w=200"),
            MessageModel("Sirih Gading", "Tanaman rambat hias tahan banting.", "https://images.unsplash.com/photo-1614594975525-e45190c55d0b?w=200"),
            MessageModel("Jahe", "Rimpang hangat penambah stamina tubuh.", "https://images.unsplash.com/photo-1615485290382-441e4d049cb5?w=200"),
            MessageModel("Kaktus", "Tanaman gurun penyimpan air cadangan.", "https://images.unsplash.com/photo-1509423350716-97f9360b4e09?w=200"),
            MessageModel("Anggrek", "Bunga hias eksotis beraneka warna.", "https://images.unsplash.com/photo-1599598425947-4408f6578d38?w=200")
        )

        val adapter = MessageAdapter(requireContext(), sampleMessages)
        binding.listView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
