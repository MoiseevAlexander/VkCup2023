package vk.cup.dzen.presentation.filling

import dagger.hilt.android.lifecycle.HiltViewModel
import vk.cup.dzen.presentation.base.BaseViewModel
import vk.cup.dzen.presentation.base.ViewModelDataType
import javax.inject.Inject

@HiltViewModel
internal class FillingViewModel @Inject constructor() : BaseViewModel() {
    override val dataType: ViewModelDataType
        get() = ViewModelDataType.FillingData
}
