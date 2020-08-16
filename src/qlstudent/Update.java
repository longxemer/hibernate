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
public class Update {
    public static void Update(){
        try{
            Scanner sc = new Scanner(System.in);
            SessionFactory sessisonfactory;
            sessisonfactory = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessisonfactory.openSession();
            Student student = new Student();
            
            String hql = "update Student set name= :name,old= :old where masv= :masv";
            Query query = session.createQuery(hql);
            System.out.println("Nhap ma sinh vien can sua thong tin : ");
            int a = Integer.parseInt(sc.nextLine());
            String hql2="from Student";
            Query query2 = session.createQuery(hql2);
            List<Student> list = query2.list();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getMasv()==a){
                    System.out.println("Sua ten : ");
                    String b = sc.nextLine();
                    query.setParameter("name", b);
                    System.out.println("Sua tuoi : ");
                    int c = Integer.parseInt(sc.nextLine());
                    query.setParameter("old",c);
                    query.setParameter("masv",a);
                    int r = query.executeUpdate();
                    if (r > 0) {
                        System.out.println("Thanh cong !");
                    }else{
                        System.err.println("That bai !");
                    }
                    session.beginTransaction().commit();
                    session.close();
                    sessisonfactory.close();
                }
            } 
                System.out.println("Khong tim thay ma sinh vien can sua !");
        }catch(Exception e){
            System.out.println("Loi : "+e);
        }
    }
}
