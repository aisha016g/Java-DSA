import java.util.*;

public class threeSum {
    public void Brute(int[]arr){
        int n=arr.length;
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer>temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        Collections.sort(temp);
                        set.add(temp);
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
    public void Better(int[] arr){
        int n=arr.length;
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<n;i++){
            HashSet<Integer> set1=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third=-(arr[i]+arr[j]);
                if(set1.contains(third)){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    set.add(temp);
                }
                set1.add(arr[j]);
            } 
        }
        for(List<Integer> trip:set){
            System.out.println(trip);
        }
    }
     public void Optimal(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // skip duplicates for i
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[left], arr[right]);
                    ans.add(temp);
                    left++;
                    right--;
                    // skip duplicates for left
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    // skip duplicates for right
                    while (left < right && arr[right] == arr[right + 1]) right--;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        // print answer
        for (List<Integer> triplet : ans) {
            System.out.println(triplet);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        threeSum sol=new threeSum();
        sol.Brute(arr);
        sol.Better(arr);
        sol.Optimal(arr);
        sc.close();
    }

    
}
