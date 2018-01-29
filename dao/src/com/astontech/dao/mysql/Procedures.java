package com.astontech.dao.mysql;

public class Procedures {

    final static String ExecEmail = "{call ExecEmail(?,?,?,?,?)}";

    final static String GetEmail = "{call GetEmail(?,?)}";

    final static String ExecEmployee = "{call ExecEmployee(?,?,?,?,?,?)}";

    final static String GetEmployee = "{call GetEmployee(?,?)}";

    final static String ExecPerson = "{call ExecPerson(?,?,?,?,?,?,?)}";

    final static String GetPerson = "{call GetPerson(?,?)}";

    final static String ExecPhone = "{call ExecPhone(?,?,?,?,?,?,?,?)}";

    final static String GetPhone = "{call GetPhone(?,?)}";

    final static String ExecVehicle = "{call ExecVehicle(?,?,?,?,?,?,?,?,?,?)}";

    final static String GetVehicle = "{call GetVehicle(?,?)}";

    final static String ExecVehicleMake = "{call ExecVehicleMake(?,?,?)}";

    final static String GetVehicleMake = "{call GetVehicleMake(?,?)}";

    final static String ExecVehicleModel = "{call ExecVehicleModel(?,?,?,?)}";

    final static String GetVehicleModel = "{call GetVehicleModel(?,?)}";


}
