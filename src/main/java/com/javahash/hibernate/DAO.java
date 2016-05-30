package com.javahash.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class DAO {
    private Session session;

    public void add(String name) throws IOException {
        session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        user.setUsername(name);
        user.setCreatedBy("Application");
        user.setCreatedDate(new Date());

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) throws IOException {
        session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);

        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public void update(int id, String name) throws IOException {
        session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        user.setUsername(name);

        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

    public void show(int id) throws IOException {
        session = HibernateSessionManager.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        String userInformation = user.getUserId() + " " + user.getUsername() + " " + user.getCreatedBy() + " " + user.getCreatedDate() + ";";
        System.out.println(userInformation);
        session.close();
    }

    public void showAll() throws IOException{
        session = HibernateSessionManager.getSessionFactory().openSession();
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        System.out.println();
        for (User user:list){
            String userInformation = user.getUserId() + " " + user.getUsername() + " " + user.getCreatedBy() + " " + user.getCreatedDate() + ";";
            System.out.println(userInformation);
        }
        System.out.println();
        session.close();
    }
}
