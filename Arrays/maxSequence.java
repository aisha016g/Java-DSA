import java.util.*;
public class maxSequence {
    public boolean linear(int[] arr,int key){
        for(int i:arr){
            if(i==key)
                return true;
        }
        return false;
    }
    public void Brute(int[] arr){
        int n=arr.length;
        int len=1;
        for(int i=0;i<n;i++){
            int x=arr[i];
            int cnt=1;
            while(linear(arr,x+1)==true)
            {
                x+=1;
                cnt++;
            }
            if(len<cnt)len=cnt;
        }
        System.out.print(len);
    }
    public int Better(int[] arr){
       Arrays.sort(arr);
       int n=arr.length;
        int longest=1;
        int smaller=Integer.MIN_VALUE;
        int curCnt=0;
        for(int i=0;i<n;i++){
            if(arr[i]-1==smaller)
            {
                curCnt++;
                smaller=arr[i];
            }
            else if(arr[i]!=smaller){
                curCnt=1;
                smaller=arr[i];
            }
            longest=Math.max(longest,curCnt);
        }
return longest;
    }
    public int optimal(int[] arr){
        HashSet<Integer>st=new HashSet<>();
        int longest=1;
        int x;
        for(int i:arr){
            st.add(i);
        }   
        for(int i:st){
            if(!st.contains(i-1)){
                int cnt=1;
                x=i;
                while(st.contains(x+1))
                {
                    x+=1;
                    cnt++;
                }
                longest=Math.max(longest,cnt);
            }
        }
        return longest;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        maxSequence sol=new maxSequence();
        // sol.Brute(arr);
        // int result=sol.Better(arr);
        int result=sol.optimal(arr);
        System.out.println("Longest Consecutive Sequence is : "+result);
        sc.close();
    }
    
}
