
public class _14_LC322_Coins_Change {
    public static void main(String [] BKP){
        int coins [] = {1,2,5};
        int amount=11;
        
        
        System.out.println(Coins(coins,amount));
    }

    private static int Coins(int[] coins, int amount) {
       long n=coins.length;
        long dp [][]=new long [coins.length][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }

       int ans=(int)maxCoins(0,coins,amount,dp);
       if(ans==Integer.MAX_VALUE) return -1;
       return ans;
        
    }

    private static long maxCoins(int i, int[] coins, int amount, long[][] dp) {
        // TODO Auto-generated method stub
        if(i==coins.length){
            if(amount==0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        long skip=maxCoins(i+1, coins, amount, dp);
        if(amount-coins[i]<0) return dp[i][amount]=skip;
        long pick=1+maxCoins(i, coins, amount-coins[i], dp);
        return dp[i][amount]=Math.min(pick,skip);
    }
}
