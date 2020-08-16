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
public class Insert {
    public static void Insert(){
         try{
            Scanner sc = new Scanner(System.in);
            SessionFactory sessisonfactory;
            sessisonfactory = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessisonfactory.openSession();
            Student student = new Student();           
                        String hql = "from Student";
                        Query query = session.createQuery(hql);
                        List<Student> listStudent = query.list();
                        int a;
                        if(listStudent.get(listStudent.size()-1)==null){
                        a=0;
                        }
                        else{
                        a = listStudent.get(listStudent.size()-1).getMasv() + 1;
                        }
                        student.setMasv(a);
                        System.out.println("Nhap vao ten sinh vien : ");
                        String b = sc.nextLine();
                        student.setName(b);
                        while(true){
                            System.out.println("Nhap vao tuoi : ");
                            int ip = Integer.parseInt(sc.nextLine());
                            boolean ck = student.setOld(ip);
                            if(ck==true){
                                break;
                            }
                        }
                        System.out.println("Nhap vao lop : ");
                        String c = sc.nextLine();
                        student.setClass_(c);
                        session.save(student);
                        System.out.println("Them du lieu thanh cong !");
                        session.beginTransaction().commit();
                        session.close();
                        sessisonfactory.close();
            
         }catch(Exception e){
             System.out.println("Loi : "+e);
         }
    }
}
