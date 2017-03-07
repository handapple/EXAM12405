package com.hand.test;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String b = null;
		// 输入的日期格式必须为：yyyy-mm-dd
		do {
			System.out.print("请输入输入日期：");
			String str = sc.next();
			get_date(str);
			System.out.print("是否继续(Y/N)：");
			b = sc.next();
		} while ("Y".equals(b));

	}

	public static void get_date(String str) {
		boolean status = false;
		String str1[] = null;
		if (str.split("-").length > 1) {
			str1 = str.split("-");
		} else if (str.split("/").length > 1) {
			str1 = str.split("/");
		}
		//输入的日期必须包含年 、月、日，且需要使用分隔符分割
		if (str1.length == 3) {
			int year = new Integer(str1[0]);
			int month = new Integer(str1[1]);
			int day = new Integer(str1[2]);
			if (month <= 12 && month >= 1) {
				switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12: {
					if (day >= 1 && day <= 31) {
						if (day < 31) {
							day++;
						} else {
							if (month < 12) {
								month++;
								day = 1;
							} else {
								year++;
								month = 1;
								day = 1;
							}
						}

					} else {
						status = true;
					}
					break;
				}
				case 2: {
					//判断是否为瑞年
					if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
						if (day >= 1 && day <= 29) {
							if (day < 29) {
								day++;
							} else {
								month++;
								day = 1;
							}
						} else {
							status = true;
						}
					} else {
						if (day >= 1 && day <= 28) {
							if (day < 28) {
								day++;
							} else {
								month++;
								day = 1;
							}
						} else {
							status = true;
						}
					}
					break;
				}
				case 4:
				case 6:
				case 9:
				case 11: {
					if (day >= 1 && day <= 30) {
						if (day < 30) {
							day++;
						} else {
							month++;
							day = 1;
						}
					} else {
						status = true;
					}
					break;
				}
				}
			} else {
				status = true;

			}
			if (status) {
				System.out.println("您输入的日期不存在！");
			} else {
				if (month <= 9 && day > 9) {
					System.out.println("下一天为：" + year + "-0" + month + "-"
							+ day);
				} else if (month <= 9 && day <= 9) {
					System.out.println("下一天为：" + year + "-0" + month + "-0"
							+ day);
				} else if (month > 9 && day <= 9) {
					System.out.println("下一天为：" + year + "-" + month + "-0"
							+ day);
				} else {
					System.out
							.println("下一天为：" + year + "-" + month + "-" + day);
				}
			}
		} else {
			System.out.println("您输入的日期不存在！");
		}
	}
}
