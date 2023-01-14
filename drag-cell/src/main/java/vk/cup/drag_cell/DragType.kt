package vk.cup.drag_cell

sealed class DragType {

    data class Text(val text: String) : DragType()

    data class Filling(val correctAnswer: String) : DragType()
}
