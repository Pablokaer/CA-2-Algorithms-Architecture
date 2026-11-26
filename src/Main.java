import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = args.length > 0 ? args[0] : "data/Applicants_Form.txt";
        OrganisationModel model = new OrganisationModel();
        OrganisationView view = new OrganisationView();

        try {
            model.loadEmployees(filename);
            OrganisationController controller = new OrganisationController(model, view);
            controller.start();
        } catch (IOException exception) {
            view.showMessage("Could not read the file: " + filename);
            view.showMessage(exception.getMessage());
        }
    }
}
