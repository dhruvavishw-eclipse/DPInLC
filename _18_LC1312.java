import java.util.*;
public class _18_LC1312 {

    static int dp[][];

    public static void main(String [] BKP){
     String s = "leetcode";

     System.out.println(fmi(s));
    
    }

    private static int fmi(String s) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'fmi'");

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
        int ans=mi(m-1,n-1,sb,rev);
        return n-ans; // Both m-ans || n-ans are applicable
    }

    private static int mi(int i, int j, StringBuilder sb, StringBuilder rev) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mi'");
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(sb.charAt(i)==rev.charAt(j)) return dp[i][j]=1+ mi(i-1, j-1, sb, rev);
        else{
            return dp[i][j]=Math.max(mi(i-1, j, sb, rev),mi(i, j-1, sb, rev));
        }
    }
}
