package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class MainArray {
    public static final ArrayStorage ARRAY_STORAGE;

    static {
        ARRAY_STORAGE = new ArrayStorage();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Введите одну из команд \n(list | size | save | delete | get | update | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");

            if ((Objects.equals(params[0], "list") ||
                    Objects.equals(params[0], "size") ||
                    Objects.equals(params[0], "clear") ||
                    Objects.equals(params[0], "exit")
            ) && params.length == 1 ||
                    (Objects.equals(params[0], "delete") ||
                            Objects.equals(params[0], "get") ||
                            Objects.equals(params[0], "update") ||
                            Objects.equals(params[0], "save")
                    ) && params.length == 2) {
                //nothing
            } else {
                System.out.println("Неверная команда.");
                continue;
            }

            switch (params[0]) {
                case "list":
                    printAll();
                    break;

                case "size":
                    System.out.println(ARRAY_STORAGE.getSize() + " элементов");
                    break;

                case "save":
                    Resume r1 = new Resume(params[1]);
                    ARRAY_STORAGE.save(r1);
                    printAll();
                    break;

                case "update":
                    Resume r2 = new Resume(params[1]);
                    ARRAY_STORAGE.update(r2);
                    printAll();
                    break;

                case "delete":
                    ARRAY_STORAGE.delete(params[1]);
                    printAll();
                    break;

                case "get":
                    System.out.println(ARRAY_STORAGE.get(params[1]));
                    break;

                case "clear":
                    ARRAY_STORAGE.clear();
                    printAll();
                    break;

                case "exit":
                    return;

                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    public static void printAll() {
        Resume[] all = ARRAY_STORAGE.getAll();
        System.out.println("----------------------------");
        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}