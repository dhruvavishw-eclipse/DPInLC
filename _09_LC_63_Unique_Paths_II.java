import java.util.*;
public class _09_LC_63_Unique_Paths_II {


    static int paths(int grid [][],int i,int j,int m,int n,int dp [][]){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(grid[0][0]==1 && grid[m-1][n-1]==1) return dp[i][j]= 0;
        if(grid[i][j]==1) return dp[i][j]=0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=paths(grid, i, j+1, m, n, dp);
        int down=paths(grid, i+1, j, m, n, dp);
        return dp[i][j]=right+down;
    }



    // static int paths(int grid [][]){
    //     int m=grid.length;
    //     int n=grid[0].length;
    //     int dp [][]=new int [m][n];
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(grid[i][j]==1) dp[i][j]=0;
    //             else if(i==0 && j==0) dp[i][j]=1;
    //             else if(i==0) dp[i][j]=dp[i][j-1];
    //             else if(j==0) dp[i][j]=dp[i-1][j];
    //             else dp[i][j]=dp[i][j-1]+dp[i-1][j];
    //         }
    //     }
    //     return dp[m-1][n-1];

    // }

    public static void main(String BKP []){
     int grid [] []={{0,0,0},{0,1,0},{0,0,0}};
     int m=grid.length;
     int n=grid[0].length;
     int dp [][]=new int [m][n];
    //  Arrays.fill(dp,-1);
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            dp[i][j]=-1;
        }
    }

    //  System.out.println(paths(grid));
     System.out.println(paths(grid, 0, 0, m, n, dp));

    }
}
