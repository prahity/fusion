import java.util.Scanner;

public class MedianCalc {
    Heap minHeap;
    Heap maxHeap;
    int heapSum;

    public MedianCalc() {
        minHeap = new Heap(true);
        maxHeap = new Heap(false);
        heapSum = 0;
    }

    public void printValues(Scanner input) {
        while(input.hasNextInt()) {
            int val = input.nextInt();
            heapSum += getNextValHeap(val);
            heapSum = heapSum % 10000;
        }
        System.out.println(heapSum);
    }

    public int getNextValHeap(int val) {
        if(maxHeap.size() == 0) {
            maxHeap.insert(val);
        } else if(val < maxHeap.peek()) {
            maxHeap.insert(val);
        } else {
            minHeap.insert(val);
        }
        if(minHeap.size() > maxHeap.size() + 1) {
            maxHeap.insert(minHeap.peek());
            minHeap.extractTop();
        }
        if(minHeap.size() + 1 < maxHeap.size()) {
            minHeap.insert(maxHeap.peek());
            maxHeap.extractTop();
        }
        if(maxHeap.size() >= minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

}
