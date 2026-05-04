package com.tbt65133334.vieccanlam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TASKRVAdapter extends RecyclerView.Adapter<TASKRVAdapter.TaskItemViewHolder> {
    List<TASK> datasource;

    public TASKRVAdapter(List<TASK> datasource) {
        this.datasource = datasource;
    }

    public class TaskItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTenVCL;
        TextView tvNgayHetHan;

        public TaskItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvTenVCL = itemView.findViewById(R.id.textViewTenVCL);
            tvNgayHetHan = itemView.findViewById(R.id.textViewThoiGian);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            if (pos != RecyclerView.NO_ID && pos < datasource.size()) {
                TASK taskClicked = datasource.get(pos);
                Toast.makeText(v.getContext(), "Ban vua chon viec: " + taskClicked.getName(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @NonNull
    @Override
    public TaskItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskItemViewHolder holder, int position) {
        TASK task = datasource.get(position);
        holder.tvTenVCL.setText(task.getName());
        holder.tvNgayHetHan.setText(task.getDate());
    }

    @Override
    public int getItemCount() {
        return datasource.size();
    }
}