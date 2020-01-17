package com.moshiurcse.employeemanagement.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moshiurcse.employeemanagement.EmployeeListActivity;
import com.moshiurcse.employeemanagement.R;
import com.moshiurcse.employeemanagement.entities.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.entities.HourlySalarriedEmployee;
import com.moshiurcse.employeemanagement.roomdb.EmployeeDB;

import java.util.List;

public class HourlySalarriedEmployeeAdapter extends RecyclerView.Adapter<HourlySalarriedEmployeeAdapter.HourlySalarriedEmployeeViewHolder> {
    private Context context;
    private List<HourlySalarriedEmployee> empList;

    public HourlySalarriedEmployeeAdapter(Context context, List<HourlySalarriedEmployee> empList) {
        this.context = context;
        this.empList = empList;
    }

    @NonNull
    @Override
    public HourlySalarriedEmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.employee_row,parent,false);
        return new HourlySalarriedEmployeeAdapter.HourlySalarriedEmployeeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlySalarriedEmployeeViewHolder holder,final int position) {

        holder.nameTV.setText(empList.get(position).getEmp_name());
        holder.phoneTV.setText(empList.get(position).getEmp_phone());

        holder.menuTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final HourlySalarriedEmployee hse=empList.get(position);
                //Toast.makeText(context, bse.getEmp_name(), Toast.LENGTH_SHORT).show();

                PopupMenu popupMenu=new PopupMenu(context,view);
                popupMenu.getMenuInflater().inflate(R.menu.employee_row_manu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.empDelete:
                                Toast.makeText(context, "empDelete", Toast.LENGTH_SHORT).show();
                                EmployeeDB.getInstance(context).getHourlySalarriedEmployeeDAO().deleteHourlySalarriedEmployee(hse);

                                //context.startActivity(getIntent());
                                goToEmployeeList();
                                Toast.makeText(context, "Delete Successfully", Toast.LENGTH_SHORT).show();

                                break;

                            case R.id.empDetails:
                                Toast.makeText(context, "Details", Toast.LENGTH_SHORT).show();

                                //EmployeeDB.getInstance(this).getBaseSalariedEmployeeDAO().deleteBaseSalariedEmployee(int id);
                                break;

                            case R.id.empUpdate:
                                //EmployeeDB.getInstance(context).getBaseSalariedEmployeeDAO().deleteBaseSalariedEmployee(int id);
                                break;
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


    public class HourlySalarriedEmployeeViewHolder extends RecyclerView.ViewHolder {

        //Step-2
        TextView nameTV,phoneTV,menuTV;


        public HourlySalarriedEmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.row_empName);
            phoneTV=itemView.findViewById(R.id.row_empPhone);
            menuTV=itemView.findViewById(R.id.row_menu);
        }
    }
    private void goToEmployeeList(){
        Intent intent=new Intent(context, EmployeeListActivity.class);
        context.startActivity(intent);
    }
}
