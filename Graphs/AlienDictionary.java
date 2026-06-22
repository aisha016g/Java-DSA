import java.util.*;

class Alien{
    public String findOrder(String[] dict,int N,int K){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());

            for(int ptr=0;ptr<len;ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(K,adj);
        String ans = "";
        for(int it:topo){
            ans = ans + (char)(it+(int)('a'));
        }
        return ans;
    }
}

public class AlienDictionary {
    
}
