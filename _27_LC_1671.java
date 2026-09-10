import java.util.*;
public class _27_LC_1671 {

    
    public static void main(String[] RCB) {
        int []  nums = {2,1,1,5,6,2,3,1};
        
        System.out.println(minimumMountainRemovals(nums));
    }


     public static int minimumMountainRemovals(int[] nums) {
         int n=nums.length;
        int dp1 []=new int [n];

        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(nums[j]<nums[i]){
                    dp1[i]=Math.max(dp1[i],dp1[j]);
                }
            }
            dp1[i] +=1;
        }
       


        int dp2 []=new int [n];
        int maxLen=0;

        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<=n-1;j++){
                if(nums[j]<nums[i]){
                    dp2[i]=Math.max(dp2[i],dp2[j]);
                }
            }
            dp2[i] +=1;
        }
        
         int max=0;
         for(int i=0;i<n;i++){
            if(dp1[i]>1 && dp2[i]>1){
            int len=dp1[i]+dp2[i]-1;
            maxLen=Math.max(maxLen,len);
            }
         }
          
          if(maxLen<3) return 0;
          return n-maxLen;

    }

}
