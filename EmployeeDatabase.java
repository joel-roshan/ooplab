import java.util.Scanner;

class Employee {
     int empId;
     String empName;
     int empAge;
     String empGender;
     String empDesignation;
     double empSalary;
     String empAddress;

     Employee(int empId, String empName, int empAge, String empGender, String empDesignation, double empSalary, String empAddress) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empGender = empGender;
        this.empDesignation = empDesignation;
        this.empSalary = empSalary;
        this.empAddress = empAddress;
    }

     int getEmpId() {
        return empId;
    }

     String getEmpName() {
        return empName;
    }

     int getEmpAge() {
        return empAge;
    }

     String getEmpGender() {
        return empGender;
    }

     String getEmpDesignation() {
        return empDesignation;
    }

     double getEmpSalary() {
        return empSalary;
    }

     String getEmpAddress() {
        return empAddress;
    }
}

 class EmployeeDatabase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        Employee[] employees = new Employee[n];

        // Input employee details
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Name: ");
            String empName = sc.nextLine();
            System.out.print("Age: ");
            int empAge = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Gender: ");
            String empGender = sc.nextLine();
            System.out.print("Designation: ");
            String empDesignation = sc.nextLine();
            System.out.print("Salary: ");
            double empSalary = sc.nextDouble();
            sc.nextLine(); // Consume newline
            System.out.print("Address: ");
            String empAddress = sc.nextLine();

            employees[i] = new Employee(empId, empName, empAge, empGender, empDesignation, empSalary, empAddress);
        }

        // Input the required employee ID
        System.out.print("Enter the employee ID to display details: ");
        int requiredEmpId = sc.nextInt();

        // Find and display the details of the required employee
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getEmpId() == requiredEmpId) {
                System.out.println("\nEmployee Details for ID " + requiredEmpId + ":");
                System.out.println("Name: " + emp.getEmpName());
                System.out.println("Age: " + emp.getEmpAge());
                System.out.println("Gender: " + emp.getEmpGender());
                System.out.println("Designation: " + emp.getEmpDesignation());
                System.out.println("Salary: " + emp.getEmpSalary());
                System.out.println("Address: " + emp.getEmpAddress());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + requiredEmpId + " not found.");
        }
    }
}
