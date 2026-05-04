import java.util.*;

public class median2sorted {
    public double brute(int[] arr1,int[] arr2){
        int n1=arr1.length,n2=arr2.length;
        int[] arr3=new int[n1+n2];
        int i=0,j=0,idx=0;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){
                arr3[idx++]=arr1[i++];
            }
            else{
                arr3[idx++]=arr2[j++];
            }
        }
        while(i<n1){
            arr3[idx++]=arr1[i++];
        }
        while(j<n2){
            arr3[idx++]=arr2[j++];
        }
        int n=n1+n2;
        if(n%2==1)
            return arr3[n/2];
        else{
            return (arr3[n/2]+arr3[n/2-1])/2.0;
        }
        
    }
    public double better(int[] arr1,int[] arr2){
        int n1=arr1.length,n2=arr2.length;
        int i=0,j=0,cnt=0;
        int n=n1+n2;
        int idx2=n/2;
        int idx1=idx2-1;
        int idx1el=-1,idx2el=-1;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]) {
                if(cnt==idx1) idx1el=arr1[i];
                if(cnt==idx2) idx2el=arr1[i];
                cnt++;
                i++;
            }
            else{
                if(cnt==idx1) idx1el=arr2[j];
                if(cnt==idx2) idx2el=arr2[j];
                cnt++;
                j++;
            }
        }
        while(i<n1){
            if(cnt==idx1) idx1el=arr1[i];
            if(cnt==idx2) idx2el=arr1[i];
            cnt++;
            i++;
        }
        while(j<n2){
            if(cnt==idx1) idx1el=arr2[j];
                if(cnt==idx2) idx2el=arr2[j];
                cnt++;
                j++;
        }
        if(n%2==1)
            return idx2el;
        else{
            return (double)((double)idx1el+idx2el)/2.0;
        }
    }
    public double optimal(int [] arr1,int[] arr2){
        // Always binary search on smaller array
        if (arr1.length > arr2.length)
            return optimal(arr2, arr1);
        int n1 = arr1.length;
        int n2 = arr2.length;
        int low = 0, high = n1;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : arr2[cut2];
            // Correct partition
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                return ((double)Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } 
                else
                    return Math.max(l1, l2);
            }
            // Move left
            else if (l1 > r2) {
                high = cut1 - 1;
            }
            // Move right
            else {
                low = cut1 + 1;
            }
        }
        return 0.0;
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
        median2sorted sol=new median2sorted();
        // double res=sol.brute(arr1,arr2);
        // double res=sol.better(arr1,arr2);
        double res=sol.optimal(arr1,arr2);
        System.out.println(res);
        sc.close();
    }
    
}
