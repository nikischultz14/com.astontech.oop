package com.astontech.dao.mysql;

import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl extends MySQL implements PersonDAO {

    //region Overrides

    @Override
    public Person getPersonById(int personId) {
        Connect();
        Person person = null;    //not instantiated because if no records returned, we don't want to use memory.
        try {
            String sp = Procedures.GetPerson;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, personId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                person = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return person;

    }

    @Override
    public List<Person> getPersonList() {
        Connect();
        List<Person> personList = new ArrayList<Person>();
        try {
            String sp = Procedures.GetPerson;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                personList.add(HydrateObject(rs));
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return personList;
    }

    @Override
    public int insertPerson(Person person) {
        Connect();
        int id = 0;
        try {
            String sp = Procedures.ExecPerson;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getLastName());
            cStmt.setString(6, person.getDisplayFirstName());
            cStmt.setString(7, person.getGender());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id;
    }
                    //question marks for each spot!
                    //queryid, personid, title, first, last, display, gender
    //call ExecPerson(10, null, 'Mr.', 'Blake', 'Wittlebe', 'Blake', 'M');

    @Override
    public boolean updatePerson(Person person) {
        Connect();
        int id = 0;
        try {
            String sp = Procedures.ExecPerson;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, person.getPersonId());
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getLastName());
            cStmt.setString(6, person.getDisplayFirstName());
            cStmt.setString(7, person.getGender());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id > 0;
    }

    @Override
    public boolean deletePerson(int personId) {
        Connect();
        int id = 0;
        try {
            String sp = Procedures.ExecPerson;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, personId);
            cStmt.setString(3, "");
            cStmt.setString(4, "");
            cStmt.setString(5, "");
            cStmt.setString(6, "");
            cStmt.setString(7, "");

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id > 0;
    }
    //endregion


    private static Person HydrateObject(ResultSet rs) throws SQLException {

        Person person = new Person();

        person.setPersonId(rs.getInt(1));
        person.setTitle(rs.getString(2));
        person.setFirstName(rs.getString(3));
        person.setLastName(rs.getString(4));
        person.setDisplayFirstName(rs.getString(5));
        person.setGender(rs.getString(6));

        return person;
    }

}
