package org.student.mainlogic;

import java.util.Scanner;

import org.student.service.implementation.StudentJdbcOperationsImplementation;

public class MainLogic {

	public void crudOperations() throws Exception {
		
		StudentJdbcOperationsImplementation sj = new StudentJdbcOperationsImplementation();
		sj.createTable();
		Scanner sc = new Scanner(System.in);
		String choice = "";
		do {
			System.out.println("1.Insert 2.Display 3.Update 4.Delete 5.exit");
			System.out.println("select any one option");
			int option = sc.nextInt();
			System.out.println(option);
			switch (option) {
			case 1:
				sj.addStudent();
				break;
			case 2:
				sj.displayStudent();
				break;
			case 3:
				sj.updateStudent();
				break;
			case 4:
				sj.deleteStudent();
				break;
			case 5:
				break;
			default:
				System.out.println("invalid option");
				break;
			
			}
			System.out.println("do you want to continue Y/N");
			choice = sc.next();
			System.out.println(choice);
		} while (choice.equalsIgnoreCase("Y"));
	}
}
