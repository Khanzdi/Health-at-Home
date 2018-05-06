package com.example.brayandavid.homemedicines.Objects;

import java.io.Serializable;

/**
 * Created by Kevin Ortiz on 14/03/2018.
 */

public class Category implements Serializable {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
