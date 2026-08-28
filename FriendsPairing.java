import java.util.*;
public class FriendsPairing {

    static int pair(int n,int dp []){ // Recursive DP
      if(n<=2) return n;
      if(dp[n]!=-1) return dp[n];
      return dp[n]= pair(n-1, dp) + (n-1)*pair(n-2, dp);
    }

  

    public static void main(String BKP []){
        Scanner rcb=new Scanner(System.in);
        System.out.println("Enter N ");
        int n=rcb.nextInt();
      int dp[] =new int [n+1];
      // Arrays.fill(dp,-1);

    //  System.out.println(pair(n, dp));  // Recursive DP

     System.out.println(pairTabulation(n,dp));
    }



    private static int pairTabulation(int n, int[] dp) {
      // TODO Auto-generated method stub
      
       dp[1]=1;
      if(n>1) dp[2]=2;
       for(int i=3;i<=n;i++){
        dp[i]= dp[i-1] + (i-1)*dp[i-2];
       }
       return dp[n];
    }
}
