import java.util.*;
public class LC746 {


    static int tabulation(int cost [],int dp[]){
      int n=cost.length;
      dp[0]=cost[0];
      dp[1]=cost[1];
      for(int i=2;i<n;i++){
        dp[i]=cost[i]+Math.min(dp[i-2],dp[i-1]);
      }
      return Math.min(dp[n-2],dp[n-1]);

    }

    static int recursiveDP(int cost[],int n,int dp []){
     if(n>=cost.length) return 0;
     if(dp[n]!=-1) return dp[n];
     int first = cost[n] +recursiveDP(cost, n+1, dp);
     int second=cost [n]+recursiveDP(cost, n+2, dp);
     return dp[n]=Math.min(first,second);

    }

    public static int lc746(int cost [],int dp []){
        // return Math.min(recursiveDP(cost, 0, dp),recursiveDP(cost, 1, dp)); // This for revursive
        return tabulation(cost, dp);
    }



    public static void main(String [] BKP){
    int cost []={1,100,1,1,1,100,1,1,100,1};
    int n=cost.length;
    int dp[]=new int [n];
    // Arrays.fill(dp,-1);

    System.out.println(lc746(cost, dp));   // This one if we did not want to mess up in Main function





    // int ans1=recursiveDP(cost, 0, dp);  This one if we did not want to create a new function
    // int ans2=recursiveDP(cost, 1, dp);
    // int ans=Math.min(ans1,ans2);
    // System.out.println(ans);
    
    }
}
