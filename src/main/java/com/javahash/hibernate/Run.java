package com.javahash.hibernate;

import com.javahash.hibernate.dao.UserDAO;
import com.javahash.hibernate.dto.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Run {

    public static void main(String[] args) throws IOException {
        String menu = "Please enter the following command:\n" +
                "1. Add user.\n" +
                "2. Update user.\n" +
                "3. Delete.\n" +
                "4. Show user.\n" +
                "5. Show all user.\n" +
                "6. Exit.";
        String enterId = "Enter ID:";
        System.out.println("Hello.\n");
        System.out.println(menu);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine().trim();

        int id;
        String name;
        User user;
        UserDAO userDao = new UserDAO();

        while (!command.equals("6")) {
            switch (command) {
                case "1":
                    System.out.print("Enter name:");
                    name = reader.readLine();
                    user = new User();
                    user.setUsername(name);
                    userDao.add(user);
                    System.out.println("User added.\n");
                    break;

                case "2":
                    System.out.print(enterId);
                    id = Integer.parseInt(reader.readLine().trim());
                    System.out.print("Enter new name:");
                    name = reader.readLine();
                    user = new User();
                    user.setUserId(id);
                    user.setUsername(name);
                    userDao.update(user);
                    System.out.println("User updated.\n");
                    break;

                case "3":
                    System.out.print(enterId);
                    id = Integer.parseInt(reader.readLine().trim());
                    userDao.delete(id);
                    System.out.println("User deleted.\n");
                    break;

                case "4":
                    System.out.print(enterId);
                    id = Integer.parseInt(reader.readLine().trim());
                    System.out.println(userDao.show(id));
                    System.out.println();
                    break;

                case "5":
                    List<User> list = userDao.showAll();
                    list.forEach(System.out::println);
                    System.out.println();
                    break;
                default: {
                    System.out.println("Incorrect command.");
                }
            }
            System.out.println(menu);
            command = reader.readLine().trim();
        }

        System.out.println("Good Bye!");
        HibernateSessionManager.shutdown();
    }

}
