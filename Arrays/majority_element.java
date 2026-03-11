import java.util.*;
public class majority_element {
    //a key given and element  appear more than N/2 times
    // 2 2 3 3 1 2 2 (Number of elements=7) majortiy elements=2 so 7/2=3 which is 4 (times 2 appeared)> n/2(7/2=3)
    public int Brute(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int cnt=0;
            for(int j=0;j<n;j++)
            {
                if(arr[i]==arr[j])
                {
                    cnt++;
                }
            }  
          if(cnt>n/2)return arr[i];
        }
return -1;
    }
    public int Better(int[] arr){
    int n=arr.length;
      HashMap<Integer,Integer> mp=new HashMap<>(); 
      for(int i:arr)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
            if(mp.get(i)>n/2)return i;
        } 
        return -1;
    }
    public int Moores(int[] arr){
        int cnt=0;
        int ele=0;
        for(int i=0;i<arr.length;i++)
        {
            if(cnt==0)
            {
                cnt++;
                ele=arr[i];
            }
            else if(arr[i]==ele)
                cnt++;
            else 
                cnt--;
        }
        int cnt1=0;
        for(int i:arr)
        {
            if(ele==i)cnt1++;
        }
        if(cnt1>(arr.length/2)) return ele;
        return -1;

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        majority_element sol=new majority_element();
        // int result=sol.Brute(arr);
        // int result=sol.Better(arr);
        int result=sol.Moores(arr);
        System.out.println(result);
        sc.close();
    }
}
