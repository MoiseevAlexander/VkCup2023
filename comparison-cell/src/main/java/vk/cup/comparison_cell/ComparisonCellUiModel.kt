package vk.cup.comparison_cell

import vk.cup.core_recycler.Cell

data class ComparisonCellUiModel(
    val items: List<Pair<String, String>>
) : Cell()
