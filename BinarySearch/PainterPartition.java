import java.util.*;

public class PainterPartition {
    public int brute(int[] arr,int k){
        int n=arr.length;
        if(n<k) return -1;
        int low=maxEle(arr),high=sum(arr);
        for(int i=low;i<=high;i++)
            {
                if(compute(arr,i)<=k)
                    return i;
            }
            return -1;
        }
        public int compute(int []arr,int i){
            int cnt=1,each=0;
            for(int j:arr){
                if(each+j<=i)
                    {
                        each+=j;
                    }
                    else{
                        cnt++;
                        each=j;
                    }
                }
                return cnt;
            }
        public int optimal(int[] arr,int k){
            int n=arr.length;
            if(n<k) return -1;
            int low=maxEle(arr),high=sum(arr);
            while(low<=high){
                int mid=(low+high)/2;
                if(compute(arr,mid)>k)
                    low=mid+1;
                else
                    high=mid-1;
            } 
        return low;
    }
    int maxEle(int [] arr){
        int maxi=Integer.MIN_VALUE;
        for(int i:arr){
            if(i>maxi)
                maxi=i;
        }
        return maxi;
    }
    int sum(int [] arr){
        int s=0;
        for(int i:arr){
            s+=i;
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
         System.out.println("Enter the number of painters ");
        int k=sc.nextInt();
        PainterPartition sol=new PainterPartition();
        int res=sol.brute(arr,k);
        // int res=sol.optimal(arr,k);
        System.out.println(res);
        sc.close();
    }
    
}
