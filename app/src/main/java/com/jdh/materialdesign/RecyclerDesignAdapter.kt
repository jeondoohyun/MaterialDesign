package com.jdh.materialdesign

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerDesignAdapter(val itemList: ArrayList<RecyclerItem>, val context: Context): RecyclerView.Adapter<RecyclerDesignAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(com.jdh.materialdesign.R.layout.recyclerview_design, parent, false) // 패키지 입력해줘야 xml파일 인식됨
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerDesignAdapter.ViewHolder, position: Int) {
        holder.TextView_text.text = itemList[position].title

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    /** 클릭 이벤트(
     * 인터페이스 생성
     * 인터페이스 넣을 변수
     * 변수에 클릭이벤트 setter */
    interface AAAAClickListener {
        fun onClick(v: View, position: Int)
    }

    private lateinit var itemClickListener : AAAAClickListener

    fun setItemClickListener(ClickListener: AAAAClickListener) {
        this.itemClickListener = ClickListener
    }



    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var TextView_text: TextView

        init {
            TextView_text = itemView.findViewById<TextView>(com.jdh.materialdesign.R.id.TextView_text)
        }
    }
}