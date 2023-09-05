package com.jdh.materialdesign

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerDesignAdapter: RecyclerView.Adapter<RecyclerDesignAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerDesignAdapter.ViewHolder {
        val context = parent.context
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View = inflater.inflate(R.layout.recyclerview_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerDesignAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var TextView_text: TextView

        init {
            TextView_text = itemView.findViewById(R.id.TextView_text)

        }
    }
}