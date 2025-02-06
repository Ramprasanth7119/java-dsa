

public class MinimumWindowSubstring {

    public static String minimumWindowSubstring(String s , String goal){

        int n = s.length();
        int m = goal.length();

        int hash[] = new int[256];

        for(int i = 0 ; i < m ; i++){
            hash[goal.charAt(i)]++;
        }

        int left = 0 , right = 0 , cnt = 0 , minIndex = Integer.MAX_VALUE , sIndex = -1;

        while(right < n){

            if(hash[s.charAt(right)] > 0) cnt++;

            hash[s.charAt(right)]--;

            while(cnt == m){

                if((right - left + 1) < minIndex){
                    minIndex = right - left + 1;
                    sIndex = left;
                }
                hash[s.charAt(left)]++;
                
                if(hash[s.charAt(left)] > 0) cnt--;

                left++;

            }

            right++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex , sIndex + minIndex);

    }
    

    public static void main(String[] args) {
        
        String s = "ddaaabbca";

        String goal = "abc";

        System.out.println(minimumWindowSubstring(s, goal));

    }

}
