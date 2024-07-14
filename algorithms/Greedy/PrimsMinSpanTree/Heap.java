import java.util.ArrayList;

public class Heap {
    ArrayList<Pair> heap;

    public Heap(int size) {
        heap = new ArrayList<>();
        for(int i = 2; i <= size; i++) {
            heap.add(new Pair(i,Integer.MAX_VALUE));
        }
    }

    private void bubbleUp(int index) {
        int currCost = heap.get(index).cost;
        int currNode = heap.get(index).node;
        while(heap.get((index - 1) / 2).cost > currCost && index > 0) {
            heap.set(index,heap.get((index - 1) / 2));
            index = (index - 1) / 2;
        }
        heap.set(index,new Pair(currNode,currCost));
    }
    private void bubbleDown(int index) {
        int currCost = heap.get(index).cost;
        int currNode = heap.get(index).node;
        while(index * 2 + 2 < heap.size()) {
            if(heap.get(index * 2 + 1).cost < currCost || heap.get(index * 2 + 2).cost < currCost) {
                if(heap.get(index * 2 + 1).cost < heap.get(index * 2+ 2).cost) {
                    heap.set(index,heap.get(index * 2 + 1));
                    index = index * 2 + 1;
                } else {
                    heap.set(index,heap.get(index * 2 + 2));
                    index = index * 2 + 2;
                }
            } else {
                break;
            }
        }
        if(index * 2 + 1 < heap.size() && heap.get(index * 2 + 1).cost < currCost) {
            heap.set(index,heap.get(index * 2 + 1));
            index = index * 2 + 1;
        }
        heap.set(index,new Pair(currNode,currCost));
    }

    public void update(Pair newAddition) {
        for(int i = 0; i < heap.size(); i++) {
            if(heap.get(i).node == newAddition.node) {
                if(heap.get(i).cost > newAddition.cost) {
                    heap.set(i,newAddition);
                    bubbleUp(i);
                }
                return;
            }
        }
    }

    public Pair extractMin() {
        if(heap.size() == 1) {
            Pair min = heap.get(0);
            heap.remove(0);
            return min;
        }
        Pair min = heap.get(0);
        heap.set(0,heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        bubbleDown(0);
        return min;
    }

    public int size() {
        return heap.size();
    }
}
