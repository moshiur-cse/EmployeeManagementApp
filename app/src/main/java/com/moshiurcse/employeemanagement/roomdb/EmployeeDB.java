package com.moshiurcse.employeemanagement.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.moshiurcse.employeemanagement.daos.BasePlusCommisionEmployeeDAO;
import com.moshiurcse.employeemanagement.daos.BaseSalariedEmployeeDAO;
import com.moshiurcse.employeemanagement.daos.HourlySalarriedEmployeeDAO;
import com.moshiurcse.employeemanagement.entities.BasePlusCommisionEmployee;
import com.moshiurcse.employeemanagement.entities.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.entities.HourlySalarriedEmployee;

@Database(entities = {BaseSalarriedEmployee.class,
                      HourlySalarriedEmployee.class, BasePlusCommisionEmployee.class},
                        version = 2)
public abstract class EmployeeDB extends RoomDatabase {

    private static EmployeeDB db;

    public abstract BaseSalariedEmployeeDAO getBaseSalariedEmployeeDAO();
    public abstract HourlySalarriedEmployeeDAO getHourlySalarriedEmployeeDAO();
    public abstract BasePlusCommisionEmployeeDAO getBasePlusCommisionEmployeeDAO();

    public static EmployeeDB getInstance(Context context){
        if(db!=null){
            return db;
        }
        db= Room.databaseBuilder(context,EmployeeDB.class,"employee_db").allowMainThreadQueries().build();
        return db;
    }
}
