package vk.cup.filling_cell

import vk.cup.core_recycler.Cell
import vk.cup.core_recycler.DzenViewHolder
import vk.cup.filling_cell.databinding.FillingItemBinding

class FillingViewHolder(private val binding: FillingItemBinding) : DzenViewHolder(binding) {

    override fun bind(item: Cell) {
        val newItem = item as FillingCellUiModel
        binding.fillingView.initFillingView(newItem.items)
    }

}
