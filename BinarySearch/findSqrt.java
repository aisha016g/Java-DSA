import java.util.*;
public class findSqrt {
    public int brute(int n){
        int ans=1;
        for(int i=1;i<=n;i++){
            if(i*i<=n)
                ans=i;
            else
                break;
        }
        return ans;
    }
    public int optimal(int n){
        int low=1,high=n;
        int ans=1;
        while(low<=high){
            int mid=(low+high)/2;
            int k=mid*mid;
             if(k<=n){
                ans=mid;
                low=mid+1;
             }
            
            else
                high=mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        findSqrt sol=new findSqrt();
        // int res=sol.brute(n);
        int res=sol.optimal(n);
        System.out.println(res);
        sc.close();
        
    }    
}
