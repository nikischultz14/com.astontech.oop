package com.astontech.dao;

import com.astontech.bo.Person;

import java.util.List;

public interface PersonDAO {

    //notes:    GET METHODS

    public Person getPersonById(int personId);
    public List<Person> getPersonList();


    //notes:    EXECUTE METHODS
    public int insertPerson(Person person);
    public boolean updatePerson(Person person);
    public boolean deletePerson(int personId);

}
