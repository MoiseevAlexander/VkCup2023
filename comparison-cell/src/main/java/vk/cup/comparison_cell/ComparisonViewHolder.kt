package vk.cup.comparison_cell

import android.graphics.Color
import android.widget.GridLayout.LayoutParams
import android.widget.TextView
import androidx.core.view.setPadding
import vk.cup.comparison_cell.databinding.ComparisonItemBinding
import vk.cup.core_recycler.Cell
import vk.cup.core_recycler.DzenViewHolder


class ComparisonViewHolder(private val binding: ComparisonItemBinding) : DzenViewHolder(binding) {

    override fun bind(item: Cell) {
        val newItem = item as ComparisonCellUiModel
        newItem.items.forEachIndexed { index, pair ->
            val textView1 = TextView(binding.root.context)
            textView1.text = pair.first
            textView1.layoutParams = LayoutParams().apply {
                setMargins(30, 10, 30, 10)
            }
            textView1.tag = "textView1$index"
            textView1.setPadding(20)
            textView1.setTextColor(Color.BLACK)
            textView1.setBackgroundResource(R.drawable.comparison_variant_background)

            val textView2 = TextView(binding.root.context)
            textView2.text = pair.second
            textView2.layoutParams = LayoutParams().apply {
                setMargins(30, 10, 30, 10)
            }
            textView2.tag = "textView2$index"
            textView2.setPadding(20)
            textView2.setTextColor(Color.BLACK)
            textView2.setBackgroundResource(R.drawable.comparison_variant_background)

            binding.variantsLayout.addView(textView1)
            binding.variantsLayout.addView(textView2)
        }
        binding.variantsLayout.init()

    }

}
