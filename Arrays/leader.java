import java.util.*;
public class leader {
    public void Brute(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            boolean lead=true;
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]<arr[j]){
                    lead=false;
                    break;
                }
            }
            if(lead==true)
                System.out.println(arr[i]);
        }
    }
    public void optimal(int[] arr){
        int n=arr.length;
        ArrayList<Integer>ans=new ArrayList<>();
        int mini=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>mini){
                mini=arr[i];
                ans.add(arr[i]);
            }
        }
        Collections.reverse(ans);
        for(int i:ans){
            System.out.print(i+" ");

        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        leader sol=new leader();
        // sol.Brute(arr);
        sol.optimal(arr);
        sc.close();
    }
}
