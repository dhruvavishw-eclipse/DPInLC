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

        // int ans= lcs(m-1, n-1, a, b);
        
        int ans =(lcs2(a, b));
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
    

    static int lcs2(StringBuilder a,StringBuilder b){
        int m=a.length();
        int n=b.length();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x=(i>=1 && j>=1) ?dp[i-1][j-1] : 0;
                int y=(i>=1) ? dp[i-1][j] :0;
                int z=(j>=1) ? dp[i][j-1] : 0;

                if(a.charAt(i)==b.charAt(j))  dp[i][j]=1+x;
          else{
                dp[i][j]=Math.max(y,z);
              }
            }
        }
        return dp[m-1][n-1];
    }


    static int lcs3(StringBuilder a,StringBuilder b){
        int m=a.length();
        int n=b.length();

        dp=new int[2][n+1]; // Because we use here n+1 so we did not need to write conditions these are written below
        // we can only use the m+1 && n+1 to skip these condition,this for SPACE OPTIMIZATION so it is only use n+1

        // int x=(i>=1 && j>=1) ?dp[i-1][j-1] : 0;
        //         int y=(i>=1) ? dp[i-1][j] :0;
        //         int z=(j>=1) ? dp[i][j-1] : 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a.charAt(i)==b.charAt(j))  dp[1][j]=1+dp[i-1][j-1];
            else{
                dp[1][j]=Math.max(dp[0][j],dp[1][j-1]);
              }
            }

            for(int j=0;j<=n;j++){
                dp[0][j]=dp[1][j];
            }
        }
        return dp[1][n];// Here only "n" because we done [n+1] so we have to go to (n+1)-1-> That is "n";
    }

  

}
