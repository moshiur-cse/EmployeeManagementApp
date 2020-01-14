package com.moshiurcse.employeemanagement.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moshiurcse.employeemanagement.R;
import com.moshiurcse.employeemanagement.models.BaseSalarriedEmployee;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseSalarriedEmployeeAdapter extends RecyclerView.Adapter<BaseSalarriedEmployeeAdapter.BaseSalarriedEmployeeViewHolder> {
    private Context context;
    private List<BaseSalarriedEmployee> empList;


    public BaseSalarriedEmployeeAdapter(Context context, List<BaseSalarriedEmployee> empList) {
        this.context = context;
        this.empList = empList;
    }

    @NonNull
    @Override
    public BaseSalarriedEmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.employee_row,parent,false);
        return new BaseSalarriedEmployeeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseSalarriedEmployeeViewHolder holder, int position) {

        holder.nameTV.setText(empList.get(position).getEmp_name());
        holder.phoneTV.setText(empList.get(position).getEmp_phone());
    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    public class BaseSalarriedEmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV,phoneTV,menuTV;


        public BaseSalarriedEmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.row_empName);
            phoneTV=itemView.findViewById(R.id.row_empPhone);
            menuTV=itemView.findViewById(R.id.row_menu);
        }
    }
}
