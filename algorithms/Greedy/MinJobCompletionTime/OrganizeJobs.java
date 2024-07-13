import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OrganizeJobs {
    Job[] jobs;

    public OrganizeJobs(Scanner input) {
        int jobNum = input.nextInt();
        jobs = new Job[jobNum];
        for(int i  = 0; i < jobNum; i++) {
            int pT = input.nextInt();
            int w = input.nextInt();
            jobs[i] = new Job(pT,w);
        }
    }

    public void sortJobs() {
        Arrays.sort(jobs);
    }

    public void printCompletionTime() {
        int time = 0;
        long compTime = 0;
        for(Job i : jobs) {
            time += i.processTime;
            compTime += (long) time * i.weight;
        }
        System.out.println(compTime);
    }


}

