package vk.cup.dzen.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import vk.cup.core_recycler.Cell
import vk.cup.dzen.R
import vk.cup.dzen.databinding.DzenFragmentBinding
import vk.cup.dzen.presentation.base.recycler.DzenAdapter
import vk.cup.dzen.presentation.base.recycler.EndlessRecycler


internal abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    protected lateinit var binding: DzenFragmentBinding

    protected lateinit var viewModel: BaseViewModel

    abstract fun provideViewModel(): VM

    private val dzenAdapter by lazy { DzenAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DzenFragmentBinding.inflate(LayoutInflater.from(requireContext()))
        viewModel = provideViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dzenRecycler.apply {
            addOnScrollListener(object : EndlessRecycler(
                binding.dzenRecycler.layoutManager as LinearLayoutManager
            ) {
                override fun addItems() {
                    viewModel.loadData()
                }
            })
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                ).apply {
                    ResourcesCompat.getDrawable(resources, R.drawable.ic_divider, activity?.theme)?.let {
                        setDrawable(it)
                    }
                }
            )
            adapter = dzenAdapter
        }
        viewModel.getDataLiveData().observe(viewLifecycleOwner, ::onDataReceive)
        viewModel.loadData()
    }

    private fun onDataReceive(cellsList: List<Cell>) {
        dzenAdapter.submitList(cellsList)
    }

}
