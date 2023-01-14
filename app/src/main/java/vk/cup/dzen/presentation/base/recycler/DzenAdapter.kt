package vk.cup.dzen.presentation.base.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import vk.cup.comparison_cell.ComparisonCellUiModel
import vk.cup.comparison_cell.ComparisonViewHolder
import vk.cup.comparison_cell.databinding.ComparisonItemBinding
import vk.cup.core_recycler.Cell
import vk.cup.core_recycler.DzenViewHolder
import vk.cup.drag_cell.DragCellUiModel
import vk.cup.drag_cell.DragViewHolder
import vk.cup.drag_cell.databinding.DragItemBinding
import vk.cup.filling_cell.FillingCellUiModel
import vk.cup.filling_cell.FillingViewHolder
import vk.cup.filling_cell.databinding.FillingItemBinding
import vk.cup.poll_cell.PollCellUiModel
import vk.cup.poll_cell.PollViewHolder
import vk.cup.poll_cell.databinding.PollItemBinding
import vk.cup.rate_cell.RateCellUiModel
import vk.cup.rate_cell.RateViewHolder
import vk.cup.rate_cell.databinding.RateItemBinding

class DzenAdapter : ListAdapter<Cell, DzenViewHolder>(DzenDiffUtilCallback()) {

    private companion object {
        const val POLL_VIEW_TYPE = 0
        const val COMPARISON_VIEW_TYPE = 1
        const val DRAG_VIEW_TYPE = 2
        const val FILLING_VIEW_TYPE = 3
        const val RATE_VIEW_TYPE = 4
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is PollCellUiModel -> POLL_VIEW_TYPE
            is ComparisonCellUiModel -> COMPARISON_VIEW_TYPE
            is DragCellUiModel -> DRAG_VIEW_TYPE
            is FillingCellUiModel -> FILLING_VIEW_TYPE
            is RateCellUiModel -> RATE_VIEW_TYPE
            else -> 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DzenViewHolder {
        return when (viewType) {
            POLL_VIEW_TYPE -> {
                PollViewHolder(
                    PollItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            COMPARISON_VIEW_TYPE -> {
                ComparisonViewHolder(
                    ComparisonItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            DRAG_VIEW_TYPE -> {
                DragViewHolder(
                    DragItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            FILLING_VIEW_TYPE -> {
                FillingViewHolder(
                    FillingItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            RATE_VIEW_TYPE -> {
                RateViewHolder(
                    RateItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                PollViewHolder(
                    PollItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: DzenViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
