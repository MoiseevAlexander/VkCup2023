package vk.cup.filling_cell

sealed class FillingType {

    data class Text(val text: String) : FillingType()

    data class Filling(val correctAnswer: String) : FillingType()

}
