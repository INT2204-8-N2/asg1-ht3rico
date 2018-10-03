/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author HT3rico
 */
import java.util.*;

public class DictionaryManegement {
    
    Dictionary diction = new Dictionary();
    
    public void insertFromCommandline(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập số lượng từ : ");
        int SoTu = scan.nextInt();
        scan.nextLine();
       
        for (int i = 1; i <= SoTu ; i++) {
            Word word = new Word();
            System.out.println(i+" : nhập từ Tiếng Anh : ");
            word.spelling = scan.nextLine();
            System.out.println("Giải nghĩa : ");
            word.explain = scan.nextLine();
            diction.words.put(word.spelling,word.explain);
        }
    } 
    public void showAllWorlds() {
        System.out.println( "English 	| Vietnamese");
        diction.words.forEach((eng,viet)->{  
            System.out.printf("%-15s\t%-15s\n" ,eng,viet);
        });   
    }
}