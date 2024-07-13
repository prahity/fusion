public class Job implements Comparable<Job>{
    int processTime;
    int weight;

    public Job(int pT, int w) {
        processTime = pT;
        weight = w;
    }

/*// with weight - length
    public int compareTo(Job o) {
        int valOne = weight - processTime;
        int valTwo = o.weight - o.processTime;
        if(valOne > valTwo) {
            return -1;
        } else if(valOne < valTwo) {
            return 1;
        } else {
            if(weight > o.weight) {
                return 1;
            }
            return -1;
        }
    }
*/
// with weight / length
    public int compareTo(Job o) {
        double valOne = weight * 1.0 / processTime;
        double valTwo = o.weight * 1.0 / o.processTime;
        if(valOne > valTwo) {
            return -1;
        } else if(valOne < valTwo) {
            return 1;
        } else {
            return 0;
        }
    }

}
