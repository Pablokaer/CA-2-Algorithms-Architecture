import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrganisationModel {
    private final List<Employee> employees = new ArrayList<>();

    public void loadEmployees(String filename) throws IOException {
        employees.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // Skip the header row.

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] values = line.split(",", -1);
                if (values.length < 9) {
                    continue;
                }

                String firstName = values[0].trim();
                String lastName = values[1].trim();
                String department = values[5].trim();
                String position = values[6].trim();
                String jobTitle = values[7].trim();
                String managerType = jobTitle.isBlank() ? position : jobTitle;

                employees.add(new Employee(firstName, lastName, managerType, department));
            }
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void sortEmployeesRecursive() {
        List<Employee> sortedEmployees = mergeSort(employees);
        employees.clear();
        employees.addAll(sortedEmployees);
    }

    private List<Employee> mergeSort(List<Employee> list) {
        if (list.size() <= 1) {
            return new ArrayList<>(list);
        }

        int middle = list.size() / 2;
        List<Employee> left = mergeSort(new ArrayList<>(list.subList(0, middle)));
        List<Employee> right = mergeSort(new ArrayList<>(list.subList(middle, list.size())));
        return merge(left, right);
    }

    private List<Employee> merge(List<Employee> left, List<Employee> right) {
        List<Employee> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            Employee leftEmployee = left.get(leftIndex);
            Employee rightEmployee = right.get(rightIndex);

            if (leftEmployee.getFullName().compareToIgnoreCase(rightEmployee.getFullName()) <= 0) {
                result.add(leftEmployee);
                leftIndex++;
            } else {
                result.add(rightEmployee);
                rightIndex++;
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));
        return result;
    }

    public List<Employee> getFirstEmployees(int amount) {
        int end = Math.min(amount, employees.size());
        return new ArrayList<>(employees.subList(0, end));
    }

    public Employee searchEmployeeRecursive(String fullName) {
        sortEmployeesRecursive();
        return binarySearch(fullName, 0, employees.size() - 1);
    }

    private Employee binarySearch(String fullName, int low, int high) {
        if (low > high) {
            return null;
        }

        int middle = (low + high) / 2;
        Employee employee = employees.get(middle);
        int comparison = fullName.compareToIgnoreCase(employee.getFullName());

        if (comparison == 0) {
            return employee;
        }
        if (comparison < 0) {
            return binarySearch(fullName, low, middle - 1);
        }
        return binarySearch(fullName, middle + 1, high);
    }
}
