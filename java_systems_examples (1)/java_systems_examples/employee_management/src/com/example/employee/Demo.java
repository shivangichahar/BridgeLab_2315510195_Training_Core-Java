package com.example.employee;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("FT001", "Alice", 50000, 8000));
        employees.add(new PartTimeEmployee("PT001", "Bob", 10000, 80, 150));

        for (Employee e : employees) {
            e.displayDetails();
            System.out.println("Calculated Salary: " + e.calculateSalary());
            System.out.println("-----");
        }
    }
}

