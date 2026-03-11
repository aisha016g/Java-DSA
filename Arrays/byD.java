import java.util.Scanner;
public class byD {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n=sc.nextInt();
        System.out.println("Enter the elements:");
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("give the n place ");
        int d=sc.nextInt();
        //brute force
        if(d>n)//if value of shifting is greater than elements
        {
            d%=n;
        }
        int[] temp=new int[n];
        //storing in temporaray array
        for(int i=0;i<d;i++)
            temp[i]=a[i];
        //shifting elements after one to starting indexes
        for(int i=d;i<n;i++)
        {
            a[i-d]=a[i];
        }
        int j=0; 
        //adding temp array to back of original array
        for(int i=n-d;i<n;i++)
        {
            a[i]=temp[j];
            //or
            // a[i]=temp[i-(n-d)];
            j++;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        sc.close();
    }
    
}
