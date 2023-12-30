package org.example;


public class Main {
    public static void main(String[] args) {
       CreateTable obj = new CreateTable();
       obj.createTable();
       Student student = new Student("Giorgi", 17);
       StudentDao studentDao = new StudentDao();
       studentDao.insertOperation(student);
       studentDao.updateOperation(1, "nika");
       studentDao.deleteOperation(2, "Giorgi");

    }
}