package kz.y.drawing

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyItemDecoration(private val context: Context): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = context.resources.getDimension(R.dimen.view_small_margin).toInt()
        outRect.left  = context.resources.getDimension(R.dimen.view_large_margin).toInt()
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val divider: Drawable? = ContextCompat.getDrawable(context, R.drawable.my_divider)

        val left = 0
        val right = parent.width

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + (divider?.intrinsicHeight ?: 0)

            divider?.let {
                it.setBounds(left, top, right, bottom)
                it.draw(c)
            }
        }
    }
}