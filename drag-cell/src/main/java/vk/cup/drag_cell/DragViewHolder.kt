package vk.cup.drag_cell

import android.content.ClipData
import android.content.ClipDescription
import android.os.Build
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setPadding
import vk.cup.core_recycler.Cell
import vk.cup.core_recycler.DzenViewHolder
import vk.cup.drag_cell.databinding.DragItemBinding

class DragViewHolder(private val binding: DragItemBinding) : DzenViewHolder(binding) {
    override fun bind(item: Cell) {
        val newItem = item as DragCellUiModel
        binding.dragView.initFillingView(newItem.items)
        newItem.answers.forEachIndexed { index, string ->
            val textView = TextView(binding.root.context)
            val newLayoutParams = LinearLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            newLayoutParams.setMargins(30, 10, 30, 10)
            textView.setPadding(20)
            textView.layoutParams = newLayoutParams
            textView.text = string
            textView.tag = "textViewHolder$index"
            textView.setBackgroundResource(R.drawable.answer_background)

            textView.setOnLongClickListener { v ->
                val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
                val itemDrag = ClipData.Item(v.tag as CharSequence)
                val dragData = ClipData(v.tag.toString(), mimeTypes, itemDrag)
                val shadowBuilder = View.DragShadowBuilder(v)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(dragData, shadowBuilder, v, 0)
                } else v.startDrag(dragData, shadowBuilder, v, 0)
                v.visibility = View.INVISIBLE
                true
            }
            binding.answersLayout.addView(textView)
        }
    }
}
