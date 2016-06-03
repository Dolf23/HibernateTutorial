package com.javahash.hibernate.dao;

import com.javahash.hibernate.HibernateSessionManager;
import com.javahash.hibernate.Exceptions.UserExistsException;
import com.javahash.hibernate.dto.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class UserDAO implements IDAO<User>{
    private Session session;

    public UserDAO(){
        session = HibernateSessionManager.getSessionFactory().openSession();
    }

    @Override
    public void add(User user) {
        session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        user.setCreatedBy("Application");
        user.setCreatedDate(new Date());

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) throws UserExistsException{
        session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);

        if (null == user)
            throw new UserExistsException("User does not exist with id=" + id + ".\n");

        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(User user) throws UserExistsException{
        session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        User userUpdate = (User) session.get(User.class, user.getUserId());

        if (null == userUpdate)
            throw new UserExistsException("User does not exist with id=" + user.getUserId() + ".\n");
        userUpdate.setUsername(user.getUsername());

        session.saveOrUpdate(userUpdate);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User show(int id) throws UserExistsException{
        session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        if (null == user)
            throw new UserExistsException("User does not exist with id=" + id + ".\n");

        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<User> showAll() {
        session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");
        List<User> list = query.list();

        session.getTransaction().commit();
        session.close();
        return list;
    }
}