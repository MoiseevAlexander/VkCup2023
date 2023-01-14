package vk.cup.dzen.data

import vk.cup.comparison_cell.ComparisonCellUiModel
import vk.cup.drag_cell.DragCellUiModel
import vk.cup.drag_cell.DragType
import vk.cup.filling_cell.FillingCellUiModel
import vk.cup.filling_cell.FillingType
import vk.cup.poll_cell.PollCellUiModel
import vk.cup.poll_cell.PollModel
import vk.cup.rate_cell.RateCellUiModel

internal class MockData {

    companion object {
        fun getRateList(): List<RateCellUiModel> {
            val rateCellUiModelList = arrayListOf<RateCellUiModel>()
            repeat((5..10).random()) {
                rateCellUiModelList.add(RateCellUiModel((0..4).random()))
            }
            return rateCellUiModelList
        }

        fun getFillingList(): List<FillingCellUiModel> {
            val fillingCellUiModelList = arrayListOf<FillingCellUiModel>()
            repeat((5..10).random()) {
                val fillingList = arrayListOf<FillingType>()
                repeat((3..5).random()) {
                    fillingList.add(
                        if ((0..1).random() == 0) {
                            FillingType.Filling(
                                correctAnswer = getRandomString((2..3).random())
                            )
                        } else FillingType.Text(text = getRandomString((4..5).random()))
                    )
                }
                fillingCellUiModelList.add(FillingCellUiModel(fillingList))
            }
            return fillingCellUiModelList
        }

        fun getDragList(): List<DragCellUiModel> {
            val dragCellUiModelList = arrayListOf<DragCellUiModel>()
            repeat((5..10).random()) {
                val dragTypeList = arrayListOf<DragType>()
                val answersList = arrayListOf<String>()
                repeat((3..5).random()) {
                    dragTypeList.add(
                        if ((0..1).random() == 0) DragType.Filling(correctAnswer = getRandomString((2..3).random()))
                        else DragType.Text(text = getRandomString((4..5).random()))
                    )
                    answersList.add(getRandomString((2..4).random()))
                }
                dragCellUiModelList.add(
                    DragCellUiModel(
                        items = dragTypeList,
                        answers = answersList
                    )
                )
            }
            return dragCellUiModelList
        }

        fun getComparisonList(): List<ComparisonCellUiModel> {
            val comparisonCellUiModelList = arrayListOf<ComparisonCellUiModel>()
            repeat((5..10).random()) {
                val comparisonCellItems = arrayListOf<Pair<String, String>>()
                repeat((3..5).random()) {
                    comparisonCellItems.add(
                        Pair(
                            getRandomString((6..10).random()),
                            getRandomString((6..10).random())
                        )
                    )
                }
                comparisonCellUiModelList.add(ComparisonCellUiModel(comparisonCellItems))
            }
            return comparisonCellUiModelList
        }

        fun getPollList(): List<PollCellUiModel> {
            val pollModelList = arrayListOf<PollModel>()
            repeat((2..6).random()) {
                pollModelList.add(
                    PollModel(
                        text = getRandomString((6..10).random()),
                        responseRate = "${(1..99).random()}%",
                        isCorrect = it == 0
                    )
                )
            }
            return listOf(
                PollCellUiModel(
                    questionText = getRandomString((10..15).random()),
                    questionNumber = "Вопрос ${(1..10).random()} из ${(1..10).random()}",
                    answerOptionsList = pollModelList
                )
            )
        }

        fun getRandomString(length: Int): String {
            val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
            return (1..length)
                .map { charset.random() }
                .joinToString("")
        }
    }


}
