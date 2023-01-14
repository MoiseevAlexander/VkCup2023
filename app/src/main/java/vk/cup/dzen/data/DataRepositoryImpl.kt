package vk.cup.dzen.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import vk.cup.core_recycler.Cell
import vk.cup.dzen.domain.DataRepository
import vk.cup.dzen.presentation.base.ViewModelDataType
import javax.inject.Inject

internal class DataRepositoryImpl @Inject constructor() : DataRepository {
    override fun getData(dataType: ViewModelDataType): Flow<List<Cell>> {
        return flow {
            when (dataType) {
                is ViewModelDataType.PollData -> {
                    emit(MockData.getPollList())
                }
                is ViewModelDataType.ComparisonData -> {
                    emit(MockData.getComparisonList())
                }
                is ViewModelDataType.DragData -> {
                    emit(MockData.getDragList())
                }
                is ViewModelDataType.FillingData -> {
                    emit(MockData.getFillingList())
                }
                is ViewModelDataType.RateData -> {
                    emit(MockData.getRateList())
                }
            }
        }
    }
}
