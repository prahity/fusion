import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Graph {
    Map<Integer, ArrayList<Pair>> graph;
    int nodes;
    public Graph(Scanner input) {
        graph = new HashMap<>();
        nodes = input.nextInt();
        int edges = input.nextInt();

        for(int i = 0; i < edges; i++) {
            int e1 = input.nextInt();
            int e2 = input.nextInt();
            int cost = input.nextInt();
            graph.putIfAbsent(e1,new ArrayList<>());
            graph.putIfAbsent(e2,new ArrayList<>());
            graph.get(e1).add(new Pair(e2,cost));
            graph.get(e2).add(new Pair(e1,cost));
        }
    }

    public void getMinCost() {
        Heap heap = new Heap(nodes);
        long cost = 0;
        int start = 1;
        int count = 1;
        while(heap.size() > 0) {
            for(Pair i : graph.get(start)) {
                heap.update(i);
            }
            Pair min = heap.extractMin();
            cost += min.cost;
            start = min.node;
            System.out.println("finished node " + count);
            count += 1;
        }
        System.out.println(cost);
    }


}
