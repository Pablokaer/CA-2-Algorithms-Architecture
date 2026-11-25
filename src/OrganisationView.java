import java.util.List;
import java.util.Scanner;

public class OrganisationView {
    public enum MenuOption {
        SORT(1, "Sort employees"),
        SEARCH(2, "Search for an employee"),
        ADD_RECORD(3, "Add a new employee"),
        SHOW_TREE(4, "Create and display the employee tree"),
        EXIT(5, "Exit");

        private final int number;
        private final String description;

        MenuOption(int number, String description) {
            this.number = number;
            this.description = description;
        }

        public int getNumber() {
            return number;
        }

        public String getDescription() {
            return description;
        }

        public static MenuOption fromNumber(int number) {
            for (MenuOption option : values()) {
                if (option.number == number) {
                    return option;
                }
            }
            return null;
        }
    }

    private final Scanner scanner = new Scanner(System.in);

    public MenuOption readMenuOption() {
        System.out.println("\n=== BANK EMPLOYEE SYSTEM ===");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getNumber() + ". " + option.getDescription());
        }
        System.out.print("Choose an option: ");

        String value = scanner.nextLine().trim();
        try {
            return MenuOption.fromNumber(Integer.parseInt(value));
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    public String readText(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
