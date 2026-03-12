package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.Scanner;

public class ClientDemo
{
public static void main(String[] args)
{
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session session = sf.openSession();

Scanner sc = new Scanner(System.in);

System.out.println("1.Insert");
System.out.println("2.View");

int ch = sc.nextInt();

if(ch==1)
{
Transaction tx = session.beginTransaction();

Hospital h = new Hospital();

System.out.println("Enter Name:");
h.setName(sc.next());

System.out.println("Enter Description:");
h.setDescription(sc.next());

h.setDate(new Date());

System.out.println("Enter Status:");
h.setStatus(sc.next());

session.save(h);

tx.commit();

System.out.println("Record Inserted");
}

if(ch==2)
{
System.out.println("Enter ID:");
int id = sc.nextInt();

Hospital h = session.get(Hospital.class,id);

if(h!=null)
{
System.out.println(h.getId());
System.out.println(h.getName());
System.out.println(h.getDescription());
System.out.println(h.getDate());
System.out.println(h.getStatus());
}
else
{
System.out.println("Record Not Found");
}
}

session.close();
sf.close();
}
}