package com.moshiurcse.employeemanagement.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.moshiurcse.employeemanagement.R;
import com.moshiurcse.employeemanagement.entities.BaseSalarriedEmployee;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/*
Step-1 : Layout Inflate
Step-2 : View Initialize
Step-3: Data Set
 */

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

        //Step-1
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.employee_row,parent,false);
        return new BaseSalarriedEmployeeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseSalarriedEmployeeViewHolder holder, final int position) {
//Step-3
        holder.nameTV.setText(empList.get(position).getEmp_name());
        holder.phoneTV.setText(empList.get(position).getEmp_phone());

        holder.menuTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseSalarriedEmployee bse=empList.get(position);
                //Toast.makeText(context, bse.getEmp_name(), Toast.LENGTH_SHORT).show();

                PopupMenu popupMenu=new PopupMenu(context,view);
                popupMenu.getMenuInflater().inflate(R.menu.employee_row_manu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                       switch (menuItem.getItemId()){
                           //case R.id.row
                       }


                        return false;
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    public class BaseSalarriedEmployeeViewHolder extends RecyclerView.ViewHolder {

        //Step-2
        TextView nameTV,phoneTV,menuTV;


        public BaseSalarriedEmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.row_empName);
            phoneTV=itemView.findViewById(R.id.row_empPhone);
            menuTV=itemView.findViewById(R.id.row_menu);
        }
    }
}
