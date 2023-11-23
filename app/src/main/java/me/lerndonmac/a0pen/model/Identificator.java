package me.lerndonmac.a0pen.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "identificatori")
public class Identificator {
    @DatabaseField(columnName = "id")
    private long id;
    @DatabaseField(columnName = "name")
    private String name;

    public Identificator() {
    }

    public Identificator(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
