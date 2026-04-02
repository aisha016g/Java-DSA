import java.util.*;
public class merge2Sorted {
    public void brute(int[] arr1,int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        int a=0,b=0,i=0;
        int[] arr3=new int[m+n];
        while(a<n && b<m){
            if(arr1[a]<=arr2[b]){
                arr3[i++]=arr1[a++];
            }
            else{
                arr3[i++]=arr2[b++];
            }
        }
        while(a<n){
            arr3[i++]=arr1[a++];
        }
        while(b<m){
            arr3[i++]=arr2[b++];
        }
        for(int j=0;j<n+m;j++){
            if(j<n)arr1[j]=arr3[j];
            else
                arr2[j-n]=arr3[j];
        }
        System.out.println("Arr1: ");
        for(int j:arr1){
            System.out.print(j+" ");
        }
        System.out.println("Arr2: ");
        for(int j:arr2){
            System.out.print(j+" ");
        }
    }
     public void optimal1(int[] arr1,int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        int left=n-1;
        int right=0;
        while(left>=0 && right<m){
            if(arr1[left]>arr2[right]){
                swap(arr1,left,arr2,right);
                left--;
                right++;
            }
            else break;

        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("Arr1: ");
        for(int j:arr1){
            System.out.print(j+" ");
        }
        System.out.println("Arr2: ");
        for(int j:arr2){
            System.out.print(j+" ");
        }


    }
    // Gap method from shell sort
    public void optimal2(int[] arr1,int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        // did +1 to get ceil value
        int gap=(m+n+1)/2;
        while(gap>0){
            int left =0;
         int right=left+gap;
         while(right<(n+m)){
            // arr1 and arr2 left in arr1 and right in arr2
            if(left<n && right>=n){
                if (arr1[left] > arr2[right - n]) {
                        swap(arr1, left, arr2, right - n);
                    }
            }
            // arr2 and arr2 means left pointer reached to arr2
            else if(left>=n){
                if (arr2[left - n] > arr2[right - n]) {
                        swap(arr2, left - n, arr2, right - n);
                    }
                
            }
            // arr1 and arr1 right pointer at arr1
            else{
                if(arr1[left]>arr1[right]){
                    swap(arr1,left,arr2,right);
                }

            }
            if(gap==1)break;
         }
        }
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        System.out.println("Arr1: ");
        for(int j:arr1){
            System.out.print(j+" ");
        }
        System.out.println("Arr2: ");
        for(int j:arr2){
            System.out.print(j+" ");
        }


    }
    public void swap(int[] a, int i, int[] b, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[] arr1=new int[n];
        int[] arr2=new int[m];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++){
            arr2[i]=sc.nextInt();
        }
        merge2Sorted sol=new merge2Sorted();
        // sol.optimal1(arr1,arr2);
        // sol.brute(arr1,arr2);
        sol.optimal2(arr1,arr2);
        sc.close();
    }
    
}
