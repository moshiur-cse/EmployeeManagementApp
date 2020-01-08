package com.moshiurcse.employeemanagement.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.moshiurcse.employeemanagement.utils.ConstantUtils;

public class AuthPreference {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public AuthPreference(Context context){
        sharedPreferences=context.getSharedPreferences(ConstantUtils.AdminPreference.FILE_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void setLoginStatus(boolean status){
        editor.putBoolean(ConstantUtils.AdminPreference.STATUS_KEY,status);
        editor.commit();
    }
    public boolean isAdminLoggedIn(){
        return sharedPreferences.getBoolean(ConstantUtils.AdminPreference.STATUS_KEY,false);
    }
}
