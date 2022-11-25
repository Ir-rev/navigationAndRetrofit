package ir.rev.navigationandretrofit.ui.firstFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ir.rev.navigationandretrofit.databinding.FragmentFirstBinding
import ir.rev.navigationandretrofit.ui.ClassForTest

class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstViewModel
    private lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // при нажатии на кнопку откроется второй экран в который будут переданы аргументы
        binding.buttonNavigation.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                ClassForTest(
                    binding.textInput.text.toString()
                )
            ))
        }
    }

}