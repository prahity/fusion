import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> values;
    boolean type;
    //true signifies min heap

    public Heap(boolean t) {
        values = new ArrayList<>();
        type = t;
    }

    public void insert(int val) {
        values.add(val);
        int pos = values.size() - 1;
        while(val < values.get((pos - 1) / 2) == type) {
            if(pos == 0){
                break;
            }
            values.set(pos, values.get((pos - 1) / 2));
            pos = (pos - 1) / 2;
        }
        values.set(pos,val);
    }
    public void extractTop() {
        int pos = 0;
        int current = values.get(values.size() - 1);
        values.set(0,current);
        values.remove(values.size() - 1);
        while(2 * pos + 2 < values.size() &&
                (values.get(2 * pos + 1) < current == type ||
                values.get(2 * pos + 2) < current == type)) {
            if(values.get(2 * pos + 1) < values.get(2 * pos + 2) == type) {
                values.set(pos,values.get(2 * pos + 1));
                pos = 2 * pos + 1;
            } else {
                values.set(pos,values.get(2 * pos + 2));
                pos = 2 * pos + 2;
            }
        }
        if(2 * pos + 1 < values.size()) {
            if(values.get(2 * pos + 1) < current == type) {
                values.set(pos,values.get(2 * pos + 1));
                pos = 2 * pos + 1;
            }
        }
        values.set(pos,current);
    }
    public int size() {
        return values.size();
    }
    public int peek() {
        return values.get(0);
    }
}
