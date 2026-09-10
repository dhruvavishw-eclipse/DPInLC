import java.util.*;
public class _25_LC_96_Unique_Binary_Search_Trees {

    // THis Problem also on GFG
    
    public static void main(String RCB []) {
        Scanner rcb=new Scanner(System.in);
        System.out.println("Enter n");
        int n=rcb.nextInt();

       
        System.out.println(bst(n));
    }

        static int bst(int n) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'bst'");

         if(n<=1) return 1;

         int dp []=new int [n+1];
         dp[0]=1;
         dp[1]=1;
         dp[2]=2;

         for(int i=3;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+= (dp[j-1] * dp[i-j]);
            }
         }
       return dp[n];
    }
}
