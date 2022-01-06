package com.phonebook.configuration.sqlite;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;

import java.sql.Types;

public class SQLiteDialect extends Dialect {

    /*
    Since Hibernate does not support SQLite out of the box, this class acts as a Dialect for SQLite to enable us
    to user Hibernate with SQLite. It extends the Hibernate Dialect and adds to it.

    The column types that are provided by SQLite are registered, and support for identity columns is added.
     */
    public SQLiteDialect() {
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.VARCHAR, "varchar");
    }

    public IdentityColumnSupport getIdentityColumnSupport() {
        return new SQLiteIdentityColumnSupport();
    }

    public String getAddColumnString() {
        return "";
    }
}