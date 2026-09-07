import java.util.*;
public class _17_LC516_Longest_Palindromic_Subsequence {
     static int dp [][];




    public static void main(String []BKP){
        String  s = "bbabcbcab";

     System.out.println(longestPalindromeSubseq( s));
    }



    static int longestPalindromeSubseq(String s) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'longestPalindromeSubseq'");
         StringBuilder sb=new StringBuilder(s);
         StringBuilder rev=new StringBuilder(s).reverse();
         int m=sb.length();
         int n=rev.length();
         dp=new int [m][n];
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
         }

         return lps(m-1,n-1,sb,rev);


    }

     static int lps(int i, int j, StringBuilder sb, StringBuilder rev) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'lps'");

        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(sb.charAt(i)==rev.charAt(j)) return dp[i][j]=1+lps(i-1, j-1, sb, rev);
        else{
            return dp[i][j]=Math.max(lps(i-1, j, sb, rev),lps(i, j-1, sb, rev));
        }
    }
}
