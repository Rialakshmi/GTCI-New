import java.util.*;

class TopologicalSort {
  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
    HashMap<Integer,Integer> indegree=new HashMap<>();
    HashMap<Integer,List<Integer>> graph=new HashMap<>();
    List<Integer> result=new ArrayList<>();
    Queue<Integer> queue=new LinkedList<>();
    for(int[] edge:edges) {
      int parent=edge[0];
      int child=edge[1];
      indegree.putIfAbsent(parent,0);
      indegree.putIfAbsent(child,0);
      indegree.put(child,indegree.get(child)+1);
      graph.putIfAbsent(parent,new ArrayList<Integer>());
      graph.putIfAbsent(child,new ArrayList<Integer>());
      List<Integer> list=graph.get(parent);
      list.add(child);
      graph.put(parent,list);
    }
    for(Map.Entry<Integer,Integer> e:indegree.entrySet()) {
      if(e.getValue()==0)
      queue.offer(e.getKey());
    }

    while(!queue.isEmpty()) {
      Integer curr=queue.poll();
      result.add(curr);
      List<Integer> children=graph.get(curr);
      
      for(Integer child:children) {
        indegree.put(child,indegree.get(child)-1);
        if(indegree.get(child)==0) {
          queue.offer(child);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> result = TopologicalSort.sort(4,
        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
        new int[] { 2, 1 }, new int[] { 3, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
    System.out.println(result);
  }
}
