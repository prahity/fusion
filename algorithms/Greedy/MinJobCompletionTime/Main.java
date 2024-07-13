import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("/Users/prahit/Documents/code/minimizeJobCompletionTime/src/data.txt");
            Scanner input = new Scanner(file);
            OrganizeJobs organizeJobs = new OrganizeJobs(input);
            organizeJobs.sortJobs();
            organizeJobs.printCompletionTime();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
