package com.hand.test;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		double salary = 0;
		String b = null;
		@SuppressWarnings("resource")
		Scanner sc =  new Scanner(System.in);
		do{
		System.out.print("请输入工资：");
		salary = sc.nextDouble();
		System.out.println("所需要缴纳的税费：" + get_tax(salary));
		System.out.print("是否继续(Y/N)：");
		b = sc.next();
		} while("Y".equals(b));
	}
	
	public static double get_tax(double salary){
		double amount;
		double tax = 0;
		if (salary <= 3500){
			System.out.println("不交税！");
		} else {
			amount = salary - 3500;
			if (amount <= 1500){
				tax = amount * 0.03;
			} else if (amount <= 4500){
				//1500 * 0.03 + (amount - 1500) * 0.1
				tax = amount * 0.1 - 105;
			} else if (amount <= 9000){
				//4500 * 0.1 -105 + (amount - 4500) * 0.2
				tax = amount * 0.2 - 555;
			} else if (amount <= 35000){
				//9000 * 0.2 - 555 + (amount - 9000) * 0.25
				tax = amount * 0.25 - 1005;
			} else if (amount <= 55000){
				//35000 * 0.25 - 1005 + (amount - 35000) * 0.3
				tax = amount * 0.3 - 2755;
			} else if (amount <= 80000){
				//55000 * 0.3 - 2755 + (amount - 55000) * 0.35
				tax = amount * 0.35 - 5505;
			} else {
				//80000 * 0.35 - 5505 + (amount - 80000) * 0.45
				tax = amount * 0.45 - 13505;
			}
		}
		return tax;	
	}
}
