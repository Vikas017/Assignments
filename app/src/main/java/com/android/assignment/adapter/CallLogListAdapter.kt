package com.android.assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.assignment.CallLogModel
import com.android.assignment.databinding.CallLogItemBinding
import com.android.assignment.utils.LIST_OF_CALLS

class CallLogListAdapter(private val list: List<CallLogModel> = LIST_OF_CALLS, private val onClickPerform: () -> Unit)
    : RecyclerView.Adapter<CallLogListAdapter.CallLogListItemViewHolder>() {
    inner class CallLogListItemViewHolder(val binding: CallLogItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallLogListItemViewHolder {
        val layout = CallLogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CallLogListItemViewHolder(layout)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CallLogListItemViewHolder, position: Int) {
        holder.binding.apply {
            textViewPhoneNumber.text = list[position].phoneNumber
            textViewDate.text = list[position].dateAndTime
            textViewInOutStatus.text = list[position].callStatus
            textViewFrom.text = list[position].from

            buttonPlay.setOnClickListener {
                onClickPerform()
            }
            buttonMic.setOnClickListener {
                onClickPerform()
            }
        }
    }

}