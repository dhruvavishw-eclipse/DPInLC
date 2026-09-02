import java.util.*;
public class _12_416_In_LC {

    static boolean subset_Sum(int nums [],int target,int sum){
        if(sum%2 !=0) return false;
        int n=nums.length;
        int dp [][]=new int [n][target+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=target;j++){
                dp[i][j]=-1;
            }
        }

        return subset(0,nums,target,dp);
    }

     static boolean subset(int i, int[] nums, int target, int[][] dp) {
        // TODO Auto-generated method stub
       if(i==nums.length){
        if(target==0) return true;
        else return false;
       }
       if(dp[i][target] !=-1) return (dp[i][target]==1);
       boolean ans=false;
       boolean skip=subset(i+1,nums,target,dp);
       if(target-nums[i]<0) ans=skip;
       else{
        boolean pick=subset(i+1,nums,target-nums[i],dp);
        ans=pick || skip;
       }
       dp[i][target]=(ans) ? 1 :0;
       return ans;
    }

    public static void main(String BKP []){
        int nums []={1,5,11,5};
        int target =11;
        int sum =0;
        for(int ele: nums){
            sum+=ele;
        }

        System.out.println(subset_Sum(nums, target, sum));
      
        
    }
}
