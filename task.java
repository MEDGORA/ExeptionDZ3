import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class task {

    static String info = null;
    static String fileName = null;

        public static void pushName(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.nextLine();
        String str1 = "";
        if (name.equals(str1)){
            name = null;
            try {
                name.equals(str1);
            } catch (NullPointerException e) {
                System.out.println("Имя не может быть пустым");
            }
        } else {
            info = info + name + " ";
        }
        in.close();
    }


        public static void pushSecondName(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        String secondName = in.nextLine();
        String str1 = "";
        if (secondName.equals(str1)){
            secondName = null;
            try {
                secondName.equals(str1);
            } catch (NullPointerException e) {
                System.out.println("Фамилия не может быть пустой");
            }
        } else {
            fileName = secondName;
            info = info + secondName + " ";
        }
        in.close();
    }

    public static void pushLastName(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите отчество: ");
        String lastName = in.nextLine();
        String str1 = "";
        if (lastName.equals(str1)){
            lastName = null;
            try {
                lastName.equals(str1);
            } catch (NullPointerException e) {
                System.out.println("Отчество не может быть пустой");
            }
        } else {
            info = info + lastName + ", ";
        }
        in.close();
    }

    public static void pushDateOfBirth(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату рождния в формате dd.mm.yyyy : ");
        String dateOFBirth = in.nextLine();
        String str1 = "";

        if (dateOFBirth.equals(str1)){
            dateOFBirth = null;
            try {
                dateOFBirth.equals(str1);
            } catch (NullPointerException e) {
                System.out.println("Дата рождения не может быть пустой");
            }
        }

        if (dateOFBirth.length() != 10) {
            throw new RuntimeErrorException(null, "Неверно введена дата рождения");
        } 

        else {

        String dd = dateOFBirth.substring(0,2); 
        try {
        int day = Integer.parseInt (dd);
        } catch (Exception e) {
            System.out.println("Неверно введён день рождения");
        }
        int day = Integer.parseInt (dd);
        if (day < 1 || day > 31) {
            throw new RuntimeErrorException(null, "Неверно введён день рождения");
        } 

        String mm = dateOFBirth.substring(3,5); 
        try {
        int manth = Integer.parseInt (mm);
        } catch (Exception e) {
            System.out.println("Неверно введён месяц рождения");
        }
        int manth = Integer.parseInt (mm);
        if (manth < 1 || manth > 12) {
            throw new RuntimeErrorException(null, "Неверно введён месяц рождения");
        } 

        String yyyy = dateOFBirth.substring(5); 
        try {
        int year = Integer.parseInt (yyyy);
        } catch (Exception e) {
            System.out.println("Неверно введён год рождения");
        }
        int year = Integer.parseInt (yyyy);
        if (year < 1900 || year > 2023) {
            throw new RuntimeErrorException(null, "Неверно введён год рождения");
        } 

            info = info + dateOFBirth + ", ";

        }
        in.close();
    }

    public static void pushPhoneNumber(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер телефона +7: ");
        String phoneNumber = in.nextLine();
        String str1 = "";
        if (phoneNumber.length() != 9) {
            throw new RuntimeErrorException(null, "Неверно введён номер телефона");
        } 

        if (phoneNumber.equals(str1)){
            phoneNumber = null;
            try {
                phoneNumber.equals(str1);
            } catch (NullPointerException e) {
                System.out.println("Номер телефона не может быть пустым");
            }
        } else {

            try {
                int number = Integer.parseInt (phoneNumber);
            } catch (Exception e) {
                System.out.println("Неверно введён номер телефона");
            }

            info = info + phoneNumber + ", ";
        }
        in.close();
    }


    public static void pushSex(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите пол символ латиницей f или m : ");
        String sex = in.nextLine();
        String str1 = "";
        String str2 = "f";
        String str3 = "m";
        if (!sex.equals(str2) && !sex.equals(str3)){
            throw new RuntimeErrorException(null, "Неверно введён пол");
        }
        if (sex.equals(str1)){
            sex = null;
            try {
                sex.equals(str1);
            } catch (NullPointerException e) {
                System.out.println("Пол не может быть пустым");
            }
        } else {
            info = info + sex + ". ";
        }
        in.close();
    }
    
    public static void save(){

        if(Files.isRegularFile(Path.of("c:\\" + fileName + ".txt")) == true){
        
        File file = new File("c:\\" + fileName + ".txt");
        String text = info;
 
        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8))
        {
            out.print(text);
            System.out.println("Successfully written data to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        } else {
            try {
                Files.createFile(Path.of("c:\\" + fileName + ".txt"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        File file = new File("c:\\" + fileName + ".txt");
        String text = info;
 
        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8))
        {
            out.print(text);
            System.out.println("Successfully written data to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        }

    }

    public static void run(){
        pushName();
        pushSecondName();
        pushLastName();
        pushDateOfBirth();
        pushPhoneNumber();
        pushSex();
        save();
    }


    public static void main(String[] args) {
        run();
    }
}