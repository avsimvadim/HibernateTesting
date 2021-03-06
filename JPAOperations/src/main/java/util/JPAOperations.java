package util;

import modelSimple.Employees;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAOperations {
    private static Logger LOG = Logger.getLogger(JPAOperations.class);
    public static void createEmployee(){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("operations");

        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction().begin();
        Employees employee = new Employees();
        employee.setEname("Vadym");
        employee.setSalary(40000 + (int)(Math.random() * 500));
        employee.setDeg("Technical Manager");
        entitymanager.persist(employee);
        entitymanager.getTransaction().commit();
        LOG.info("CREATED");
        entitymanager.close();
        emfactory.close();
    }

    public static void updateEmployee(){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "operations" );

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Employees employee = entitymanager.find(Employees.class,12);

        //before update
        System.out.println(employee);
        employee.setSalary(46000);
        entitymanager.getTransaction().commit();

        //after update
        System.out.println(employee);
        LOG.info("UPDATE");
        entitymanager.close();
        emfactory.close();
    }

    public static void findEmployee(){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "operations" );
        EntityManager entitymanager = emfactory.createEntityManager();
        Employees employee = entitymanager.find( Employees.class, 12);

        System.out.println("employee ID = " + employee.getEid( ));
        System.out.println("employee NAME = " + employee.getEname( ));
        System.out.println("employee SALARY = " + employee.getSalary( ));
        System.out.println("employee DESIGNATION = " + employee.getDeg( ));
        LOG.info("FIND");
        entitymanager.close();
        emfactory.close();

    }

    public static void deleteEmployee(){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "operations" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        Employees employee = entitymanager.find(Employees.class,2);
        entitymanager.remove(employee);
        entitymanager.getTransaction().commit();
        LOG.info("DELETE");

        entitymanager.close( );
        emfactory.close( );
    }

}
