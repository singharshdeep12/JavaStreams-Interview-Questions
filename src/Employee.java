import java.util.*;
import java.util.stream.Collectors;

class Employee{

    String name;
    String department;
    Double salary;

    boolean active;

    public Employee(String name, String department, Double salary, boolean active) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                '}';
    }
}


class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        // Creating 10 Employee objects and adding them to the list
        employeeList.add(new Employee("John Doe", "Finance", 50000.0, true));
        employeeList.add(new Employee("Jane Smith", "IT", 60000.0, true));
        employeeList.add(new Employee("Bob Johnson", "Finance", 72000.0, true));
        employeeList.add(new Employee("Alice Brown", "Marketing", 52000.0, false));
        employeeList.add(new Employee("Charlie Wilson", "Engineering", 70000.0, true));
        employeeList.add(new Employee("Eva Davis", "HR", 48000.0, false));
        employeeList.add(new Employee("Frank Miller", "Marketing", 65000.0, true));
        employeeList.add(new Employee("Grace Lee", "Finance", 58000.0, true));
        employeeList.add(new Employee("Henry Clark", "Marketing", 51000.0, true));
        employeeList.add(new Employee("Ivy Green", "Engineering", 72000.0, false));

        // Print the employeeList for verification
        employeeList.forEach
                (employee -> System.out.println(employee.name + " - " + employee.department +
                        " - $" + employee.salary + " - Active: " + employee.active));
        printDashes();


        //Program to print employee details working in each department
        employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.department))
                .forEach((k,v)-> System.out.println(k+" -> " + v));

        printDashes();

        //Program to print employee count working in each department
        employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.department,Collectors.counting()))
                .forEach((k,v)-> System.out.println(k+" -> " +v));

        printDashes();

        //Program to print active & inactive employees in given collection
        System.out.println("Active employees");
        employeeList.stream().filter(employee-> employee.active).forEach(System.out::println);
        System.out.println("InActive employees");
        employeeList.stream().filter(employee-> !employee.active).forEach(System.out::println);
        printDashes();


        //Program to print max min salary from employee list

        System.out.println("Max salary");
        employeeList.stream()
                .max(Comparator.comparingDouble(employee->employee.salary))
                .ifPresentOrElse(System.out::println,()-> System.out.println("No max found"));

        System.out.println("Min salary");
        employeeList.stream()
                .min(Comparator.comparingDouble(employee->employee.salary))
                .ifPresentOrElse(System.out::println,()-> System.out.println("No min found"));


        printDashes();

        //Program to print max min salaries (if multiple persons)  there from employee list
        System.out.println("Max salaries - 1 approach using keyset");
        Map<Double,List<Employee>> maxSalaries = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.salary));

        maxSalaries.keySet().stream()
                .max(Comparator.comparingDouble(s->s))
                .ifPresentOrElse(sal -> maxSalaries.get(sal).stream().forEach(System.out::println)
                        ,()-> System.out.println("No max found"));

        System.out.println("Min salaries - 2 approach using entryset");
        Map<Double,List<Employee>> minSalaries = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.salary));

        minSalaries.entrySet().stream()
                .min(Comparator.comparingDouble(s->s.getKey()))
                .ifPresentOrElse(sal -> sal.getValue().stream().forEach(System.out::println)
                        ,()-> System.out.println("No min found"));
        printDashes();


        //Program to print max min salary of employee from each department
        System.out.println("Max salary from each department");
        employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                emp->emp.department,
                                Collectors.maxBy(Comparator.comparingDouble(emp-> emp.salary)))
                ).forEach((k,v)-> System.out.println(k+" -> "+v.get()));

        System.out.println("Min salary from each department");
        employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                emp->emp.department,
                                Collectors.minBy(Comparator.comparingDouble(emp-> emp.salary)))
                ).forEach((k,v)-> System.out.println(k+" -> "+v.get()));

        printDashes();


        //Program to find nth highest salary if all salaries unique
        System.out.println("Program to find nth highest salary if all salaries unique");
        int n=3;
        employeeList.stream().sorted((emp1,emp2)->Double.compare(emp2.salary,emp1.salary))
                .skip(n-1).findFirst().ifPresent(System.out::println);

printDashes();

        //Program to find nth highest salary if all salaries not unique - 1
        System.out.println("Program to find nth highest salary if all salaries not unique - 1");
        int n2=3;
        var map1 = employeeList.stream().sorted((emp1,emp2)->Double.compare(emp2.salary,emp1.salary))
                .collect(Collectors.groupingBy((e)->e.salary));

                map1
                .keySet()
                .stream().sorted(Comparator.reverseOrder())
                .skip(n2-1)
                .limit(1)
                .findFirst()
                .ifPresentOrElse((s)-> System.out.println(s + " belongs to " + map1.get(s)),
                        ()-> System.out.println("No such element found"));


        printDashes();

        //Program to find nth highest salary if all salaries not unique - 2
        System.out.println("Program to find nth highest salary if all salaries not unique - 2");
        int n3=3;
        Map.Entry<Double, List<String>> first = employeeList.stream()
                .collect(Collectors.groupingBy((e) -> e.salary,
                        Collectors.mapping(e -> e.name,
                                Collectors.toList()
                        )))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .skip(n3 - 1)
                .findFirst()
                .get();

        System.out.println(first);

        printDashes();



    }


    static void printDashes(){

        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));
    }


}



