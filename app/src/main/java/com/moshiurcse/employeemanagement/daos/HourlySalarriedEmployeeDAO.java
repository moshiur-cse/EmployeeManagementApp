package com.moshiurcse.employeemanagement.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.moshiurcse.employeemanagement.entities.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.entities.HourlySalarriedEmployee;

import java.util.List;
@Dao
public interface HourlySalarriedEmployeeDAO {

    @Insert
    long insertHourlySalarriedEmployee(HourlySalarriedEmployee hse);

    @Update
    int updateHourlySalarriedEmployee(HourlySalarriedEmployee hse);

    @Delete
    int deleteHourlySalarriedEmployee(HourlySalarriedEmployee hse);

    @Query("Select * from tbl_hourly_salarried_employee")
    List<HourlySalarriedEmployee> getAllHourlySalarriedEmployee();
}
