package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import pojo.Department;
import pojo.Employee;

import java.util.Properties;


public class HibernateUtil {
    private final static SessionFactory FACTORY;
     static {
         Configuration conf = new Configuration();
         Properties pros = new Properties();
         pros.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
         pros.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
         pros.put(Environment.URL,"jdbc:mysql://localhost/employeedb");
         pros.put(Environment.USER,"root");
         pros.put(Environment.PASS,"");

         conf.setProperties(pros);
         conf.addAnnotatedClass(Department.class);
         conf.addAnnotatedClass(Employee.class);
         ServiceRegistry registry = new StandardServiceRegistryBuilder()
                 .applySettings(conf.getProperties()).build();

         FACTORY = conf.buildSessionFactory(registry);
     }

     public static  SessionFactory getSessionFactory(){
         return FACTORY;
     }
}
