package vk.cup.dzen.presentation.drag

import dagger.hilt.android.lifecycle.HiltViewModel
import vk.cup.dzen.presentation.base.BaseViewModel
import vk.cup.dzen.presentation.base.ViewModelDataType
import javax.inject.Inject

@HiltViewModel
internal class DragViewModel @Inject constructor() : BaseViewModel() {

    override val dataType: ViewModelDataType
        get() = ViewModelDataType.DragData

}
