package com.moshiurcse.employeemanagement.adapters;

import android.content.Context;

import com.moshiurcse.employeemanagement.models.BaseSalarriedEmployee;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class BaseSalarriedEmployeeAdapter {
    private Context context;
    private List<BaseSalarriedEmployee> empList;


    public BaseSalarriedEmployeeAdapter(Context context, List<BaseSalarriedEmployee> empList) {
        this.context = context;
        this.empList = empList;
    }
   /* public class BaseSalarriedEmployeeViewHolder extends RecyclerView{

    }*/

}
