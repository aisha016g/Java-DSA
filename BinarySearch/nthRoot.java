import java.util.*;
public class nthRoot{
    // nis number and m is the power
    public int brute(int n,int m){
        for(int i=1;i<=n;i++){
            if(Math.pow(i,m)==n) return i;
            else if(Math.pow(i,m)>n)
                break;
        }
        return -1;
    }
    // return 1 if == n 
    // return 0 if < n
    // return 2 if > n 
    public int func(int mid,int n,int m){
        long ans=1;
        for(int i=1;i<=m;i++){
            ans*=mid;
            if(ans>n)return 2;
        }
        if(ans==n) return 1;
        return 0;

    }
    public int optimal(int n,int m){
        int low=1,high=n;
        while(low<=high){
            int mid=(low+high)/2;
            int k=func(mid,n,m);
            if(k==1) return mid;
            else if(k==0)
                low=mid+1;
                else
            high=mid-1;
        }
        return -1;

    }
public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        nthRoot sol=new nthRoot();
        // int res=sol.brute(n,m);
        int res=sol.optimal(n,m);
        System.out.println(res);
        sc.close();
        
    }  
 }