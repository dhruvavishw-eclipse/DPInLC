import java.util.*;

public class _19_LC583_Delete_Operation_for_two_Strings {

     static int dp [][];


    public static void main(String [] BKP){
        String word1 = "leetcode";
        String word2 = "etco";

       System.out.println(md(word1,word2));
    }

    private static int md(String word1, String word2) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'md'");

        StringBuilder s1=new StringBuilder(word1);
        StringBuilder s2=new StringBuilder(word2);

        int m=s1.length();
        int n=s2.length();

        dp=new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        int x= mdSolution(m-1,n-1,s1,s2);
        int y=m-x;
        int z=n-x;
        return y+z;
    }

    private static int mdSolution(int i, int j, StringBuilder s1, StringBuilder s2) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mdSolution'");
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=1 + mdSolution(i-1, j-1, s1, s2);
        else{
            return dp[i][j]=Math.max(mdSolution(i-1, j, s1, s2),mdSolution(i, j-1, s1, s2));
        }
    }
}
