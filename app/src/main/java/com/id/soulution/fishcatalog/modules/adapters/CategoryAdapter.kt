package com.id.soulution.fishcatalog.modules.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.soulution.fishcatalog.R
import com.id.soulution.fishcatalog.modules.items.AccountMenuItem
import com.id.soulution.fishcatalog.modules.models.Category

class CategoryAdapter(private val handler: (Category, Int) -> Unit):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var items: MutableList<Category> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemLabel: TextView
        var view: View = itemView

        init {
            this.itemLabel = this.view.findViewById(R.id.item_label)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_account_menu, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Category = this.items[position]
        holder.itemLabel.text = item.label
    }
}