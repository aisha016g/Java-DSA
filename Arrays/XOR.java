import java.util.*;

public class XOR {
    public int Brute(int[]arr,int key){
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int xor=0;
                for(int k=i;k<=j;k++){
                    xor=xor^arr[k];
                }
                if(xor==key)cnt++;
            }
        }
        return cnt;
    }
    public int Better(int[]arr,int key){
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int xor=0;
            for(int j=i;j<n;j++){
                
                    xor=xor^arr[j];
                
                if(xor==key)cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        XOR sol=new XOR();
        // int res=sol.Brute(arr,k);
        int res=sol.Better(arr,k);
        System.out.println(res);
        // sol.Better(arr);
        // sol.Optimal(arr);
        sc.close();
    
}
}
