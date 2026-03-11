import java.util.*;
public class union {
    //union of 2 sorted arrays
    public int[] BruteForce(int[] a1,int[] a2)
    {
        Set<Integer> st=new HashSet<>();
        for(int n:a1){
            st.add(n);
        }
        
        for(int n:a2){
            st.add(n);
        }

        System.out.println(st);
        // Convert HashSet to int array and return
        int[] result = new int[st.size()];
        int i = 0;
        for (int num : st) {
            result[i++] = num;
        }
        return result;
    }
    public int[] optimized(int[]a1,int[]a2){
        int i=0,j=0;
        int k=a1.length+a2.length;
        int[] union=new int[k];
        int t=0;
        while(i<a1.length && j<a2.length)
        {
            if(a1[i]<=a2[j])
            {
                if(union[t-1]!=a1[i] || union.length==0)
                {
                    union[t]=a1[i];
                }
                i++;
            }
            else{
                if(union[t-1]!=a2[j] || union.length==0)
                {
                    union[t]=a2[j];
                }
                j++;
            }
            t++;
        }
        
        return union;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array 1 and 2");
        int n1=sc.nextInt();
        int n2=sc.nextInt();

        int[] a1=new int[n1];
        int[] a2=new int[n2];
        for(int i=0;i<n1;i++)
        {
            a1[i]=sc.nextInt();
        }
        System.out.println("Enter elements of second array");
        for(int i=0;i<n2;i++)
        {
            a2[i]=sc.nextInt();
        }
        //create object to call function 
        union sol=new union();
        // int[] result=sol.BruteForce(a1,a2);
        int[] result=sol.optimized(a1,a2);
        for(int i:result){
            System.out.println(i+" ");
        }
        sc.close();
    }
    
}
