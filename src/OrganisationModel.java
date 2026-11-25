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
}
