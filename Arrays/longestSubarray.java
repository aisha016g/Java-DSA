import java.util.*;
public class longestSubarray {
  public int Brute(int[] arr, int key) {
    int n = arr.length;
    int maxLen = 0;

    for(int i = 0; i < n; i++) {
        int sum = 0;

        for(int j = i; j < n; j++) {
            sum += arr[j];

            if(sum == key) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
    }

    return maxLen;
}
public int Better(int[] arr,int key){
    HashMap<Integer,Integer>map=new HashMap<>();
           int sum = 0;
        int maxLen = 0;

        for(int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // Case 1: subarray from 0 to i
            if(sum == key) {
                maxLen = i + 1;
            }

            // Case 2: subarray somewhere in middle
            if(map.containsKey(sum - key)) {
                int len = i - map.get(sum - key);
                maxLen = Math.max(maxLen, len);
            }

            // Store only first occurrence
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    
}

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int key=sc.nextInt();

        longestSubarray sol=new longestSubarray();
        int result=sol.Brute(arr,key);
        System.out.println(result);
        sc.close();
    }
    
}
