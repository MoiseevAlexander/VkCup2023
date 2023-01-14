package vk.cup.rate_cell

import vk.cup.core_recycler.Cell
import vk.cup.core_recycler.DzenViewHolder
import vk.cup.rate_cell.databinding.RateItemBinding

class RateViewHolder(private val binding: RateItemBinding) : DzenViewHolder(binding) {

    override fun bind(item: Cell) {
        val newItem = item as RateCellUiModel
        binding.rateView.loadSelectedStars(newItem.selectedStars)
    }

}
