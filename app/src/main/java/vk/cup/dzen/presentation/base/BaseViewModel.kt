package vk.cup.dzen.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import vk.cup.core_recycler.Cell
import vk.cup.dzen.domain.GetDataUseCase
import javax.inject.Inject

internal abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var getDataUseCase: GetDataUseCase

    abstract val dataType: ViewModelDataType

    private val dataLiveData: MutableLiveData<List<Cell>> = MutableLiveData()

    fun getDataLiveData(): LiveData<List<Cell>> = dataLiveData

    fun loadData() {
        viewModelScope.launch {
            getDataUseCase
                .getData(dataType)
                .collectLatest {
                    if (dataLiveData.value == null) {
                        dataLiveData.postValue(it)
                    } else {
                        dataLiveData.value?.let { currentList ->
                            dataLiveData.postValue(currentList.plus(it))
                        }
                    }

                }
        }
    }
}
