public class Employee {
    private int employeeId;
    private String name;
    private String department;

    public Employee(int employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}

class Manager extends Employee {
    private int Ts;

    public Manager(int employeeId, String name, String department, int Ts) {
        super(employeeId, name, department);s
        this.Ts = Ts;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + Ts);
    }

    public static void main(String[] args) {
        Manager manager = new Manager(101, "Sarbajeet", "Engineering", 10);
        manager.displayDetails();
    }
}
