import java.util.*;
public class _13_Unbounded_Knapsack_In_GFG {
    public static void main(String [] BKP){
        int[] val={1,1};
        int[] wt={2,1};
        int C=3;  // capacity;

        int n=val.length;
        int dp[][]=new int [n][C+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=C;j++){
                dp[i][j]=-1;
            }
        }

        System.out.println(knapsack(0,C,val,wt,dp));
    }

    private static int knapsack(int i, int C, int val [], int wt [], int[][] dp) {
        // TODO Auto-generated method stub
        if(i==val.length) return 0;
        if(dp[i][C]!=-1) return dp[i][C];
        int skip=knapsack(i+1,C,val,wt,dp);
        if(wt[i]>C) return dp[i][C]=skip;
        int pick=val[i]+knapsack(0,C-wt[i],val,wt,dp);
        return dp[i][C]=Math.max(pick,skip);
    }
}
