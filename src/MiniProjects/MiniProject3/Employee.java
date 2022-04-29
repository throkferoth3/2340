package MiniProjects.MiniProject3;

import java.util.List;
import java.util.ArrayList;

public class Employee {
    private String name;
    private String position;
    private String department;
    private int salary;
    private String gender;
    private boolean hasDependants;
    private List<Employee> children;
    private static List<String> departments = new ArrayList<String>();
    public Employee(String name, String position, String department, int salary, String gender, boolean hasDependants) {
        this.name = name;
        this.position = position;
        this.department = department;
        if (!departments.contains(department)) {
            if (departments.isEmpty()) {
                departments = new ArrayList<String>();
            }
            departments.add(department);
        }
        this.salary = salary;
        this.gender = gender;
        this.hasDependants = hasDependants;
        children = new ArrayList<Employee>();
    }
    public void addChild(Employee child) {
        children.add(child);
    }
    public String generateReport1() {
        String report1 = "Report 1:\n";
        List<String> container = new ArrayList<String>();
        container.add(report1);
        report1Helper(this, container);
        return container.get(0);
    }
    public String generateReport2() {
        String report2 = "Report 2:\n";
        List<String> container = new ArrayList<String>();
        container.add(report2);
        report2Helper(this, container);
        return container.get(0);
    }
    public String generateReport3() {
        String report3 = "Report 3:\n";
        List<String> container = new ArrayList<String>();
        container.add(report3);
        report3Helper(this, container);
        return container.get(0);
    }
    public String generateReport4() {
        String report4 = "Report 4:\n";
        for (String d : departments) {
            List<Integer> salaries = new ArrayList<Integer>();
            report4Helper(this, d, salaries);
            double total = 0.0;
            for (Integer i : salaries) {
                total += (double) i;
            }
            total /= salaries.size();
            report4 = report4.concat(String.format("%s: $%.2f.\n", d, total));
        }
        return report4;
    }
    public static List<String> getDepartments() {
        return departments;
    }
    private void report1Helper(Employee curr, List<String> container) {
        container.set(0, container.get(0).concat("Name: " + curr.name + ", Position: " + curr.position
                + ", Department: " + curr.department + ", Salary: " + curr.salary + ", Gender: " + curr.gender
                + ", Has Dependants: " + curr.hasDependants + "\n"));
        for (Employee employee : curr.children) {
            report1Helper(employee, container);
        }
    }
    private void report2Helper(Employee curr, List<String> container) {
        if (curr.gender.equals("Male") && curr.hasDependants) {
            container.set(0, container.get(0).concat("Name: " + curr.name + ", Position: " + curr.position
                    + ", Department: " + curr.department + ", Salary: " + curr.salary + ", Gender: " + curr.gender
                    + ", Has Dependants: " + curr.hasDependants + "\n"));
        }
        for (Employee employee : curr.children) {
            report2Helper(employee, container);
        }
    }
    private void report3Helper(Employee curr, List<String> container) {
        if (curr.gender.equals("Female")) {
            container.set(0, container.get(0).concat("Name: " + curr.name + ", Position: " + curr.position
                    + ", Department: " + curr.department + ", Salary: " + curr.salary + ", Gender: " + curr.gender
                    + ", Has Dependants: " + curr.hasDependants + "\n"));
        }
        for (Employee employee : curr.children) {
            report3Helper(employee, container);
        }
    }
    private void report4Helper(Employee curr, String d, List<Integer> salaries) {
        if (curr.department.equals(d)) {
            salaries.add(curr.salary);
        }
        for (Employee employee : curr.children) {
            report4Helper(employee, d, salaries);
        }
    }
}
