https://leetcode.com/problems/decode-ways/

class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        int prevInt = s.charAt(0) - '0';

        for(int i=1; i<n; i++) {
            int curInt = s.charAt(i) - '0';
            int v = 10 * prevInt + curInt;
            dp[i] = curInt == 0 ? 0 : dp[i-1]; // eg. 10 for int 0 it will skip current bcz 0 don't map to anyone 
            
            if(prevInt != 0 && v <= 26) {  // eg. 103, for int 3 it will goes '03' so don't take it'
                dp[i] += (i > 1 ? dp[i-2] : 1);
            }
            prevInt = curInt;
        }
        return dp[n-1];
    }    
}
