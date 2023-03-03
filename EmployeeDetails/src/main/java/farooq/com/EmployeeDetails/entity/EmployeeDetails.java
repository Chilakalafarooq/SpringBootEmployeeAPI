package farooq.com.EmployeeDetails.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private double salary;

    // default constructor
    public EmployeeDetails() {}

    // constructor with parameters
    public EmployeeDetails(String name, String email, String department, double salary) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

