import java.util.*;
public class countSubarraySum{
    public void Brute(int[] arr,int key){
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                if(sum==key){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    public void Better(int[] arr,int key){
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==key)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
    public void optimal(int[] arr, int key){
    int n = arr.length;
    HashMap<Integer, Integer> mp = new HashMap<>();
    int prefixSum = 0;
    int cnt = 0;
    mp.put(0, 1); // IMPORTANT

    for(int i = 0; i < n; i++){
        prefixSum += arr[i];
        int remove = prefixSum - key;

        if(mp.containsKey(remove)){
            cnt += mp.get(remove);
        }

        mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
    }

    System.out.println(cnt);
}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int key=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        countSubarraySum sol=new countSubarraySum();
        // sol.Brute(arr,key);
        sol.Better(arr,key);
        sol.optimal(arr,key);
        sc.close();
    }
}