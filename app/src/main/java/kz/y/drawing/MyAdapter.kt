package kz.y.drawing

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : ListAdapter<MyDataClass, MyAdapter.MyViewHolder>(difUtil) {

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_recycler_view, parent, false) as TextView
        return MyViewHolder(textView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = getItem(position).subTitle
        println("Bind position: $position")
    }

    private object difUtil: DiffUtil.ItemCallback<MyDataClass>() {

        override fun areItemsTheSame(
                oldItem: MyDataClass,
                newItem: MyDataClass
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
                oldItem: MyDataClass,
                newItem: MyDataClass
        ): Boolean = oldItem == newItem
    }
}