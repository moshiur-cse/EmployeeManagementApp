package com.moshiurcse.employeemanagement.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.moshiurcse.employeemanagement.AdminDashboardActivity;
import com.moshiurcse.employeemanagement.EmpDetailsActivity;
import com.moshiurcse.employeemanagement.EmployeeListActivity;
import com.moshiurcse.employeemanagement.LoginActivity;
import com.moshiurcse.employeemanagement.MainActivity;
import com.moshiurcse.employeemanagement.R;
import com.moshiurcse.employeemanagement.entities.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.roomdb.EmployeeDB;

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
    //private List<BaseSalarriedEmployee> empList;
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
                final BaseSalarriedEmployee bse=empList.get(position);
                final long empId=bse.getEmp_id();
                //Toast.makeText(context, bse.getEmp_name(), Toast.LENGTH_SHORT).show();

                PopupMenu popupMenu=new PopupMenu(context,view);
                popupMenu.getMenuInflater().inflate(R.menu.employee_row_manu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                       switch (menuItem.getItemId()){
                           case R.id.empDelete:

                               AlertDialog.Builder builder=new AlertDialog.Builder(context);
                               builder.setIcon(R.drawable.ic_delete_black_24dp);
                               builder.setTitle("Do you want to delete!");
                               builder.setMessage("Are you sure?");
                               builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {
                                      final int count= EmployeeDB.getInstance(context).getBaseSalariedEmployeeDAO().deleteBaseSalariedEmployee(bse);


                                       if (count>0){
                                           empList.remove(bse);
                                           notifyDataSetChanged();
                                           Toast.makeText(context, "Delete Successfully", Toast.LENGTH_SHORT).show();
                                           //goToEmployeeList();
                                       }
                                   }
                               });
                               builder.setNegativeButton("No",null);
                               AlertDialog dialog=builder.create();
                               dialog.show();





                              /* Toast.makeText(context, "empDelete", Toast.LENGTH_SHORT).show();
                               EmployeeDB.getInstance(context).getBaseSalariedEmployeeDAO().deleteBaseSalariedEmployee(bse);
                               goToEmployeeList();

*/
                               break;

                           case R.id.empDetails:
                               Intent intent=new Intent(context, EmpDetailsActivity.class);
                               intent.putExtra("empId",empId);
                               context.startActivity(intent);
                               //Toast.makeText(context, "Details", Toast.LENGTH_SHORT).show();

                               //EmployeeDB.getInstance(this).getBaseSalariedEmployeeDAO().deleteBaseSalariedEmployee(int id);
                               break;

                           case R.id.empUpdate:

                               Intent intent2=new Intent(context, MainActivity.class);
                               intent2.putExtra("empId",empId);
                               context.startActivity(intent2);
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

    private void goToEmployeeList(){
        Intent intent=new Intent(context, EmployeeListActivity.class);
        context.startActivity(intent);
    }
}
