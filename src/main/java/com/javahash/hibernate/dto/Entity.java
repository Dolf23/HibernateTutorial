package com.javahash.hibernate.dto;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    protected int id;

    @Override
    public String toString() {
        return "Entity=[" + id + "];";
    }
}
