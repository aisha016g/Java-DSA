import java.util.*;

public class bookAllocation {
    public int brute(int[]arr ,int st){
        int n=arr.length;
        if(st>n) return -1;
        int low=maxEle(arr),high=maxSum(arr);
        for(int pages=low;pages<=high;pages++){
            int cntStu=computeStudents(arr,pages);
            if(cntStu<=st){
                return pages;
            }
        }
        return -1;
    }
    public int computeStudents(int[]arr,int pages){
        int st=1,pagesStudent=0;
        for(int i:arr){
            if(pagesStudent+i<=pages){
                pagesStudent+=i;
            }
            else{
                st++;
                pagesStudent=i;
            }
        }
        return st;
    }
    public int optimal(int [] arr,int st){
        int n=arr.length;
        if(st>n) return -1;
        int low=maxEle(arr),high=maxSum(arr);
        while(low<=high){
            int mid=(low+high)/2;
            if(computeStudents(arr, mid)>st)
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
    int maxSum(int[] arr){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        return sum;
    }
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
         System.out.println("Enter the number of students ");
        int students=sc.nextInt();
        bookAllocation sol=new bookAllocation();
        int res=sol.brute(arr,students);
        // int res=sol.optimal(arr,students);
        System.out.println(res);
        sc.close();
    }
    
}
