package designPatterns.behavioural.visitor;

// 1. Visitor Interface
interface Visitor {
    void visit(Developer developer);
    void visit(Manager manager);
}

// 2. Concrete Visitor - implements operations
class BonusVisitor implements Visitor {
    @Override
    public void visit(Developer developer) {
        System.out.println("Developer Bonus: " + developer.getSalary() * 0.2);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Manager Bonus: " + manager.getSalary() * 0.3);
    }
}

class PerformanceReviewVisitor implements Visitor {
    @Override
    public void visit(Developer developer) {
        System.out.println("Developer " + developer.getName() + " review: Excellent");
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Manager " + manager.getName() + " review: Good");
    }
}

// 3. Element Interface
interface Employee {
    void accept(Visitor visitor);
}

// 4. Concrete Elements
class Developer implements Employee {
    private String name;
    private double salary;

    public Developer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Manager implements Employee {
    private String name;
    private double salary;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// 5. Object Structure

class Company {
    private java.util.List<Employee> employees = new java.util.ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void applyVisitor(Visitor visitor) {
        for (Employee employee : employees) {
            employee.accept(visitor);
        }
    }
}

// 6. Main Method
public class VisitorPatternDemo {
    public static void main(String[] args) {
        Company company = new Company();
        company.addEmployee(new Developer("Alice", 1000));
        company.addEmployee(new Manager("Bob", 2000));

        System.out.println("--- Bonus Calculation ---");
        company.applyVisitor(new BonusVisitor());

        System.out.println("\n--- Performance Review ---");
        company.applyVisitor(new PerformanceReviewVisitor());
    }
}
