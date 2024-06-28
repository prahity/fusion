
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("/Users/prahityaugand/IdeaProjects/StronglyConnectedComponents/src/graph.txt"));
            Graph graph = new Graph(input);
            graph.getFinishingTimes();
            graph.findSCCSizes();
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
