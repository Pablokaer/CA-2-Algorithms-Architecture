public class OrganisationController {
    private final OrganisationModel model;
    private final OrganisationView view;

    public OrganisationController(OrganisationModel model, OrganisationView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean running = true;
        view.showMessage("File read successfully. " + model.getEmployees().size() + " records loaded.");

        while (running) {
            OrganisationView.MenuOption option = view.readMenuOption();

            if (option == null) {
                view.showMessage("Invalid menu option.");
                continue;
            }

            switch (option) {
                case SORT:
                    model.sortEmployeesRecursive();
                    view.showMessage("Employees sorted alphabetically. First 20 records:");
                    view.showEmployees(model.getFirstEmployees(20));
                    break;
                case SEARCH:
                    searchEmployee();
                    break;
                case ADD_RECORD:
                    view.showMessage("Add record selected.");
                    break;
                case SHOW_TREE:
                    view.showMessage("Employee tree selected.");
                    break;
                case EXIT:
                    running = false;
                    view.showMessage("Program closed.");
                    break;
            }
        }
    }

    private void searchEmployee() {
        String fullName = view.readText("Enter the employee's full name: ");
        Employee employee = model.searchEmployeeRecursive(fullName);

        if (employee == null) {
            view.showMessage("Employee not found.");
        } else {
            view.showMessage("Employee found:");
            view.showMessage(employee.toString());
        }
    }
}
