import java.util.*;
public class _15_LC494_Target_Sum {

    static int sum;
    

    public static void main(String []BKP){
        int nums[]={1,1,1,1,1};
        int target=3; // Ans answer is 5 for this particular problem
        sum=0;
        int n=nums.length;
        for(int ele:nums) sum+=ele;
        int dp[][]=new int [n][2*sum+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }

        System.out.println(ways(0,0,nums,target,dp));
    }


    private static int ways(int i, int res, int[] nums, int target, int[][] dp) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'ways'");
          
        if(i==nums.length){
            if(res==target) return 1;
            else return 0;
        }
        if(dp[i][res+sum]!=-1) return dp[i][res+sum];
        int add=ways(i+1, res-nums[i], nums, target, dp);
        int sub=ways(i+1, res+nums[i], nums, target, dp);
        return dp[i][res+sum]=add+sub;
  
    }
}
