package vk.cup.dzen.presentation.rate

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import vk.cup.dzen.presentation.base.BaseFragment

@AndroidEntryPoint
internal class RateFragment : BaseFragment<RateViewModel>() {

    override fun provideViewModel(): RateViewModel {
        val rateViewModel by viewModels<RateViewModel>()
        return rateViewModel
    }

}
