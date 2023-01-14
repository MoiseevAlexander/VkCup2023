package vk.cup.dzen.presentation.base.recycler

import androidx.recyclerview.widget.DiffUtil
import vk.cup.core_recycler.Cell

class DzenDiffUtilCallback : DiffUtil.ItemCallback<Cell>() {

    override fun areItemsTheSame(oldItem: Cell, newItem: Cell): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Cell, newItem: Cell): Boolean {
        return oldItem.id == newItem.id
    }

}
