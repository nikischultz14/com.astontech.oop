package com.astontech.dao;

import com.astontech.bo.Phone;

import java.util.List;

public interface PhoneDAO {

    //get methods
    public Phone getPhoneById(int phoneId);
    public List<Phone> getPhoneList();

    //execute methods
    public int insertPhone(Phone phone);
    public boolean updatePhone(Phone phone);
    public boolean deletePhone(int phoneId);

}





