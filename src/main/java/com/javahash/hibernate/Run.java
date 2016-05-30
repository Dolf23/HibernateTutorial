package com.javahash.hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {

    /**
     * @param args
     */
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
        DAO dao = new DAO();

        while (!command.equals("6")) {
            switch (command) {
                case "1":{
                    dao.add();
                    System.out.println("User added.");
                }
                    break;
                case "2":{
                    System.out.print(enterId);
                    int id = Integer.parseInt(reader.readLine().trim());
                    dao.update(id);
                    System.out.println("User updated..");
                }
                    break;
                case "3":{
                    System.out.print(enterId);
                    int id = Integer.parseInt(reader.readLine().trim());
                    dao.delete(id);
                    System.out.println("User deleted.");
                }
                    break;
                case "4":{
                    System.out.print(enterId);
                    int id = Integer.parseInt(reader.readLine().trim());
                    dao.show(id);

                }
                    break;
                case "5":
                    dao.showAll();
                    break;
                default: {
                    System.out.println("Incorrect command.");
                }
            }
            System.out.println(menu);
            command = reader.readLine().trim();
        }

        System.out.println("Good Bye!");

    }

}
