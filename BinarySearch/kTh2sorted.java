import java.util.*;

public class kTh2sorted {
    public int binary(int[] a1,int[]a2,int k){
        int n1=a1.length;
        int n2=a2.length;
        if(n1>n2) binary(a2,a1,k);
        int low=Math.max(k-n2,0),high=Math.min(k,n1);
        int left=k;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1 > 0) l1 = a1[mid1 - 1];
            if(mid2 > 0) l2 = a2[mid2 - 1];
            if(l1<=r2 && l2<=r1)
                return Math.max(l1,l2);
            else if(l1>r2) high=mid1-1;
            else
                low=mid1+1;
        }
        return 0;
    }
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr1=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.println("Enter arr2 size then elements");
        int m= sc.nextInt();
        int[] arr2=new int[m];
        for(int i=0;i<m;i++){
            arr2[i]=sc.nextInt();
        }
        System.out.println("Enter the kTh element");
        int k= sc.nextInt();
        kTh2sorted sol=new kTh2sorted();
        double res=sol.binary(arr1,arr2,k);
        System.out.println(res);
        sc.close();
    }
    
}
