import java.util.*;
public class ZeroEnd {
    public int[] bruteForce(int[] arr,int n){
        int[] temp=new int[n];
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]!=0)
            {
                temp[j]=arr[i];
                j++;
            }
        }
        for(int i=0;i<n;i++)
        {
            arr[i]=temp[i];
        }
return arr;
    }
    public int[] optimized(int[]arr,int n){// 2 pointer approach
        int j=-1;
        // Step 1: find first zero
        for (int i=0;i<n;i++)
        {
            if(arr[i]==0)
            {
                j=i;
                break;
            }
        }
        
    // Step 2: swap non-zero elements with zero position
        for(int i=j+1;i<n;i++)
        {
            if(arr[i]!=0)
            {
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                j++;
            }
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n=sc.nextInt();

        int[] arr=new int[n];

        System.out.println("Enter elements of array: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
//      object creation used to further call a function
        ZeroEnd sol=new ZeroEnd();
        // int[] result=sol.bruteForce(arr,n);
        int[] result= sol.optimized(arr,n);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        sc.close();

    }
}
