import java.util.*;
public class BuySellStocks {
    public int Profit(int[] arr){
        int n=arr.length;
        int mini=arr[0];
        int profit=0;
        for(int i=1;i<n;i++){
            int cost=arr[i]-mini;
            profit=Math.max(cost,profit);
            mini=Math.min(mini,arr[i]);
        }
        return profit;

    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        BuySellStocks sol=new BuySellStocks();
        int result=sol.Profit(arr);
        System.out.println("Your Profit is "+result);
        sc.close();
    }
    
}
