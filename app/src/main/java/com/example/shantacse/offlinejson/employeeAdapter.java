package com.example.shantacse.offlinejson;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class employeeAdapter extends RecyclerView.Adapter<employeeAdapter.Holder> {

    private List<employee> employeelist;
    private Context context;

    public employeeAdapter(List<employee> employeelist,Context context) {
        this.employeelist = employeelist;
        this.context = context;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout,viewGroup,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int i) {

        holder.NAME.setText(employeelist.get(i).getName());
        holder.PHONE.setText(employeelist.get(i).getPhone());


    }

    @Override
    public int getItemCount() {
        return employeelist.size();
    }

    class Holder extends RecyclerView.ViewHolder
    {
        TextView NAME,PHONE;

        public Holder(View itemView) {
            super(itemView);

            NAME = itemView.findViewById(R.id.name);
            PHONE = itemView.findViewById(R.id.phone);
        }
    }
}
