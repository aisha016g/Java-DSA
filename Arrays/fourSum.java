import java.util.*;

public class fourSum {
    public void Brute(int[]arr){
        int n=arr.length;
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        long sum=(long)arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum==0){ 
                        List<Integer>temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
    }
        //convert set to list and print
        List<List<Integer>>ans=new ArrayList<>(set);
        for(List<Integer> trip:ans){
            System.out.println(trip);
        }
    }
public void Better(int[] arr) {
        int n = arr.length;
        int target=0;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> hashSet = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) arr[i] + arr[j] + arr[k];
                    long fourth = target - sum;
                    if (hashSet.contains((int) fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add((int) fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    hashSet.add(arr[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        for (List<Integer> quad : ans) {
            System.out.println(quad);
        }
    }
public void Optimal(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // skip duplicates for i
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // skip duplicates for j
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(
                            arr[i], arr[j], arr[k], arr[l]
                        );
                        ans.add(temp);
                        k++;
                        l--;
                        // skip duplicates for k
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        // skip duplicates for l
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    }
                    else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        for (List<Integer> quad : ans) {
            System.out.println(quad);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        fourSum sol=new fourSum();
        sol.Brute(arr);
        // sol.Better(arr);
        // sol.Optimal(arr);
        sc.close();
    }
}
