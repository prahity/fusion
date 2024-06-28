import java.io.File;
import java.sql.Array;
import java.util.*;

public class Graph {

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    ArrayList<ArrayList<Integer>> graphrev = new ArrayList<>();
    int len = 875714;
    int[] finishingTimes = new int[len];
    boolean[] explored = new boolean[len];
    boolean[] added = new boolean[len];
    int ranking =  1;
    int count = 0;


    public Graph(Scanner input) {
        for(int i = 0; i < len; i++) {
            graph.add(new ArrayList<Integer>());
            graphrev.add(new ArrayList<>());
        }
        while(input.hasNextLine()) {
            int v1 = input.nextInt() - 1;
            int v2 = input.nextInt() - 1;
            graph.get(v1).add(v2);
            graphrev.get(v2).add(v1);
            input.nextLine();
        }

    }

    public void getFinishingTimes() {
        for(int i  = 1; i < len; i++) {
            if(!explored[i]) {
                DFS1(i);
            }
        }
    }
    public void DFS1(int v) {
        Stack<Integer> nodes = new Stack<>();
        nodes.push(v);
        while(!nodes.isEmpty()) {
            int current = nodes.peek();
            if(!explored[current]) {
                explored[current] = true;
                added[current] = true;
                if (graphrev.get(current) != null) {
                    for (int u : graphrev.get(current)) {
                        if (!added[u]) {
                            nodes.push(u);
                            added[u] = true;
                        }
                    }
                }
            } else {
                nodes.pop();
                finishingTimes[len - ranking] = current;
                ranking++;
            }
        }

    }

    public void findSCCSizes() {
        Arrays.fill(explored,false);
        Arrays.fill(added,false);
        for(int i : finishingTimes) {
            count = 0;
            if(!explored[i]) {
                DFS2(i);
            }
            if(count > 200) {
                System.out.println(count);
            }
        }
    }
    public void DFS2(int v) {
        Stack<Integer> nodes = new Stack<>();
        nodes.push(v);
        while (!nodes.isEmpty()) {
            int current = nodes.peek();
            if (!explored[current]) {
                explored[current] = true;
                added[current] = true;
                if (graph.get(current) != null) {
                    for (int u : graph.get(current)) {
                        if (!added[u]) {
                            nodes.push(u);
                            added[u] = true;
                        }
                    }
                }
            } else {
                count++;
                nodes.pop();
            }
        }
    }



}

