/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlstudent;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class QLStudent {

    /**
     * @param args the command line arguments
     */
    static void menu(){
        System.out.println("     1. Xem danh sach");
        System.out.println("     2. Them sinh vien");
        System.out.println("     3. Sua thong tin sinh vien");
        System.out.println("     4. Tim kiem sinh vien");
        System.out.println("     5. Xoa sinh vien");
        System.out.println("     6. Thoat.");
        System.out.println("   choose:");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int chon;
        do{
            menu();
            chon = Integer.parseInt(sc.nextLine());
            switch(chon){
                case 1:
                    SelectAll.SelectAll();
                    break;
                case 2:
                    Insert.Insert();
                    break;
                case 3:
                    Update.Update();
                    break;
                case 4:
                    Search.Search();
                    break;
                case 5:
                    Delete.Delete();
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        }while(chon!=6);
    }
    
}
