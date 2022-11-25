package ir.rev.navigationandretrofit.ui.secondFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import ir.rev.navigationandretrofit.R
import ir.rev.navigationandretrofit.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var viewModel: SecondViewModel
    private lateinit var binding: FragmentSecondBinding
    private val args: SecondFragmentArgs by navArgs() //аргументы для передачи

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // устанавливаю данные что получили с 1 фрагмента
        binding.textView.text = args.classForTest.text

        // картинка из интернета
        Glide.with(this).load(CAT_URL).into(binding.imageViewForGlide)

        // запрос в сеть
        binding.buttonBankIsOnline.setOnClickListener { viewModel.checkBankIsOnline() }
        viewModel.isBankOnlineLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "банк онлайн $it", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val CAT_URL = "https://i.pinimg.com/originals/22/cc/3b/22cc3bfc1fede6e2306cac7265515aa3.jpg"
    }

}