/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlstudent;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author USER
 */
public class Search {
    public static void Search(){
        try{
            Scanner sc = new Scanner(System.in);
            SessionFactory sessisonfactory;
            sessisonfactory = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessisonfactory.openSession();
            Student student = new Student();
            String hql = "from Student where masv= :masv";
            Query query = session.createQuery(hql);
            System.out.println("Nhap vao ma sinh vien can tim kiem : ");
            int a = Integer.parseInt(sc.nextLine());
            String hql2="from Student";
            Query query2 = session.createQuery(hql2);
            List<Student> list = query2.list();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getMasv()==a){
                    System.out.println(list.get(i).toString());
                    session.beginTransaction().commit();
                    session.close();
                    sessisonfactory.close();
                }
            }
        }catch(Exception e){
            System.out.println("Loi : "+e);
        }
    }
}
