
import java.util.*;

public class Graph {
    Set<Integer> vertices;
    ArrayList<Pair> edges;
    Map<Integer, ArrayList<Integer>> vertMap;

    public Graph(Scanner input,int len) {
        vertices = new HashSet<>();
        edges = new ArrayList<>();
        vertMap = new HashMap<>();
        for(int i = 0; i < len; i++) {
            String line = input.nextLine();
            String[] vals = line.split("\t");
            vertices.add(Integer.parseInt(vals[0]));
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 1; j < vals.length; j++) {
                temp.add(Integer.parseInt(vals[j]));
                Pair tempPair = new Pair(Integer.parseInt(vals[0]),Integer.parseInt(vals[j]));
                edges.add(tempPair);
            }
            vertMap.put(Integer.parseInt(vals[0]),temp);
        }
    }

    public Pair chooseRandEdge(int i) {
        Random random = new Random(i);
        int edge = random.nextInt(edges.size());
        return edges.get(edge);
    }

    public void mergeVertices(int v1, int v2) {
        vertices.remove(v2);
        ArrayList<Integer> edgesFromV2 = vertMap.get(v2);
        vertMap.remove(v2);
        for(int x : edgesFromV2) {
            if(x != v1) {
            vertMap.get(v1).add(x);
            vertMap.get(x).add(v1);
            }
            vertMap.get(x).remove((Integer) v2);
        }
        for(int i = 0; i < edges.size(); i++) {
            if(edges.get(i).edge1 == v2) {
                edges.get(i).edge1 = v1;
                if (edges.get(i).edge2 == v1) {
                    edges.remove(edges.get(i));
                    i--;
                }
            }else if(edges.get(i).edge2 == v2) {
                edges.get(i).edge2 = v1;
                if (edges.get(i).edge1 == v1) {
                    edges.remove(edges.get(i));
                    i--;
                }
            }
        }
    }
    public void printMap() {
        for(int i : vertices) {
            System.out.print(i  + " ");
        }
        System.out.println();
        for(Pair i : edges) {
            System.out.print("(" + i.edge1 + ", " + i.edge2 + ") ");
        }
        System.out.println();

    }
}

