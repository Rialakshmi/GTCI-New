/******************
Scheduling Tasks (hard) #

You are given a list of tasks that need to be run, in any order, on a server. Each task will take one CPU interval to execute but once a task has finished, it has a cooling period during which it can’t be run again. If the cooling period for all tasks is ‘K’ intervals, find the minimum number of CPU intervals that the server needs to finish all tasks.

If at any time the server can’t execute any task then it must stay idle.

Example 1:

Input: [a, a, a, b, c, c], K=2
Output: 7
Explanation: a -> c -> b -> a -> c -> idle -> a

Example 2:

Input: [a, b, a], K=3
Output: 5
Explanation: a -> b -> idle -> idle -> a

*******************/
import java.util.*;

class TaskScheduler {

  public static int scheduleTasks(char[] tasks, int k) {
    HashMap<Character,Integer> hm=new HashMap<>();
        for(char c:tasks) {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        pq.addAll(hm.entrySet());
        int executionTime=0;
        
        while(!pq.isEmpty()) {
            int tasksToBeExecuted=k+1;
            List<Map.Entry<Character,Integer>> pending=new ArrayList<>(); //pending high frequency tasks to be executed
            while(tasksToBeExecuted>0&&!pq.isEmpty()) {
                executionTime++;
                Map.Entry<Character,Integer> curr=pq.poll();
                curr.setValue(curr.getValue()-1);
                if(curr.getValue()>0)
                    pending.add(curr);
                tasksToBeExecuted--;
            }
            
            pq.addAll(pending);
            
            if(!pq.isEmpty()) 
                executionTime+=tasksToBeExecuted; //idle Time = remaining tasks spot to fill in where there is no "k" interval gap
        }
        
        return executionTime;
  }

  public static void main(String[] args) {
    char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
    System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

    tasks = new char[] { 'a', 'b', 'a' };
    System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
  }
}
