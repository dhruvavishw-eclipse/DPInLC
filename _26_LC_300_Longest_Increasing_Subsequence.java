import java.util.*;
public class _26_LC_300_Longest_Increasing_Subsequence {
    public static void main(String RCB []){
       int [] nums = {10,9,2,5,3,7,101,18};

       System.out.println(Longest_Increasing_Subsequence(nums));
    }

    private static int  Longest_Increasing_Subsequence(int[] nums) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'Longest_Increasing_Subsequence'");
        
        int n=nums.length;
        int dp []=new int [n];
        int max=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i] +=1;
            max=Math.max(dp[i],max);
        }
        return max;
    }
 
   
}
