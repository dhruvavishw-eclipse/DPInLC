import java.util.*;
public class LC62 {


    public static int uniquePaths(int m, int n){
    int dp [][]=new int [m][n];
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i==0 || j==0) dp[i][j]=1;
            else dp[i][j]=dp[i][j-1]+ dp[i-1][j];
        }
    }
    return dp[m-1][n-1];


   }




    //  public static int paths(int i,int j,int m,int n,int dp [][]){
    //     // Recursive DP
    //   if(i>=m || j>=n) return 0;
    //   if(i==m-1 && j==n-1) return 1;
    //  if(dp[i][j]!=-1) return dp[i][j];
    //  return dp[i][j]= paths(i+1,j,m,n,dp) +paths(i,j+1,m,n,dp);
    // } 

    // public static int uniquePaths(int m, int n) {
    //   int dp[] []=new int [m][n];
    // for(int i=0;i<m;i++){
    //     for(int j=0;j<n;j++){
    //         dp[i][j]=-1;
    //     }
    //   }
    //     return paths(0,0,m,n,dp);
    // }



    public static void main(String BKP []){
     int m=3;
     int n=7;
    System.out.println(uniquePaths(m, n));
    }
}
