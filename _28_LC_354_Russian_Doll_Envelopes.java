import java.util.Arrays;

public class _28_LC_354_Russian_Doll_Envelopes {
      
    // This is not done yet,this gives TLE because its Optimal solution will be with BST 

    public static void main(String[] RCB) {
        int [] []  envelopes = {{5,4},{6,4},{6,7},{2,3}};

        System.out.println(maxEnvelopes(envelopes));
    }

     public class Envelope implements Comparable <Envelope>{
        int w;
        int h;
        
        Envelope(int w,int h){
            this.w=w;
            this.h=h;       
        }

        public int compareTo(Envelope e){
            if(this.w==e.w) return e.h-this.h;
            return this.w - e.w;
        }

    }

    public static int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        Envelope arr []=new Envelope[n];

        for(int i=0;i<n;i++){
            int w=envelopes[i][0];
            int h=envelopes[i][1];
            arr[i]=new Envelope(w,h);
        }
        Arrays.sort(arr);

        int dp []=new int [n];
        int max=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(arr[j].h<arr[i].h){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]+=1;
            max=Math.max(dp[i],max);
        }
        return max;
    }

}
