import java.util.*;

public class appear {

    // 1️⃣ Brute Force - O(n^2)
    public int appearOnce(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            int count = 0;

            for(int j = 0; j < arr.length; j++){
                if(arr[j] == num){
                    count++;
                }
            }

            if(count == 1) return num;
        }
        return -1;
    }

    // 2️⃣ Better - Using HashMap (O(n) time, O(n) space)
    public int better(int[] arr){
        HashMap<Integer, Integer> mp = new HashMap<>();

        // store frequency
        for(int i = 0; i < arr.length; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // find element with frequency 1
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }

    // 3️⃣ Optimized - Using XOR (O(n) time, O(1) space)
    public int optimized(int[] arr){
        int xor = 0;

        for(int i = 0; i < arr.length; i++){
            xor = xor ^ arr[i];
        }

        return xor;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        appear sol = new appear();

        System.out.println("Brute Force: " + sol.appearOnce(arr));
        System.out.println("Better (HashMap): " + sol.better(arr));
        System.out.println("Optimized (XOR): " + sol.optimized(arr));

        sc.close();
    }
}
