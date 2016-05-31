package com.javahash.hibernate.dao;

import com.javahash.hibernate.dto.Entity;

import java.util.List;

public interface IDAO<TYPE extends Entity> {
    void add(TYPE type);
    void delete(int id);
    void update(TYPE type);
    TYPE show(int id);
    List<TYPE> showAll();
}
