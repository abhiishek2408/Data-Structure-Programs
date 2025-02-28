package Heap;

import java.util.*;

class Employee {
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name;
    }
}

class CustomComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e2.salary, e1.salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Abhijeet", 40000);
        Employee e2 = new Employee(2, "Abhishek", 30000);
        Employee e3 = new Employee(3, "Aditi", 35000);

        PriorityQueue<Employee> pq = new PriorityQueue<>(new CustomComparator());
        pq.add(e1);
        pq.add(e2);
        pq.add(e3);

        List<Employee> list = Arrays.asList(e1, e2, e3);
        list.sort(new CustomComparator());

        System.out.println(pq.peek());
    }
}

