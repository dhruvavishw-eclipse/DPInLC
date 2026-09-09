import java.util.*;

public class _20_LC72_Edit_Distance {
    static int dp[][];


     static int md(String word1, String word2) {

        int m=word1.length();
        int n=word2.length();
        dp=new int [m][n];

        if(m==0) return n;
        if(n==0) return m;

        for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){

                   int del=(i>=1) ? dp[i-1][j] : j;
                   int ins=(j>=1) ? dp[i][j-1] : i;
                   int rep=(i>=1 && j>=1) ? dp[i-1][j-1] : (i==0 ? j :i);

                if(word1.charAt(i)==word2.charAt((j)))  dp[i][j]= rep;
               else
                  dp[i][j]= 1+Math.min(del,Math.min(ins,rep));             
            } 
        }
        return dp[m-1][n-1];
     }


    
    static  int mo(int i,int j,StringBuilder sb1,StringBuilder sb2){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];
        if(sb1.charAt(i)==sb2.charAt((j))) return dp[i][j]= mo(i-1,j-1,sb1,sb2);
        else{
           int del=mo(i-1,j,sb1,sb2);
           int ins=mo(i,j-1,sb1,sb2);
           int rep=mo(i-1,j-1,sb1,sb2);

           return dp[i][j]=1+Math.min(del,Math.min(ins,rep));
        }
    }


    
    static int minDistance(String word1, String word2) {

        StringBuilder sb1=new StringBuilder(word1);
        StringBuilder sb2=new StringBuilder(word2);

        int m=sb1.length(),n=sb2.length();
        dp=new int [m][n];

        for(int i=0;i<m;i++) 
           for(int j=0;j<n;j++) dp[i][j]=-1;
           
           
        //    return mo(m-1,n-1,sb1,sb2);
        return  md(word1, word2);
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }
}
