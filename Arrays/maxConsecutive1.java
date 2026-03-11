import java.util.*;
public class maxConsecutive1 {
    public int MaxCons(int[] arr){
        int n=arr.length;
        int count=0,max1=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1)
            {
                count++;
                if(max1<count)
                {
                    max1=count;
                }
            }
            else{
                count=0;
            }
        }
        return max1;

    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        maxConsecutive1 sol=new maxConsecutive1();
        int result=sol.MaxCons(arr);
    System.out.println("Max occur 1 is: "+result);

        sc.close();
    }
}
