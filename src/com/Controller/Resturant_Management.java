package com.Controller;

import java.util.*;

import com.DAO.ResturantdaoImplements;

public class Resturant_Management {

	public static void main(String[] args) {
		Resturant_Management rms = new Resturant_Management();
		rms.run();
	}

	public void run() {
		ResturantdaoImplements rm = new ResturantdaoImplements();
		Scanner sc = new Scanner(System.in);

		boolean i;
		i = true;
		do {
			System.out.println("***************************************");
			System.out.println("Enter the choice: ");
			System.out.println("1.Enter the details of your Resturant ");
			System.out.println("2.To search the Resturants ");
			System.out.println("3.To Update the Details of the Resturant");
			System.out.println("4.To Delete the Details of the Resturant");
			System.out.println("5.Display all the Resturant Details");
			System.out.println("6.Sort the Resturant Details");
			System.out.println("***************************************");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				rm.insert();
				break;
			case 2:
				rm.getResturantName();
				break;
			case 3:
				rm.UpdateResturantDetails();
				break;
			case 4:
				rm.deleteResturantDetails();
				break;
			case 5:
				rm.DisplayNoOfRetsurants();
				break;
			case 6:
				rm.sort();
				break;
			}
			System.out.println("Do you want to Continue [yes/No]: ");
			String str = sc.next();
			if (str.equalsIgnoreCase("Yes")) {
				i = true;
			} else if (str.equalsIgnoreCase("No")) {
				i = false;
			}
			System.out.println("Have a Nice Day!!");

		} while (i);
		
		sc.close();

	}

}
