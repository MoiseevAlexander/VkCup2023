package vk.cup.dzen.domain

import kotlinx.coroutines.flow.Flow
import vk.cup.core_recycler.Cell
import vk.cup.dzen.presentation.base.ViewModelDataType

internal interface DataRepository {

    fun getData(dataType: ViewModelDataType): Flow<List<Cell>>
}
