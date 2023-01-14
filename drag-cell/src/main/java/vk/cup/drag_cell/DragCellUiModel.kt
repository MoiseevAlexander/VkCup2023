package vk.cup.drag_cell

import vk.cup.core_recycler.Cell

data class DragCellUiModel(
    val items: List<DragType>,
    val answers: List<String>,
) : Cell() {
}
