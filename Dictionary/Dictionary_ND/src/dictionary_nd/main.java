/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_nd;

//@author Duong_rico
import java.util.Scanner;

public class main {
    DictionaryManagement dk;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.print("Nhập tên: ");
		String name = input.nextLine();
		System.out.print("Nhập tuổi: ");
		int age = Integer.parseInt(input.nextLine()); // đã xử lý trôi lệnh
		System.out.print("Nhập địa chỉ: ");
		String address = input.nextLine();
		
		System.out.println(name + " -- " + age + " -- " + address);
    }

}
