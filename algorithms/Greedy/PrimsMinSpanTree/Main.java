import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("/Users/prahit/Documents/code/PrimsMinSpanTree/src/data.txt");
            Scanner input = new Scanner(file);
            Graph graph = new Graph(input);
            System.out.println("input done");
            graph.getMinCost();
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
