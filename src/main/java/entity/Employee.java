package entity;

public class Employee {
    private int eid;
    private String name;
    private float salary;
    private String password;
    private Department department;

    public Employee() {
    }

    public Employee(String name, float salary, String password, Department department) {
        this.name = name;
        this.salary = salary;
        this.password = password;
        this.department = department;
    }

    public Employee(String name, float salary, String password) {
        this.name = name;
        this.salary = salary;
        this.password = password;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
