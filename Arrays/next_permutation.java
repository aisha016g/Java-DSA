import java.util.*;
public class next_permutation{
    public void Brute(int[] arr){
        int n=arr.length;
        List<List<Integer>>list=new ArrayList<>();
        boolean[] used=new boolean[n];
        generate(arr,new ArrayList<>(),used,list);
        Collections.sort(list, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i) != b.get(i)) {
                        return Integer.compare(a.get(i), b.get(i));
                    }
                }
                return 0;
            }
        });
        //
        List <Integer> current=new ArrayList<>();
        for(int i:arr){
            current.add(i);
        }
        int idx=list.indexOf(current);
        List<Integer>next=list.get((idx+1)%list.size());
        System.out.println(next);
    }
    public void generate(int[] arr,List<Integer>temp,boolean[]used,List<List<Integer>>list){
        if(temp.size()==arr.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(used[i])continue;
            used[i]=true;
            temp.add(arr[i]);
            generate(arr,temp,used,list);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
    public static void main(String [ ] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        next_permutation sol=new next_permutation();
        sol.Brute(arr);
        sc.close();        
    }
}
