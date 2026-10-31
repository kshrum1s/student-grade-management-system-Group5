import java.util.Scanner;
public class StudentGradeManager {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final int max = 50;
		String[] names = new String[max];
		double[] grades = new double[max];
		int count = 0;
		
		boolean running = true;
		while(running) {
			System.out.println("Welcome to Student Grade Management System");
			System.out.println("1.Add Student and Grade");
			System.out.println("2.Display All Student and Grades");
			System.out.println("3.Find a Student's Grade");
			System.out.println("4.Calculate the Class Average");
			System.out.println("5.Find the Highest and Lowest Grades");
			System.out.println("6.Exit Program");
			System.out.println("Please enter your choice (1-6): ");
			int choice;
			if(input.hasNextInt()) {
				choice = input.nextInt();
				input.nextLine();}
			else {
				System.out.println("Invalid option, Please enter your choice (1-6): ");
				input.nextLine();
				continue;
			}
			switch(choice) {
			case 1:
				if(count>=max) {
					System.out.println("Error: Max capcity reached");
					break;
				}
				System.out.print("Enter Students Name: ");
				String name = input.nextLine();
				System.out.print("Enter Students Grade: ");
				if(input.hasNextDouble()) {
					double grade = input.nextDouble();
					input.nextLine();
					names[count]=name;
					grades[count]=grade;
					count++;
					System.out.println("Student name and grade added successfully.");}
				else {
					System.out.println("Invalid grade. Please enter value between 0 and 100.");
					input.nextLine();
				}
				break;
			case 2:
				if(count==0) {
					System.out.println("No student records.");}
				else {
					System.out.println("List of Students and Grades:");
					for(int i =0; i <count; i++) {
						System.out.println((i+1)+"Name: "+names[i]+" - "+grades[i]);}
				}
				break;
			case 3:
				if(count==0) {
					System.out.println("No student records.");
					break;}
				System.out.print("Enter Students name: ");
				String search = input.nextLine();
				boolean found = false;
				for(int i=0; i<count; i++) {
					if(names[i].equalsIgnoreCase(search)) {
						System.out.println(names[i]+"'s Grade: "+grades[i]);
						found = true;
						break;}
				}
				if(!found) {
					System.out.println(search+" Not found in Student list.");}
				break;
			case 4:
				if(count==0) {
					System.out.println("No student records.");}
				else {
					double sum = 0;
					for(int i=0; i<count;i++) {
						sum+=grades[i];}
				double ave = sum/count;
				System.out.println("Class Average: "+ave);
				}
				break;
			case 5:
				if(count==0) {
					System.out.println("No student records.");}
				else {
					int high =0;
					int low =0;
					for(int i=0; i<count;i++) {
						if(grades[i]>grades[high]) {
							high = i;}
						if(grades[i]<grades[low]) {
							low = i;}
					}
					System.out.println("Highest Grade: "+names[high]+" - "+grades[high]);
					System.out.println("Lowest Grade: "+names[low]+" - "+grades[low]);
				}
				break;
			case 6:
				System.out.println("Exiting the Program");
				running = false;
				break;
			default:
				System.out.println("Invalid choice. Please selct an option between 1 and 6.");
			}
		}
		
		input.close();}	
}
