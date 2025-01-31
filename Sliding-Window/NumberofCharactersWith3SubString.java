

public class NumberofCharactersWith3SubString {

    public static int numberofCharactersWith3SubStringI(String s){

        int n = s.length();

        int cnt = 0;

        for(int i = 0 ; i < n ; i++){

            int hash[] = new int[3];
 
            for(int j = i ; j < n ; j++){

                hash[s.charAt(j) - 'a']++;

                if(hash[0] + hash[1] + hash[2] == 3){
                    cnt++;
                }
            }
        }
        return cnt;
    }
   
    public static void main(String[] args) {
        
        String str = "bbacba";

        System.out.println(numberofCharactersWith3SubStringI(str));
    }
}
