import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File dataFolder = new File("data");
        File[] files = dataFolder.listFiles(File::isFile);

        if (files == null || files.length == 0) {
            System.out.println("No file found in folder: " + dataFolder.getAbsolutePath());
            return;
        }

        File file = files[0];
        System.out.println("Reading file: " + file.getName());
        System.out.println();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException exception) {
            System.out.println("Could not read the file.");
            System.out.println(exception.getMessage());
        }
    }
}
