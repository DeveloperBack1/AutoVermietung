package com.schneider.autovermietung;

import com.schneider.autovermietung.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hiber {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("db/hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();


            try {

                Session session = factory.getCurrentSession();

Car cars1 = new Car(1,"X3", "BMW",23.5,true);
Car cars2 = new Car(2,"5", "BMW",21.5,true);
Car cars3 = new Car(3,"325", "BMW",15.5,true);

                session.beginTransaction();
                session.save(cars1);
                session.save(cars2);
                session.save(cars3);




                session.getTransaction().commit();

                System.out.println("Done");

            } finally {
                factory.close();
            }


        }
    }



