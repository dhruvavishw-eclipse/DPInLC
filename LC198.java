import java.util.*;
public class LC198 {

    static int tabulation(int nums[],int dp[]){
        int n=nums.length;
        if(n==1) return nums[0];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }

    static int robber(int nums [],int idx,int dp []){
      // Recursive DP
      if(idx>=nums.length) return 0;
      if(dp[idx]!=-1) return dp[idx];
      int pick=nums[idx]+ robber(nums, idx+2, dp);
      int skip=robber(nums, idx+1, dp);
      return dp[idx]=Math.max(pick,skip);
    }

    public static void main(String[] args) {
        int nums []={2,7,9,3,1};
        int n=nums.length;
        int dp []=new int [n];
        Arrays.fill(dp,-1);
    //    System.out.println(robber(nums, 0, dp)); //For recursive
    System.out.println(tabulation(nums, dp));  // For Tabulation
    }
}
