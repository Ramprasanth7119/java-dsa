

public class NumberofCharactersWith3SubString {

    public static int numberofCharactersWith3SubStringI(String s){

        int n = s.length();

        int cnt = 0;

        for(int i = 0 ; i < n ; i++){

            int hash[] = new int[3];
 
            for(int j = i ; j < n ; j++){

                hash[s.charAt(j) - 'a']++;

                if(hash[0] > 0 &&  hash[1] > 0 &&  hash[2] > 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int numberofCharactersWith3SubStringII(String s){

        int n = s.length();

        int hash[] ={-1,-1,-1}; 

        int cnt = 0;

        for(int i = 0 ; i < n ; i++){

            hash[s.charAt(i) - 'a'] = i;

            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1){

                int min = (Math.min(Math.min(hash[0] , hash[1]) , hash[2]));
                
                cnt += min + 1;
            }
        }

        return cnt;
    }
   
    public static void main(String[] args) {
        
        String str = "abcabc";

        System.out.println(numberofCharactersWith3SubStringI(str));

        System.out.println(numberofCharactersWith3SubStringII(str));
    }
}
