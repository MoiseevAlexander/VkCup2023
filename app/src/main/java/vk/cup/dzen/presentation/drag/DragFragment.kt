package vk.cup.dzen.presentation.drag

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import vk.cup.dzen.presentation.base.BaseFragment

@AndroidEntryPoint
internal class DragFragment : BaseFragment<DragViewModel>() {

    override fun provideViewModel(): DragViewModel {
        val dragViewModel by viewModels<DragViewModel>()
        return dragViewModel
    }

}
