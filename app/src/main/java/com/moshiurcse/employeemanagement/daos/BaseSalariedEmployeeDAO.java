package com.moshiurcse.employeemanagement.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.moshiurcse.employeemanagement.entities.BaseSalarriedEmployee;

import java.util.List;

@Dao
public interface BaseSalariedEmployeeDAO {

    @Insert
    long insertBaseSalariedEmployee(BaseSalarriedEmployee bas);

    @Update
    int updateBaseSalariedEmployee(BaseSalarriedEmployee bas);

    @Delete
    int deleteBaseSalariedEmployee(BaseSalarriedEmployee bas);

    @Query("Select * from tbl_emp_base_salaried")
    List<BaseSalarriedEmployee> gerAllBaseSalariedEmployee();


}
