
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            int len = 200;
            Map<Integer, Set<Integer>> vertices = new HashMap<>();
            int min = 500;
            for(int i = 0; i < 100; i++) {
                Scanner input = new Scanner(new File("/Users/prahityaugand/IdeaProjects/minCutsInGraph/src/graph.txt"));
                Graph graph = new Graph(input, len);
                while (graph.vertices.size() > 2) {
                    Pair edge = graph.chooseRandEdge(i);
                    graph.mergeVertices(edge.edge1, edge.edge2);
                    //graph.printMap();
                }
                //System.out.println(graph.edges.size());
                if(graph.edges.size() < min) {
                    min = graph.edges.size();
                }
            }
            System.out.println(min / 2);
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }
     }
}
