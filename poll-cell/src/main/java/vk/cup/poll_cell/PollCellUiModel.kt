package vk.cup.poll_cell

import vk.cup.core_recycler.Cell

class PollCellUiModel(
    val questionText: String,
    val questionNumber: String,
    val answerOptionsList: List<PollModel>,
) : Cell()
