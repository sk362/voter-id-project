package com.tka.voterId;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {
    public static void main(String[] args) {
        Configuration cif = new Configuration();
        cif.configure();
        cif.addAnnotatedClass(Person.class);
        cif.addAnnotatedClass(VotingCard.class);
        cif.addAnnotatedClass(Address.class);

        SessionFactory factory = cif.buildSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {
            Session session = factory.openSession();
            Transaction tx = null;

            try {
                System.out.println("Welcome to Voter_id Management Portal");
                System.out.println();
                System.out.println("1. Insert/Save a Person into Database");
                System.out.println("2. Fetch Person using Aadhar_ID");
                System.out.println("3. Delete Person using Aadhar_ID");
                System.out.println("4. Get all Person Details");
                System.err.println("Enter Your Choice");

                int key = sc.nextInt();
                switch (key) {
                    case 1:
                        tx = session.beginTransaction();

                        Person p1 = new Person();
                        System.out.println("Enter Aadhar Number:");
                        p1.setAadhar_id(sc.nextInt());
                        System.out.println("Enter name of Person:");
                        p1.setName(sc.next());

                        VotingCard v1 = new VotingCard();
                        System.out.println("Enter Voting ID:");
                        v1.setVoter_id(sc.next());
                        System.out.println("Enter Constituency:");
                        v1.setConstituency(sc.next());

                        Address a1 = new Address();
                        System.out.println("Enter Pincode:");
                        a1.setPin_code(sc.nextInt());
                        System.out.println("Enter City:");
                        a1.setCity(sc.next());

                        p1.setAddress(a1);
                        p1.setVoter_id(v1);

                        session.save(p1);
                        tx.commit();
                        System.out.println("Person saved successfully.");
                        break;

                    case 2:
                        System.out.println("Enter Aadhar ID to fetch Details:");
                        int aadharId = sc.nextInt();
                        Person person = session.get(Person.class, aadharId);
                        if (person != null) {
                            System.out.println(person);
                        } else {
                            System.out.println("Person not found.");
                        }
                        break;

                    case 3:
                        tx = session.beginTransaction();

                        System.out.println("Enter Aadhar ID to Delete Person:");
                        int deleteId = sc.nextInt();
                        Person personToDelete = session.get(Person.class, deleteId);
                        if (personToDelete != null) {
                            session.delete(personToDelete);
                            tx.commit();
                            System.out.println("Person deleted successfully.");
                        } else {
                            System.out.println("Person not found.");
                        }
                        break;

                    case 4:
                        System.out.println("Fetching All Person Details:");
                        Criteria criteria = session.createCriteria(Person.class);
                        List<?> list = criteria.list();
                        for (Object object : list) {
                            System.out.println(object);
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }
}
