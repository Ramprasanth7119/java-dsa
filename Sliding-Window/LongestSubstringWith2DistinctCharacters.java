import java.util.*;

public class LongestSubstringWith2DistinctCharacters {

     // Brute Force --> O(N * N) , O(256);
    public static int longestSubstringWith2DistinctCharactersI(String s){

        int n = s.length();

        int maxLen = 0;

        for(int i = 0 ; i < n ; i++){

            Set<Character> temp = new HashSet<>();

            for(int j = i ; j < n ; j++){

                temp.add(s.charAt(j));

                if(temp.size() > 2){
                    break;
                }

                maxLen = Math.max(maxLen , j - i + 1);
            }
        }

        return maxLen;
    }

    // Better Solution --> O(N + N) , O(256); 
    // one for Outer while Loop and another for inside while loop
    public static int longestSubstringWith2DistinctCharactersII(String s){

        int n = s.length();

        int left = 0 , right = 0 , maxLen = 0;

        HashMap<Character , Integer> map = new HashMap<>();

        while(right < n){

            map.put(s.charAt(right) , map.getOrDefault(s.charAt(right) , 0) + 1);

            if(map.size() > 2){

                while(map.size() > 2){

                    map.put(s.charAt(left) , map.get(s.charAt(left)) - 1);

                    if(map.get(s.charAt(left)) == 0){

                        map.remove(s.charAt(left));

                    }
                    left++;
                }
            }

            maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }
        return maxLen;
    }

    // Optimal Solution --> O(N) , O(256); 
    public static int longestSubstringWith2DistinctCharactersIII(String s){

        int n = s.length();

        int left = 0 , right = 0 , maxLen = 0;

        HashMap<Character , Integer> map = new HashMap<>();

        while(right < n){

            map.put(s.charAt(right) , map.getOrDefault(s.charAt(right) , 0) + 1);

            if(map.size() > 2){

                map.put(s.charAt(left) , map.get(s.charAt(left)) - 1);

                if(map.get(s.charAt(left)) == 0){

                    map.remove(s.charAt(left));

                }
                left++;
            }

            maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        
        String s = "aaabbccd";

        System.out.println(longestSubstringWith2DistinctCharactersI(s));  // Brute Force --> O(N * N) , O(3);

        System.out.println(longestSubstringWith2DistinctCharactersII(s));  // Better Solution --> O(N + N) == O(2N) , O(256); 

        System.out.println(longestSubstringWith2DistinctCharactersIII(s));  // Optimal Solution --> O(N) , O(256); 
    }
}
