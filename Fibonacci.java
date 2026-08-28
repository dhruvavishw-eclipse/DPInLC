import java.util.*;
public class Fibonacci {
     static int LC509(int n,int dp []){
        // Fibonacci series by  Recursive DP
        if(n<=1) return n;
        if(n==2) return 1;
        if(dp[n]!=0) return dp[n];
        return dp[n]=LC509(n-1,dp) +LC509(n-2,dp);
    }


    static int LC509Tabulation(int n,int dp[]){
      if(n<=1) return n;
      dp[0]=0;
      dp[1]=1;
      for(int i=2;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
      }
      return dp[n];

    }

    

    public static void main(String [] BKP){
        Scanner rcb=new Scanner(System.in);
        System.out.println("Enter number n ");
        int n=rcb.nextInt();
        int dp []=new int [n+1];

        // System.out.println(LC509(n, dp)); // This for Memoization
        System.out.println(LC509Tabulation(n, dp)); // This for Tabulation
       
    }
    
}
