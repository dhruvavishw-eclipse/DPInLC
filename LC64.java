import java.util.*;
public class LC64 {

    public static int minPathSum(int[][] grid){
        // This is for Tabulation
      int r=grid.length;
      int c=grid[0].length;
      for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if( i==0 && j==0 ) continue;
            else if(i==0) grid[i][j]+=grid[i][j-1];
            else if(j==0) grid[i][j]+=grid[i-1][j];
            else grid [i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
        }
      }
      return grid[r-1][c-1];
    }


//     public static int sum(int[][] grid, int r, int c, int i, int j, int[][] dp) {
//         // TODO Auto-generated method stub
//         if(i>=r || j>=c) return Integer.MAX_VALUE;
//         if(i==r-1 && j==c-1) return dp[i][j]=grid[i][j];
//         if(dp[i][j]!=-1) return dp[i][j];
//         return dp[i][j]= grid[i][j]+ Math.min(sum(grid, r, c, i+1, j, dp),sum(grid, r, c, i, j+1, dp));
       
//     }

//     public static int minPathSum(int[][] grid){
//         // This for Recursive DP
//     int r=grid.length;
//     int c=grid[0].length;
//     int dp[][]=new int [r][c];
//     // Arrays.fill(dp,-1);
//   for(int i=0;i<r;i++){
//     for(int j=0;j<c;j++){
//         dp[i][j]=-1;
//     }
//   }

//     return sum(grid,r,c,0,0,dp);
//    }


    

    public static void main(String BKP []){
        int grid [][]={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
