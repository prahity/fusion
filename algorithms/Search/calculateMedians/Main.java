import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/prahit/Documents/code/FindMedian/src/medianData.txt");
            Scanner input = new Scanner(file);
            MedianCalc medCalc = new MedianCalc();
            medCalc.printValues(input);
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
