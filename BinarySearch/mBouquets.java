import java.util.Scanner;

public class mBouquets {
    public int brute(int[] arr,int m,int k){
        int n=arr.length;
        // when number of  flowers needed are more than length of arr
        if(m*k>n) return -1;
        int mini=minE(arr);
        int maxi=maxE(arr);
        for(int i=mini;i<=maxi;i++){
            if(possible(arr, i, m, k)==true)
                return i;
        }
        return -1;
    }
        public int maxE(int[]arr){
            int Max=Integer.MIN_VALUE;
            for(int i:arr){
                if(i>Max)
                    Max=i;
            }
            return Max;
        }
        public int minE(int[]arr){
            int Min=Integer.MAX_VALUE;
            for(int i:arr){
                if(i<Min)
                    Min=i;
            }
            return Min;
        }
        public boolean possible(int[] arr,int day,int m,int k){
            int cnt=0;
            int NoBouquet=0;
            int n=arr.length;
            for(int i=0;i<=n-1;i++){
                if(arr[i]<=day) cnt++;
                else 
                {    NoBouquet+= (cnt/k);
                    cnt=0;
                }
            }
            NoBouquet+= (cnt/k);
            if(NoBouquet>=m)
                return true;
            return false;
        }
        public int optimal(int [] arr,int m,int k){
            int low=minE(arr);
            int high=maxE(arr);
            int ans=high;
            if(m*k>arr.length)
                return -1;
            while(low<=high){
                int mid=(low+high)/2;
                if(possible(arr, mid,m, k)==true)
                {    ans=mid;
                    high=mid-1;
                }
                else
                    low=mid+1;
            }
            return ans;
        }
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Number of bouquets needed ");
        int m=sc.nextInt();
        System.out.println("Number of adjacent flowers needed ");
        int k=sc.nextInt();
        mBouquets sol=new mBouquets();
        //  return minimum day required to bloom thr k number of adjacent flowers 
        int res=sol.brute(arr,m,k);
        // int res=sol.optimal(arr,m,k);
        System.out.println(res);
        sc.close();
        
    }  
    
}
