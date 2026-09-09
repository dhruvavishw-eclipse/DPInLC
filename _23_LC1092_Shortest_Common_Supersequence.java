import java.util.*;
public class _23_LC1092_Shortest_Common_Supersequence {
    public static void main(String [] RCB){
        String str1 = "abac";
        String str2 = "cab";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }

     public static String shortestCommonSupersequence(String str1, String str2) {
        String lcs=LCS(str1,str2);
        int i=0;
        int j=0;
        int k=0;
        String ans="";

         while(k<lcs.length()){
            while(str1.charAt(i)!=lcs.charAt(k)){
                ans+=str1.charAt(i++);
            }

            while(str2.charAt(j)!=lcs.charAt(k)){
                ans+=str2.charAt(j++);
            }

            ans+=lcs.charAt(k);
            i++; j++; k++;
         }

            while(j<str2.length()){
               ans+=str2.charAt(j++);
            }

            while(i<str1.length()){
               ans+=str1.charAt(i++);
            }

        return ans;

    }


   public static String LCS(String str1,String str2 ){
       int m=str1.length();
       int n=str2.length();
       int dp[][]=new int [m+1][n+1];
       int max=0;
       
      for(int i=1;i<=m;i++){
          for(int j=1;j<=n;j++){
              if(str1.charAt(i-1)==str2.charAt(j-1))
              dp[i][j] = 1+ dp[i-1][j-1];
              else{
                  dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
              }
                 
          }
        
    }

    StringBuilder abc=new  StringBuilder("");
    int i=m,j=n;
    while(i>0 && j>0){
          if (str1.charAt(i-1) == str2.charAt(j-1)) {
              abc.append(str1.charAt(i-1));
               i--;
               j--;
          } 
            else if (dp[i-1][j] > dp[i][j-1]) {
               i--;
         } 
             else 
               j--;

    }

    abc.reverse();
   return abc.toString();
   

   }

}
