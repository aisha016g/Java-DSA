import java.util.*;
public class maxSubArray {
    public int Brute(int[] arr)
    {
        int n=arr.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int sum=0;
                for(int k=i;k<=j;k++)
                {
                    sum+=arr[k];
                }
                maxi=Math.max(sum,maxi);
            }
        }
        return maxi;
    }
    public int Better(int[] arr)
    {
        int n=arr.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=i;j<n;j++)
            {
                sum+=arr[j];
                maxi=Math.max(sum,maxi);
            }
        }
        return maxi;
    }
    public int Kadane(int[] arr)
    {
        int n=arr.length;
        int sum=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            maxi=Math.max(maxi,sum);
           if (sum<0)
                sum=0;
        }
        return maxi;
    }
    public void PrintArr(int[] arr)
    {
        int n=arr.length;
        int sum=0,start=-1;
        int ansStart=-1,ansEnd=-1;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(sum==0)start=i;
            sum+=arr[i];
            if(sum>maxi){
                maxi=sum;
                ansStart=start;
                ansEnd=i;
            }
            if(sum<0)sum=0;
        }
        for(int i=ansStart;i<=ansEnd;i++){
            System.out.println(arr[i]+" ");
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        maxSubArray sol=new maxSubArray();
        // int res=sol.Better(arr);
        // int res=sol.Brute(arr);
        int res=sol.Kadane(arr);
        System.out.println(res);
        sc.close();

    }
    
}
