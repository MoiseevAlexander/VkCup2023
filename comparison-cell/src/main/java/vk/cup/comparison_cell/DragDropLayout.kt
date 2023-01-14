package vk.cup.comparison_cell

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.GridLayout
import android.widget.TextView
import androidx.core.view.allViews

class DragDropLayout @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    GridLayout(context, attrs, defStyleAttr), View.OnLongClickListener, View.OnDragListener {

    private var childs: MutableList<View>? = null

    override fun onLongClick(v: View): Boolean {
        val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
        val item = ClipData.Item(v.tag as CharSequence)
        val dragData = ClipData(v.tag.toString(), mimeTypes, item)
        val shadowBuilder = DragShadowBuilder(v)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            v.startDragAndDrop(dragData, shadowBuilder, v, 0)
        } else v.startDrag(dragData, shadowBuilder, v, 0)
        v.visibility = INVISIBLE
        return true
    }

    override fun onDrag(dropView: View, event: DragEvent): Boolean {
        val dragView = event.localState as View
        return when (event.action) {
            DragEvent.ACTION_DROP -> {
                clearShake(dropView); swapView(dragView, dropView); true
            }
            DragEvent.ACTION_DRAG_STARTED -> {
                setVisibility(dragView, false); true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                setVisibility(dragView, true); true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                shakeView(dropView); true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                clearShake(dropView); true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            else -> false
        }
    }

    internal fun init() {
        childs = ArrayList()
        for (child in getAllChild(this)) {
            if (child is TextView) {
                child.setOnLongClickListener(this)
                child.setOnDragListener(this)
                (childs as ArrayList<View>).add(child)
            }
        }
    }

    private fun setVisibility(v: View, isVisible: Boolean) {
        v.post { v.visibility = if (isVisible) VISIBLE else INVISIBLE }
    }

    private fun swapView(dragView: View, dropView: View) {
        val dragParams = dragView.layoutParams as LayoutParams
        val dropParams = dropView.layoutParams as LayoutParams
        val dragIndex = indexOfChild(dragView)
        val dropIndex = indexOfChild(dropView)
        if ((dragIndex % 2 == 0 && dropIndex % 2 == 0) || (dragIndex % 2 != 0 && dropIndex % 2 != 0)) {
            dragView.layoutParams = dropParams
            dropView.layoutParams = dragParams
            childs!!.removeAt(dragIndex)
            childs!!.add(dragIndex, dropView)
            childs!!.removeAt(dropIndex)
            childs!!.add(dropIndex, dragView)
            removeAllViews()
            for (child in childs!!) addView(child)
            allViews.elementAt(dropIndex + 1).apply {
                clearShake(this)
                startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_two))
            }
            allViews.elementAt(dragIndex + 1).apply {
                clearShake(this)
                startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_two))
            }
        }
    }

    private fun shakeView(v: View) {
        v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_one))
    }

    private fun clearShake(v: View) {
        v.clearAnimation()
    }

    private fun getAllChild(v: View): List<View> {
        val visited: MutableList<View> = ArrayList()
        val unvisited: MutableList<View> = ArrayList()
        unvisited.add(v)
        while (unvisited.isNotEmpty()) {
            val child = unvisited.removeAt(0)
            visited.add(child)
            if (child !is ViewGroup) continue
            for (i in 0 until child.childCount) unvisited.add(child.getChildAt(i))
        }
        return visited
    }

}
