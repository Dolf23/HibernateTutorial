package com.javahash.hibernate;

import org.hibernate.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Run {

    /**
     * @param args
     */
    private Session session = HibernateSessionManager.getSessionFactory().openSession();

    public static void main(String[] args) throws IOException {
        String menu = "Please enter the following command:\n" +
                "1. User add.\n" +
                "2. User update.\n" +
                "3. User delete.\n" +
                "4. Exit.";
        System.out.println("Hello.\n");
        System.out.println(menu);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rLine = reader.readLine();

        while (!rLine.equals("4")){
            switch (rLine)
        }

    }

    private void add(){
        session.beginTransaction();
        User user = new User();

        System.out.println("Enter name:\n");
        user.setUserId(3);
        user.setUsername("Chan");
        user.setCreatedBy("Application");
        user.setCreatedDate(new Date());

        session.save(user);
        session.getTransaction().commit();
    }

    private  void delete(){
        session.beginTransaction();
        User user = new User();

    }

    private void updete(){

    }

}
