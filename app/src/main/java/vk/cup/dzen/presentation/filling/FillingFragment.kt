package vk.cup.dzen.presentation.filling

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import vk.cup.dzen.presentation.base.BaseFragment

@AndroidEntryPoint
internal class FillingFragment : BaseFragment<FillingViewModel>() {

    override fun provideViewModel(): FillingViewModel {
        val fillingViewModel by viewModels<FillingViewModel>()
        return fillingViewModel
    }

}
