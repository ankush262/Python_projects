package com.geekymusketeers.taketoocare.mainFragments


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geekymusketeers.taketoocare.CheckerActivity
import com.geekymusketeers.taketoocare.Firstaid.firsrActivity
import com.geekymusketeers.taketoocare.MapsActivity
import com.geekymusketeers.taketoocare.databinding.FragmentStatisticsBinding
import com.geekymusketeers.taketoocare.insure.Insure
import com.geekymusketeers.taketoocare.remind.reminder
import com.geekymusketeers.taketoocare.sosfeature.SOSdialer

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class StatisticsFragment : Fragment() {

    private var _binding:FragmentStatisticsBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var db: DatabaseReference
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var userID: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentStatisticsBinding.inflate(inflater, container, false)

        binding.insurance.setOnClickListener {
            startActivity(Intent(requireActivity(), Insure::class.java))
        }
        binding.yt.setOnClickListener {
            startActivity(Intent(requireActivity(), firsrActivity::class.java))
        }
        binding.tytyty.setOnClickListener {
                startActivity(Intent(requireActivity(), CheckerActivity::class.java))
        }
        binding.logoutButton.setOnClickListener {
            startActivity(Intent(requireActivity(), reminder::class.java))
        }
        binding.SOS1.setOnClickListener {
            startActivity(Intent(requireActivity(), SOSdialer::class.java))

        }
        binding.logoutButton.setOnClickListener {
            startActivity(Intent(requireActivity(), MapsActivity::class.java))

        }

        return binding.root
    }

}