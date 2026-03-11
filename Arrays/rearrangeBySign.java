import java.util.*;
public class rearrangeBySign {
    public void Brute(int [] arr){
        int n=arr.length;
        int[] pos=new int[n/2];
        int[] neg=new int[n/2];
        int p=0;
        int ne=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                pos[p]=arr[i];
            p++;}
            else{
                neg[ne]=arr[i];
            ne++;
        }
        }
        for(int i=0;i<n/2;i++){
            arr[2*i]=pos[i];
            arr[2*i+1]=neg[i];
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public void Optimal(int[] arr){
        int n=arr.length;
        int[] ans=new int[n/2];
        int posidx=0,negidx=1;
        for(int i:arr){
            if(i<0)
                {
                    ans[negidx]=i;
                    negidx+=2;
                }
                else{
                    ans[posidx]=i;
                    negidx+=2;
                }
            }
            for(int i:ans){
                System.out.print(i);
            }
        }
        //unequal between pos and negative numbers
        public void notEqual(int[] arr){
            int n=arr.length;
            ArrayList<Integer>pos=new ArrayList<>();
            ArrayList<Integer>neg=new ArrayList<>();
            for(int i:arr)
                {
                    if(i>=0)pos.add(i);
                    else neg.add(i);
                }
            int i=0,p=0,ne=0;
            while(p<pos.size() && ne<neg.size())
            {
                arr[i++]=pos.get(p++);
                arr[i++]=neg.get(ne++);
            }
            while(p<pos.size()){
                arr[i++]=pos.get(p++);
            }
            while(n<neg.size()){
                arr[i++]=neg.get(ne++);
            }
            for(int t:arr){
                System.out.print(t);
            }

    
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        rearrangeBySign sol=new rearrangeBySign();
        sol.Brute(arr);
        // sol.Optimal(arr);
        sc.close();
    }
}
