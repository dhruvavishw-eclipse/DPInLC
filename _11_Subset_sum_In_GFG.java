import java.util.*;
public class _11_Subset_sum_In_GFG {

   

    public static void main(String BKP []){
     int  arr[] = {3, 34, 4, 12, 5, 2};
     int sum=9;
     int n=arr.length;
     int dp [][]=new int[n][sum+1];
     for(int i=0;i<n;i++){
        for(int j=0;j<=sum;j++){
            dp[i][j]=-1;
        }
     }

     System.out.println(subset(0,arr,sum,dp));

    }

    static boolean subset(int i, int[] arr, int sum, int[][] dp) {
        // TODO Auto-generated method stub
      if(i==arr.length){
        if(sum==0) return true;
        else return false;
      }
      if(dp[i][sum]!=-1) return (dp[i][sum]==1);

      boolean ans=false;
      boolean skip=subset(i+1,arr,sum,dp);
      if(sum-arr[i]<0) ans=skip;
      else{
        boolean pick=subset(i+1,arr,sum-arr[i],dp);
        ans= pick || skip;
      }
      
      dp[i][sum]= (ans) ? 1 :0;
      return ans;

    }
}
