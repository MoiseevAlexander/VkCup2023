package vk.cup.filling_cell

import android.content.Context
import android.graphics.Color
import android.text.InputFilter
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class FillingView : LinearLayout {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun initFillingView(items: List<FillingType>) {
        items.forEach { fillingType ->
            when (fillingType) {
                is FillingType.Text -> {
                    val textView = TextView(context).apply {
                        text = fillingType.text
                    }
                    addView(textView)
                }
                is FillingType.Filling -> {
                    val editText = EditText(context).apply {
                        hint = fillingType.correctAnswer
                        setHintTextColor(Color.TRANSPARENT)
                        maxLines = 1
                        filters =
                            arrayOf(InputFilter.LengthFilter(fillingType.correctAnswer.length))
                    }
                    addView(editText)
                }
            }
        }
    }

}
