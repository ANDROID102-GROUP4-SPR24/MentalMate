package com.example.mentalmate_android__app

//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.Observer
//import com.example.mentalmate.databinding.FragmentInsightsBinding
//
//class InsightsFragment : Fragment() {
//
//    private var _binding: FragmentInsightsBinding? = null
//    private val binding get() = _binding!!
//
//    private val viewModel: UserViewModel by viewModels {
//        UserViewModelFactory(UserRepository(RetrofitInstance.api))
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        _binding = FragmentInsightsBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.getInsights("Tell me a joke").observe(viewLifecycleOwner, Observer { insight ->
//            binding.textViewInsight.text = insight
//        })
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}
