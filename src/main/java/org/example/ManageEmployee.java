package org.example;

import org.hibernate.Session;
import pojo.Department;
import pojo.Employee;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ManageEmployee {
    public void addEmployee(String userName, String date, String email, String pass){
        try( Session session = HibernateUtil.getSessionFactory().openSession()){
            session.getTransaction().begin();
            Department d = session.get(Department.class,2);
            Employee e = new Employee();
            String password = pass;
            e.setUserName(userName);
            e.setDateOfBirth(new SimpleDateFormat("dd/mm/yyyy").parse(date));
            e.setEmail(email);
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            e.setPassword(md.digest().toString());
            e.setDepartment(d);

            session.save(e);
            session.getTransaction().commit();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public void listEmployees(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.getTransaction().begin();
            List<Employee> employees = session.createQuery("FROM Employee").list();
            System.out.println("------------------------------------------------------------");
            System.out.println("EmployeeId | UserName    | Date Of Birth       | Email      |  Department");
            employees.forEach(e ->{
                System.out.println("------------------------------------------------------------");
                System.out.println(e.getEmployeeId()+"          |"+ e.getUserName()+"  |"+ e.getDateOfBirth() +"|"+e.getEmail()
                    +"  |"+ e.getDepartment().getName());
            });
            System.out.println("------------------------------------------------------------");
            session.getTransaction().commit();
        }
    }

    public void updateEmployee(int Id, String UserName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Employee employee =(Employee) session.get(Employee.class,Id);
        employee.setUserName(UserName);

        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }
    public void deleteEmployee(int Id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.getTransaction().begin();
            Employee e = (Employee) session.get(Employee.class,Id);
            session.delete(e);
            session.getTransaction().commit();
        }
    }
}
