import java.util.Scanner;

public class ShipPackage {
    public int brute(int[] arr,int days){
        int maxI=maxEle(arr);
        int sumArr=arrSum(arr);
        for(int cap=maxI;cap<=sumArr;cap++){
            int daysReq=findDays(arr,cap);
            if(daysReq<=days)
                return cap;
        }
        return -1;
    }
    public int optimal(int [] arr,int days){
        int low=maxEle(arr);
        int high=arrSum(arr);
        while(low<=high){
            int mid=(low+high)/2;
            int NumberOfDays =findDays(arr,mid);
            if(NumberOfDays<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;

    }
    public int findDays(int[] arr,int cap){
        int days=1,load=0;
        for(int i:arr){
            if(load+i>cap){
                days=days+1;
                load=i;
            }
            else{
                load+=i;
            }
        }
        return days;
    }
    public int maxEle(int[]arr){
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            if(i>max)
                max=i;
        }
        return max;
    }
    public int arrSum(int [] arr){
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
        System.out.println("Enter number of days ");
        int days=sc.nextInt();
        ShipPackage sol=new ShipPackage();
        // int res=sol.brute(arr,days);
        int res=sol.optimal(arr,days);
        System.out.println(res);
        sc.close();
    }
    
}
