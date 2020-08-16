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
public class Delete {
    public static void Delete(){
        try{
            Scanner sc = new Scanner(System.in);
            SessionFactory sessisonfactory;
            sessisonfactory = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessisonfactory.openSession();
            Student student = new Student();
            String hql = "delete from Student where masv = :masv";
            Query query = session.createQuery(hql);
            
            
            
            System.out.println("Nhap vao ma sinh vien can xoa : ");
            int a = Integer.parseInt(sc.nextLine());
            String hql2="from Student";
            Query query2 = session.createQuery(hql2);
            List<Student> list = query2.list();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getMasv()==a){
                        query.setParameter("masv",a);
                        int r = query.executeUpdate();
                        if (r > 0) {
                            System.out.println("Thanh cong !");
                        }else{
                            System.out.println("That bai !");
                        }
                    session.beginTransaction().commit();
                    session.close();
                    sessisonfactory.close();
                }else{
                    System.out.println("khong tim thay ma sinh vien ?");
                }
            }
            
        }catch(Exception e){
            System.out.println("Loi : "+e);
        }
    }
}
