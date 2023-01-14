package vk.cup.dzen.presentation.poll

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import vk.cup.dzen.presentation.base.BaseFragment

@AndroidEntryPoint
internal class PollFragment : BaseFragment<PollViewModel>() {

    override fun provideViewModel(): PollViewModel {
        val pollViewModel by viewModels<PollViewModel>()
        return pollViewModel
    }

}
