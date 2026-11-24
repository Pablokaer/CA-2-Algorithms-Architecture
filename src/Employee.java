public class Employee {
    private String firstName;
    private String lastName;
    private String managerType;
    private String department;

    public Employee(String firstName, String lastName, String managerType, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerType = managerType;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getManagerType() {
        return managerType;
    }

    public String getDepartment() {
        return department;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getFullName() + " | " + managerType + " | " + department;
    }
}
