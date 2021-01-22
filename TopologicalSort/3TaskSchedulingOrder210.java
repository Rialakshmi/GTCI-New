import java.util.*;

class TaskSchedulingOrder {
  public static List<Integer> findOrder(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
    HashMap<Integer,List<Integer>> graph=new HashMap<>();
    HashMap<Integer,Integer> indegree=new HashMap<>();
    for(int i=0;i<vertices;i++) {
      indegree.put(i,0);
      graph.put(i,new ArrayList<Integer>());
    }
      
    for(int[] edge:edges) {
      int parent=edge[0];
      int child=edge[1];
      graph.get(parent).add(child);
      indegree.put(child,indegree.get(child)+1);
    }
    Queue<Integer> queue=new LinkedList<>();
    for(Map.Entry<Integer,Integer> e:indegree.entrySet()) {
      if(e.getValue()==0)
        queue.offer(e.getKey());
    }

    while(!queue.isEmpty()) {
      int currVertex=queue.poll();
      sortedOrder.add(currVertex);
      List<Integer> children=graph.get(currVertex);
      for(Integer child:children) {
        indegree.put(child,indegree.get(child)-1);
        if(indegree.get(child)==0)
          queue.offer(child);
      }
    }
    return sortedOrder;
  }

  public static void main(String[] args) {
    List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
    System.out.println(result);

    result = TaskSchedulingOrder.findOrder(3,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
    System.out.println(result);

    result = TaskSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
        new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
    System.out.println(result);
  }
}
