package com.innovators.eventmanagement.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.innovators.eventmanagement.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Filter.newInstance] factory method to
 * create an instance of this fragment.
 */
class Filter : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_filter, container, false)

        val chipGroupCity = view.findViewById<ChipGroup>(R.id.chipGroupCity)
        val chipGroupProfession = view.findViewById<ChipGroup>(R.id.chipGroupProfession)
        val btnApply = view.findViewById<MaterialButton>(R.id.btnApplyFilter)

        val cities = listOf("Mumbai", "Delhi", "Pune", "Bangalore", "Hyderabad")
        val professions = listOf("Make Artist", "Event Manager", "Photographer", "Decorator",
            "Caterers", "Mehendi Artist", "Fashion Designer",
            "Vintage Car Owner", "Choreographer")


        addChips(chipGroupCity, cities)
        addChips(chipGroupProfession, professions)

        btnApply.setOnClickListener {
            val selectedCity = getSelectedChipText(chipGroupCity)
            val selectedProfession = getSelectedChipText(chipGroupProfession)

        }

        return view
    }
    private fun addChips(chipGroup: ChipGroup, items: List<String>) {
        val inflater = LayoutInflater.from(requireContext())
        for (text in items) {
            val chip = inflater.inflate(R.layout.item_chip, chipGroup, false) as Chip
            chip.text = text
            chipGroup.addView(chip)
        }
    }
    private fun getSelectedChipText(chipGroup: ChipGroup): String? {
        val chipId = chipGroup.checkedChipId
        if (chipId != View.NO_ID) {
            val chip = chipGroup.findViewById<Chip>(chipId)
            return chip.text.toString()
        }
        return null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Filter.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Filter().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}