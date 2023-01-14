package vk.cup.dzen.domain

import kotlinx.coroutines.flow.Flow
import vk.cup.core_recycler.Cell
import vk.cup.dzen.presentation.base.ViewModelDataType
import javax.inject.Inject

internal class GetDataUseCase @Inject constructor(private val dataRepository: DataRepository) {

    fun getData(dataType: ViewModelDataType): Flow<List<Cell>> = dataRepository.getData(dataType)
}
