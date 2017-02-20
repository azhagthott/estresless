package com.zecovery.android.estresless.models;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Pending extends SugarRecord implements Serializable {

    private String name, description;
    private boolean done;

    public Pending() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
