public class PrefixToInfix {

    public static String prefixToPostfix(String s){

        
    }
    

    public static void main(String[] args) {

        String s1 = "+a*b-^cde";

        String s2 = "+-*+abcdf";

        System.out.println(prefixToPostfix(s1)); // TC --> O(N) + O(N) , SC --> O(N) + O(N)

        System.out.println(prefixToPostfix(s2)); // TC --> O(N) + O(N) , SC --> O(N) + O(N)

    }

}
