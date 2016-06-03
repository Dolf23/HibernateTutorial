package com.javahash.hibernate.dao;

import com.javahash.hibernate.Exceptions.UserExistsException;
import com.javahash.hibernate.dto.Entity;

import java.util.List;

public interface IDAO<TYPE extends Entity> {
    void add(TYPE type);
    void delete(int id) throws UserExistsException;
    void update(TYPE type) throws UserExistsException;
    TYPE show(int id) throws UserExistsException;
    List<TYPE> showAll();
}
