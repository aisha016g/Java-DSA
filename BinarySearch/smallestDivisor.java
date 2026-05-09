import java.util.*;

public class smallestDivisor {
    public int brute(int []arr,int t){
        // int n=arr.length;
        int maxArr=maxE(arr);
        for(int d=1;d<=maxArr;d++){
            int s=calculate(arr, d);
            if(s<=t)
                return d;
        }
        return -1;
    }
    public int optimal(int [] arr,int t){
        int low=1;
        int high=maxE(arr);
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int sum=calculate(arr, mid);
            if(sum<=t){
                high=mid-1;
            ans=mid;}
                else
                low=mid+1;
        }
        return ans;
    }

    public int calculate(int [] arr,int d){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=(arr[i]+d-1)/d;
        }
        return sum;
    }
    public int maxE(int [] arr){
        int maxi=Integer.MIN_VALUE;
        for(int i:arr)
        {
            if(i>maxi)
                maxi=i;
        }
        return maxi;

    }
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Thereshold ");
        int m=sc.nextInt();
       
        smallestDivisor sol=new smallestDivisor();
        // int res=sol.brute(arr,m);
        int res=sol.optimal(arr,m);
        System.out.println(res);
        sc.close();
        
    }  
    
}
