package vk.cup.dzen.presentation.base

internal sealed class ViewModelDataType {

    object PollData : ViewModelDataType()

    object ComparisonData : ViewModelDataType()

    object DragData : ViewModelDataType()

    object FillingData : ViewModelDataType()

    object RateData : ViewModelDataType()
}
