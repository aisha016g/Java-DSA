import java.util.*;

public class zero_ones_twos {
    public int[] Brute(int[] arr){
        int n=arr.length;
        int cnt0=0,cnt1=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0)
                cnt0++;
            else if(arr[i]==1)
                cnt1++;
            else
                continue;
        }
        for(int i=0;i<cnt0;i++){
            arr[i]=0;
        }
        for(int i=cnt0;i<cnt1+cnt0;i++){
            arr[i]=1;
        }
        for(int i=cnt1+cnt0;i<n;i++){
            arr[i]=2;
        }
        return arr;
    }
    //Dutch National Flag Algorithm
    public int[] Optimized(int[] arr)
    {
        int n=arr.length;
        int mid=0,low=0,high=n-1;
        while(mid<=high)
        {
            if(arr[mid]==0)
            {
                int t=arr[mid];
                arr[mid]=arr[low];
                arr[low]=t;
                mid++;
                low++;
            }
            else if(arr[mid]==1)
            {
                mid++;
            }
            else {
                int t=arr[mid];
                arr[mid]=arr[high];
                arr[high]=t;
                high--;
            }
        }
        return arr;
    }
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        } 
        zero_ones_twos sol=new zero_ones_twos();
        //sol.Brute(arr);
        sol.Optimized(arr);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    sc.close();
}
}
