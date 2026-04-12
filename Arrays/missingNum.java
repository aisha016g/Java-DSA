import java.util.*;
public class missingNum {
    public int BruteForce(int[] arr,int find){
    int n = arr.length;

    for(int i = 1; i <= n+1; i++){
        boolean found = false;
        for(int j = 0; j < n; j++){
            if(arr[j] == i){
                found = true;
                break;
            }
        }
        if(!found)
            return i;
    }
    return -1;
}

    public int Better(int[] arr){
    int n = arr.length;
    HashMap<Integer,Integer> mp = new HashMap<>();

    for(int i = 0; i < n; i++){
        mp.put(arr[i], 1);
    }

    for(int i = 1; i <= n+1; i++){
        if(!mp.containsKey(i))
            return i;
    }

    return -1;
}

    public int optimized(int[] arr){
    int n = arr.length;
    int xor1 = 0, xor2 = 0;

    for(int i = 1; i <= n+1; i++){
        xor1 ^= i;
    }

    for(int i = 0; i < n; i++){
        xor2 ^= arr[i];
    }

    return xor1 ^ xor2;
}

    public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter size of array");
    int n=sc.nextInt();

    System.out.println("Enter the numbers of array");
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
    {
        arr[i]=sc.nextInt();
    }

    missingNum sol=new missingNum();
    int result=sol.optimized(arr);

    System.out.println("Missing num is: "+result);
    sc.close();
}
}
