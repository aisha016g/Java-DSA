import java.util.*;
public class GasStation {
    public double brute(int[] arr,int k){
        int n=arr.length;
        int [] howMany=new int[n];
        // int maxIdx;
        for(int gas=1 ;gas<=k;gas++){
            double maxVal=-1;
            int maxIdx=-1;
            for(int i=0;i<n;i++){
                double diff=arr[i+1]-arr[i];
                double sectionLength=diff/(double)(howMany[i]+1);
               
                if(maxVal<sectionLength){
                    maxVal=sectionLength;
                    maxIdx=i;}
            }
            howMany[maxIdx]++;
        }
        double ans=-1;
        for(int i=0;i<n;i++){
             double diff=arr[i+1]-arr[i];
                double sectionLength=diff/(double)(howMany[i]+1);
                ans=Math.max(ans,sectionLength);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Number of gas ststaions ");
        int k=sc.nextInt();
        GasStation sol=new GasStation();
        //  return minimum day required to bloom thr k number of adjacent flowers 
        double res=sol.brute(arr,k);
        // int res=sol.optimal(arr,m,k);
        System.out.println(res);
        sc.close();
    
}
}
