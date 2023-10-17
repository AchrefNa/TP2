package com.example.tp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tp2.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onToast()
        binding.countButton.setOnClickListener {
            countMe()
        }

        binding.randomButton.setOnClickListener {
            val nb = binding.textviewFirst.text.toString().toInt()
            val action =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(nb)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun onToast(){
        binding.toastButton.setOnClickListener {
            val myToast = Toast.makeText(context, "hello toast", Toast.LENGTH_SHORT)
            myToast.show()
        }

    }
    private fun countMe() {
        val num = binding.textviewFirst.text.toString()
        val count = num.toInt() + 1
        binding.textviewFirst.text = count.toString()
    }
}