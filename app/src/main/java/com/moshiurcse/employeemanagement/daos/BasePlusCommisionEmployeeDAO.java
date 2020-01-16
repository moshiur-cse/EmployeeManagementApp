package com.moshiurcse.employeemanagement.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.moshiurcse.employeemanagement.entities.BasePlusCommisionEmployee;
import com.moshiurcse.employeemanagement.entities.HourlySalarriedEmployee;

import java.util.List;
@Dao
public interface BasePlusCommisionEmployeeDAO {

    @Insert
    long insertBasePlusCommisionEmployee(BasePlusCommisionEmployee hse);

    @Update
    int updateBasePlusCommisionEmployee(BasePlusCommisionEmployee hse);

    @Delete
    int deleteBasePlusCommisionEmployee(BasePlusCommisionEmployee hse);

    @Query("Select * from tbl_base_plus_commision_employee")
    List<BasePlusCommisionEmployee> getBasePlusCommisionEmployee();
}
