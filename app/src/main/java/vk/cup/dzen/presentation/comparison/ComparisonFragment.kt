package vk.cup.dzen.presentation.comparison

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import vk.cup.dzen.presentation.base.BaseFragment

@AndroidEntryPoint
internal class ComparisonFragment : BaseFragment<ComparisonViewModel>() {

    override fun provideViewModel(): ComparisonViewModel {
        val comparisonViewModel by viewModels<ComparisonViewModel>()
        return comparisonViewModel
    }

}
