package com.example.nezhahira_3tic.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nezhahira_3tic.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList = ArrayList<HashMap<String, String>>()
        val titles = arrayOf("Pentingnya Tanaman", "Manfaat Oksigen", "Penghijauan Kota", "Daur Ulang Sampah", "Konservasi Air", "Edukasi Lingkungan")
        val descs = arrayOf(
            "Tanaman menjaga keseimbangan ekosistem bumi.",
            "Setiap pohon menghasilkan oksigen bersih untuk hidup.",
            "Penghijauan mengurangi polusi udara perkotaan.",
            "Daur ulang mengurangi volume sampah plastik.",
            "Konservasi air menjaga ketersediaan sumber air bersih.",
            "Edukasi sejak dini menumbuhkan kepedulian alam."
        )

        for (i in titles.indices) {
            val map = HashMap<String, String>()
            map["line1"] = titles[i]
            map["line2"] = descs[i]
            dataList.add(map)
        }

        val simpleAdapter = SimpleAdapter(
            requireContext(),
            dataList,
            android.R.layout.simple_list_item_2,
            arrayOf("line1", "line2"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        binding.listViewMore.adapter = simpleAdapter
        binding.listViewMore.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(requireContext(), titles[position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
