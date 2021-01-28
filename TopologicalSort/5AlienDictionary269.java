class Solution {
    public String alienOrder(String[] words) {
        StringBuffer sb=new StringBuffer();
        HashMap<Character,Integer> indegree=new HashMap<>();
        HashMap<Character,List<Character>> graph=new HashMap<>();
        Queue<Character> queue=new LinkedList<>();
        for(String word:words) {
            for(char c:word.toCharArray()) {
                indegree.put(c,0);
                graph.put(c,new ArrayList<>());
            }
        }
        for(int i=0;i<words.length-1;i++) {
            String word1=words[i];
            String word2=words[i+1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
            return "";
        }
            for(int j=0;j<Math.min(word1.length(),word2.length());j++) {
                char parent=word1.charAt(j);
                char child=word2.charAt(j);
                if(parent!=child) {
                    graph.get(parent).add(child);
                    indegree.put(child,indegree.getOrDefault(child,0)+1);
                    break;
                }
                
            }
        }
        for(Map.Entry<Character,Integer> e:indegree.entrySet()) {
            if(e.getValue()==0) {
                queue.offer(e.getKey());
            }
        }
        while(!queue.isEmpty()) {
            Character curr=queue.poll();
            sb.append(curr);
            List<Character> children=graph.get(curr);
            for(Character child:children) {
                indegree.put(child,indegree.get(child)-1);
                if(indegree.get(child)==0)
                    queue.offer(child);
            }
        }
        
        if (sb.length() < indegree.size()) {
        return "";
    }
        
        return sb.toString();
    }
}
