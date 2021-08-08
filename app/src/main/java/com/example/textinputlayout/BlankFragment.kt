package com.example.textinputlayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.textinputlayout.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
  private  var _binding:FragmentBlankBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    _binding = FragmentBlankBinding.inflate(inflater,
      container,
      false)

    return binding.root

  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    //do our stuff here
    binding.textInputLayout2.setEndIconOnClickListener{
      binding.textInputEditText2.setText("Looks Like So")
      Toast.makeText(requireContext(), "Human", Toast.LENGTH_SHORT).show()
    }

    binding.textInputEditText3.addTextChangedListener{
      val size = it?.length
      if(size!!<10){
        binding.textInputEditText3.error = "No two small"
      }else if(size>10)
        binding.textInputEditText3.error = "No two large"
      else
        binding.textInputEditText3.error = null

    }


  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}