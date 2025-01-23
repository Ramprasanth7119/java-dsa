

public class LongestSubstringWithoutRepeating {
    
    // Brute Force TC --> O(N * N)
    public static int longestSubstringWithoutRepeatingCharactersI(String s){
        int n = s.length();

        int maxLen = 0 , right = 0;

        for(int i = 0 ; i < n ; i++){

            int hash[] = new int[255];

            for(int z = 0 ; z < 255 ; z++){
                hash[z] = -1;
            }

            for(int j = i ; j < n ; j++){

                if(hash[s.charAt(j)] == 1) break;
                
                right = j - i + 1;
                maxLen = Math.max(right , maxLen);
                hash[s.charAt(j)] = 1;
            }
        }

        return maxLen;
    }

    public static int longestSubstringWithoutRepeatingCharactersII(String s){

        int n = s.length();

        int left = 0 , right = 0 , maxLen = 0;

        int hash[] = new int[256];

        for(int i = 0 ; i < 255 ; i++){
            hash[i] = -1;
        }

        while(right < n){

            if(hash[s.charAt(right)] != -1){

                if(hash[s.charAt(right)] >= left){

                    left = hash[s.charAt(right)] + 1;

                }

            }

            int len = right - left + 1;
            maxLen = Math.max(len , maxLen);

            hash[s.charAt(right)] = right;
            right++;
        }

        return maxLen;  

    }

    public static void main(String[] args) {
        
        String s = "au";

        System.out.println(longestSubstringWithoutRepeatingCharactersI(s));

        System.out.println(longestSubstringWithoutRepeatingCharactersII(s));

    }

}
