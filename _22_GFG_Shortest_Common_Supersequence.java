import java.util.*;
public class _22_GFG_Shortest_Common_Supersequence {
    public static void main(String []RCB){
         String s1 = "geek";
         String s2 = "eke";
         // Output =5;
         // String "geeke" has both string "geek" and "eke" as subsequences.

        System.out.println( scs( s1,s2));

    }

    private static int scs(String s1, String s2) {

         StringBuilder ss1=new StringBuilder(s1);
         StringBuilder ss2=new StringBuilder(s2);

         int m=ss1.length();
         int n=ss2.length();
         int [][] dp=new int [m][n];
         
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 dp[i][j]=-1;
            }
          }    

          int x= scsSolution(m-1, n-1, ss1, ss2, dp);
          int y=m-x;
          int z=n-x;
          return y+z+x;
    }

     static int scsSolution(int i, int j, StringBuilder ss1, StringBuilder ss2,int [][] dp) {

        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(ss1.charAt(i)==ss2.charAt(j)) return dp[i][j]= 1+ scsSolution(i-1, j-1, ss1, ss2, dp);
        else 
            return dp[i][j]=Math.max(scsSolution(i-1, j, ss1, ss2, dp),scsSolution(i, j-1, ss1, ss2, dp));
    }
}
