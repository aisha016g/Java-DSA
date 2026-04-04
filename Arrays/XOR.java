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

    public void Optimal(int[] arr) {
        int k=0;
        int xr = 0;   // prefix XOR
        int cnt = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        
        // IMPORTANT: handles subarrays starting from index 0
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            xr ^= arr[i];   // update prefix XOR

            int x = xr ^ k; // value we need to find

            if (map.containsKey(x)) {
                cnt += map.get(x);
            }

            // store/update current prefix XOR
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        System.out.println(cnt);
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
