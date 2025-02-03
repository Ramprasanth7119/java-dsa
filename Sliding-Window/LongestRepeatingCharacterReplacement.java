

public class LongestRepeatingCharacterReplacement {

    public static int longestRepeatingCharacterReplacementI(String s , int k){

        int n = s.length();

        int maxFreq = 0 , maxLen = 0 , changes = 0;

        for(int i = 0 ; i < n ; i++){
            
            int hash[] = new int[26];

            for(int j = i ; j < n ; j++){

                hash[s.charAt(j) - 'A']++;

                maxFreq = Math.max(maxFreq , hash[s.charAt(j) - 'A']);

                changes = (j - i + 1) - maxFreq;

                if(changes <= k){

                    maxLen = Math.max(maxLen , j - i + 1);
                } else{
                    break;
                }
            }
        }

        return maxLen;

    }

    public static int longestRepeatingCharacterReplacementII(String s , int k){

        int n = s.length();

        int left = 0 , right = 0 , maxLen = 0 , maxFreq = 0;
        
        int hash[] = new int[26];

        while(right < n){

            hash[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq , hash[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k){

                hash[s.charAt(right) - 'A']--;

                maxFreq = 0;

                left++;

            }
            
            if((right - left + 1) - maxFreq <= k){

                maxLen = Math.max(maxLen , (right - left + 1));

            }

            right++;

        }

        return maxLen;

    }

    public static void main(String[] args) {
        
        String s = "AABAABA";

        System.out.println(longestRepeatingCharacterReplacementI(s, 2));  // O(N^2);

        System.out.println(longestRepeatingCharacterReplacementII(s, 2));  // O(N)

    }
}
