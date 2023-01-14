package vk.cup.rate_cell

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.RadioButton

class RateView : LinearLayout {

    private companion object {
        private const val STARS_COUNT = 5
    }

    private val items: ArrayList<RadioButton> = arrayListOf<RadioButton>().apply {
        ensureCapacity(STARS_COUNT)
    }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initStars()
    }

    fun loadSelectedStars(starsSelected: Int) {
        repeat(starsSelected) { index ->
            items[index].callOnClick()
        }
    }

    private fun initStars() {
        repeat(STARS_COUNT) { index ->
            val star = createStar()
            this.addView(star)
            items.add(star)

            star.setOnClickListener {
                onStarClicked(index)
            }
        }
    }

    private fun createStar(): RadioButton {
        val radioButton = RadioButton(context)
        radioButton.layoutParams = LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f)
        radioButton.setButtonDrawable(R.drawable.ic_star_selector)
        return radioButton
    }

    private fun onStarClicked(clickedIndex: Int) {
        items.forEachIndexed { index, radioButton ->
            radioButton.isChecked = clickedIndex >= index
        }
    }
}
