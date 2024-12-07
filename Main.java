class Main{

    public static String reverse(String str){

        String res = "";
        int n = str.length();
        for(int i=n-1;i>=0;i--){
            char x = str.charAt(i);
            res += x; 
        }
        return res;
    }    

    public static String Dec2Bin(int dec){
        String res = "";
        while(dec > 0){
            if(dec%2 == 1) res += '1';
            else res += '0';
            dec /= 2;
        }
        return reverse(res);
    }

    public static int Bin2Dec(String bin){
        int p = 1,res = 0;
        int n = bin.length();
        for(int i=n-1;i>=0;i--){
            if(bin.charAt(i) == '1'){
                res = res + p;
            }
            p *= 2;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int dec = 10;
        String bin = "1111";

        System.out.println("Binary Value for " + dec + " : "+Dec2Bin(dec));  // TC -> O(logn)  SC  -> O(logn);

        System.out.println("Decimal Value for " + dec + " : "+Bin2Dec(bin)); // TC -> O(size)  SC  -> O(1);
        
    }
}
