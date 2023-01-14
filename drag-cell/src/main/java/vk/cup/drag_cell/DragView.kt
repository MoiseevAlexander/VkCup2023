package vk.cup.drag_cell

import android.content.Context
import android.graphics.Color
import android.text.InputFilter
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class DragView : LinearLayout {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun initFillingView(items: List<DragType>) {
        items.forEach {
            when (it) {
                is DragType.Text -> {
                    val textView = TextView(context)
                    textView.text = it.text
                    addView(textView)
                }
                is DragType.Filling -> {
                    val editText = EditText(context)
                    editText.hint = it.correctAnswer
                    editText.setHintTextColor(Color.TRANSPARENT)
                    editText.maxLines = 1
                    editText.filters = arrayOf(InputFilter.LengthFilter(it.correctAnswer.length))
                    editText.isEnabled = false
                    addView(editText)
                }
            }
        }
    }

}
