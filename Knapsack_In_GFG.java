public class Knapsack_In_GFG {
    
    public static void main(String BKP []){
        int val []={1,2,3};
        int wt[]={4,5,1};
        int W=4;
         
        int n=val.length;
        int dp [][]=new int [n][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=-1;
            }
        }

        System.out.println(profit(0,val,wt,W,dp));
    }

     public static int profit(int i, int[] val, int[] wt, int W, int[][] dp) {
        // TODO Auto-generated method stub

        if(i==val.length) return 0;
        if(dp[i][W]!=-1) return dp[i][W];
        int skip=profit(i+1, val, wt, W, dp);
        if(wt[i]>W) return dp[i][W]=skip;
        int pick=val[i]+ profit(i+1, val, wt, W-wt[i], dp);
        return dp[i][W]=Math.max(pick,skip);
        
    }
}
