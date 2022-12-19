package org.example;

public class Main {

    public static void main(String[] args) {
        String password = "tien123";
        ManageEmployee manageEmployee = new ManageEmployee();
//        manageEmployee.addEmployee("Tien Nguyen","29/10/2000","tien@gmail.com",password);
//        manageEmployee.addEmployee("Harry Potter","10/10/2000","tienhihi@gmail.com",password);
        manageEmployee.listEmployees();
        manageEmployee.updateEmployee(2,"Harry Lu");
        System.out.println("After Update");
        manageEmployee.listEmployees();
        manageEmployee.deleteEmployee(2);
        System.out.println("\tAfter delete");
        manageEmployee.listEmployees();
        // laay tuwf class
//        List<Department> deps = session.createQuery("FROM Department").list();
//        System.out.println("\t Department");
//        deps.forEach(c -> System.out.println("Name: "+ c.getName()));
    }
}