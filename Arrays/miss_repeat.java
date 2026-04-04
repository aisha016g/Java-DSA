import java.util.*;
public class miss_repeat {
    public void approach1(int[] arr,int n){
        int repeat=-1,missing=-1;
        for(int i=1;i<=n;i++){
            int cnt=0;
           for(int j:arr){
            if(i==j)
                cnt++;
        }
        if(cnt==2) 
          repeat=i;
        else if(cnt==0) 
          missing =i;
        if( repeat!=-1 && missing!=-1)break;
        }
        System.out.print("repeating "+repeat+" missing "+missing);
    }
    
    public void approach2(int[] arr,int n){
        int[] hash=new int[n+1];
        for(int i= 0;i<n;i++){
            hash[arr[i]]++;
        }
        int miss=-1,repeat=-1;
        for(int i=1;i<=n;i++){
            if(hash[i]==2)repeat=i;
            else if(hash[i]==0)miss=i;
            if(miss!=-1 && repeat!=-1)break;
        }
        System.out.print("repeating "+repeat+" missing "+miss);
    }

    public void optimal1(int[] arr ,int n){
        // using maths equations
        long S=(long)n*(n+1)/2;
        long S2=(long) n*(n+1)*(2*n+1)/6;
        long actualSum=0;
        long actualSquareSum=0;

        // Step 1: calculate actual sums
        for(int i=0;i<n;i++){
             actualSum+=arr[i];
             actualSquareSum+=(long)arr[i]*arr[i];
        }
        // Step 2: find differences
        long val1=S-actualSum;//x-y
        long val2=S2-actualSquareSum;//x^2-y^2
        // Step 3: get (x + y)
        val2=val2/val1;
        // Step 4: solve for x and y
        long missing = (val1 + val2) / 2;
        long repeating = missing - val1;

        System.out.println("repeating " + repeating + " missing " + missing);

    }

    public void optimal2(int[] arr,int n){
        // using xor
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        miss_repeat sol=new miss_repeat();
        sol.approach1(arr,n);
        sol.approach2(arr,n);

        sc.close();
    }
    
}
