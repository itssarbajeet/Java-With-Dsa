import java.util.*;

public class job_Sequencing_problem {
    static class Job{
        int deadLine;
        int profit;
        int id;

        public Job(int i, int d, int p){
            id = i;
            deadLine = d;
            profit = p; }}

    public static void main(String args[]){
        int jobsInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0; i<jobsInfo.length; i++){
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0; i<jobs.size(); i++){
            Job cur = jobs.get(i);
            if(cur.deadLine > time){
                seq.add(cur.id);
                time++;
            }
        }
        System.out.println("max jobs = " + seq.size());
        for(int i=0; i<seq.size(); i++){
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}
