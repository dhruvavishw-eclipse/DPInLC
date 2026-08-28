import java.util.*;
public class LC213 {

    static int houseRobber2(int cost [],int dp[],int idx,int n){
        if(idx>=cost.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int pick=cost[idx]+houseRobber2(cost, dp, idx+2,n);
        int skip=houseRobber2(cost, dp, idx+1, n);
       return dp[idx]=Math.max(pick,skip);      
    }

    public static int lc213(int cost){
     
    }

    public static void main(String BKP []){
       int cost []={1,2,3,1};
       int n=cost.length;
       int dp[]=new int[cost.length];
       Arrays.fill(dp,-1);
    }
}
