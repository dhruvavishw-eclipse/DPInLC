import java.util.*;
public class _16LC1143_Longest_Common_Subsequence {
   static int dp [][];

    public static void main(String []BKP){
      // TC =m*n
      // AS =m*n

        String text1 = "abcde";
        String text2 = "ace";

        StringBuilder a=new StringBuilder(text1);
        StringBuilder b=new StringBuilder(text2);
         int m=a.length();
         int n=b.length();
         dp=new int [m][n];
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                dp[i][j]=-1;
            }
         }

        int ans= lcs(m-1, n-1, a, b);
         System.out.println(ans);
    }

   public  static int lcs(int i, int j, StringBuilder a, StringBuilder b) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'lcs'");

        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j]=1+lcs(i-1, j-1, a, b);
        else{
            return dp[i][j]=Math.max(lcs(i-1, j, a, b),lcs(i, j-1, a, b));
        }
    }
}
