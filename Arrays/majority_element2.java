import java.util.*;
public class majority_element2 {
    public List<Integer> Brute(int[] arr){
        int n=arr.length;
        ArrayList<Integer>lst=new ArrayList<>();
        for(int i:arr){
            if(!lst.contains(i) || lst.size()==0){
                int cnt=0;
                for(int j:arr){
                    if(i==j)cnt++;
                }
                if(cnt>n/3)lst.add(i);
                if(lst.size()>=2)break;
            }
        }
        return lst;
    }
    public List<Integer> Better(int[] arr){
        int n=arr.length;
        int min=(n/3)+1;
        HashMap<Integer,Integer> mp=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:arr){
            // update frequency
            mp.put(i,mp.getOrDefault(i,0)+1);

            // check if it becomes majority
                if(mp.get(i)==min) list.add(i);
                if(list.size()>=2)break;
        }
        return list;
    } 
    public List<Integer> optimal(int[] arr){
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<>();
        int cnt1=0,cnt2=0,ele1=0,ele2=0;
        for(int i:arr){
            if(i==ele1)cnt1++;
            else if(i==ele2)cnt2++;
            else if(cnt1==0){
                cnt1++;
                ele1=i;
            }
            else if(cnt2==0){
                cnt2++;
                ele2=i;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        //verification
        cnt1=0;
        cnt2=0;
        for(int i:arr){
            if(i==ele1)cnt1++;
            else if(i==ele2)cnt2++;
        }
        if(cnt1>n/3)list.add(ele1);
        if(cnt2>n/3)list.add(ele2);
        return list;
    }
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        majority_element2 sol=new majority_element2();
        // System.err.println(sol.Brute(arr));
        System.err.println(sol.optimal(arr));
        // System.err.println(sol.Better(arr));
        sc.close();
    }
    
}
