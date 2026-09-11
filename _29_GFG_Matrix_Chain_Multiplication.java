import java.util.*;
public class _29_GFG_Matrix_Chain_Multiplication {
    public static void main(String[] RCB) {

        // int nums [][]={{1,2},{2,3},{3,4},{4,2}};  // Output =26;
        int nums []={1,2,3,4,3};   // Output =30;
        int n=nums.length;

        // System.out.println(mcm(0,n-1,nums)); // Output =26;
        // System.out.println(mcmByMemoization(nums)); // Output =30;
        System.out.println(mcmByMemoization(nums));   // Output =30;
    }


    private static int  mcm(int i, int j, int[][] nums) {
   // This solution for 2D array
       if(i==j) return 0;
       int minCost=Integer.MAX_VALUE;

       for(int k=i;k<j;k++){
        int x= nums[i][0] * nums [j][1] *nums[k][1];
        int totalCost= mcm(i, k, nums) + mcm(k+1, j, nums) + x;
        minCost=Math.min(minCost,totalCost);
       }
       return minCost;

    }


     private static int  mcmByMemoization( int[] nums){
          int n=nums.length;
          int [][] dp=new int [n-1][n-1]; // N-1 ,but we actually going from 0->n-2, But for precaution we used n-1;
          for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                dp[i][j]=-1;
            }
          } 

          return mcmAns(0,n-2,nums,dp);
     }


     private static int mcmAns(int i, int j, int[] nums, int[][] dp) {       
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int minCost=Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int x=nums[i] * nums[j+1] * nums[k+1];
            int total= mcmAns(i, k, nums, dp) + mcmAns(k+1, j, nums, dp) + x ;
            minCost=Math.min(minCost,total);
        }
       return dp[i][j]=minCost;
     }


     private  static  int mcmTabulation(int nums []){
        int n=nums.length;
        int dp [][]=new int [n-1][n-1];

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n-1;j++){
               if(i>=j){
                dp[i][j]=0;
                continue;
               }

               int minCost=Integer.MAX_VALUE;

               for(int k=i;k<j;k++){
                int x=nums[i] * nums[k+1] * nums[j+1];
                int total=dp[i][k] + dp[k+1][j];
                minCost=Math.min(minCost,total);
               }
               dp[i][j]=minCost;
            }
        }
        return dp[0][n-2];
     }

}
