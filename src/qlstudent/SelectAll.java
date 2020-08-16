/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlstudent;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author USER
 */
public class SelectAll {
    public static void SelectAll(){
        try{
            SessionFactory sessisonfactory;
            sessisonfactory = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessisonfactory.openSession();
            Student student = new Student();
            String hql = "from Student";
            Query query = session.createQuery(hql);
            List<Student> listStudent = query.list();
            for (Student st : listStudent) {
                System.out.println(st.toString());
            }
            System.out.println("Thanh cong !");
            session.beginTransaction().commit();
            session.close();
            sessisonfactory.close();
        }catch(Exception e){
            System.out.println("Loi : "+e);
        }
    }
}
