import java.util.*;
public class _30_LC_1547_Minimum_Cost_To_Cut_a_Stick {
    public static void main(String[] RCB) {
        int n = 7;
        int [] cuts = {1,3,4,5};

        System.out.println(Cuts(n, cuts));
    }
    

    private static int  Cuts(int n, int[] cuts) {
        
        int [] arr=new int[cuts.length+2];
        int i;
        for(i=0;i<cuts.length;i++){
            arr[i]=cuts[i];
        }

        arr[i++]=0;
        arr[i]=n;
        Arrays.sort(arr);
        int m=arr.length;
        int dp [][]=new int [m-1][m-1];
        for( i=0;i<m-1;i++){
            for(int j=0;j<m-1;j++){
                dp[i][j]=-1;
            }
        }
       
        return cost(1,m-2,arr,dp);


    }

    private static int cost(int i, int j, int[] arr, int[][] dp) {
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int minCost=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
           int len= arr[j+1]-arr[i-1]; 
           int totalCost= cost(i,k-1,arr,dp) + cost(k+1,j,arr,dp)+ len;
           minCost=Math.min(totalCost,minCost);
        }
        return dp[i][j]=minCost;

    }
}
