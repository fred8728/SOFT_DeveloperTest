package main;

import java.util.Date;

public class SqlConverter {
    public static java.sql.Date convertToSQLDate(Date d) {
        return new java.sql.Date(d.getTime());
    }
}
