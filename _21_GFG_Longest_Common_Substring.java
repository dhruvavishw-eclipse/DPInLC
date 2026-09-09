import java.util.*;
public class _21_GFG_Longest_Common_Substring {
    public static void main(String BKP []){
        String  s1 = "ABCDGH";
        String  s2 = "ACDGHR";
        
        int m=s1.length();
        int n=s2.length();
        int dp [][]=new int [m+1][n+1]; // Just skipping base cases through this
        int max=0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+ dp[i-1][j-1];
                else dp[i][j]=0;
                max=Math.max(max,dp[i][j]);
            }           
        }
        System.out.println(max);
    }
}
