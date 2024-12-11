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
    
    public static int countSetBitLength(int N){
        
        int cnt = 0;
        int temp = N;

        while(temp != 0){
            
            cnt += temp & 1; // check for odd bit.
            
            temp = temp >> 1; // temp /= 2;
        }

        return cnt;
    }

    public static void swap2numbers(int n1,int n2){

        n1 = n1 ^ n2;
        n2 = n1 ^ n2;
        n1 = n1 ^ n2;

        System.out.println("Number after Swaping : "+ n1+" "+n2+" ");
    }

    public static void IthBitSetOrNot(int N,int i){

        int result = N & (1<<i);
        if(result > 0 ){
            System.out.println("The bit is set");
        } else{
            System.out.println("The bit is not set");
        }

    }

    public static void setTheIthBit(int N,int i){

        int result = N | (1<<i);

        String ans = Dec2Bin(result);

        System.out.println("The i th bit is set Successfully " + Dec2Bin(result) +" --> "+Bin2Dec(ans));
    }

    public static void clearTheIthBit(int N,int i){
        
        int result = N & ~(1<<i);

        String ans = Dec2Bin(result);

        System.out.println("The i th bit is cleared Successfully " + Dec2Bin(result) +" --> "+Bin2Dec(ans));
    }

    public static void toogleIthBit(int N,int i){
        
        int result = N ^ (1 << i);

        String ans = Dec2Bin(result);

        System.out.println("The toogled value is : " + Dec2Bin(result) +" --> "+Bin2Dec(ans));
    }

    public static void removeLastSetBit(int N){

        int result = N&N-1;

        System.out.println(" "+ result + " " + Dec2Bin(result));
    }

    public static void checkPowerOfTwo(int N){
        
        int result = N & N - 1;

        if(result == 0){
            System.out.println(N + " is a power of 2");
        } else{
            System.out.println(N + " is not a power of 2");
        }
    }

    public static void countSetBits(int N){
        
        int cnt = 0;
        int temp = N;

        while(temp != 0){
            
            cnt += temp & 1; // check for odd bit.
            
            temp = temp >> 1; // temp /= 2;
        }

        System.out.println("The set bit in "+ N + " is "+ cnt);
    }

    public static void startAndGoal(int start,int goal){
        
        int result = start ^ goal;

        System.out.println("Minimum number of flip is : "+countSetBitLength(result));
    
    }

    public static void main(String[] args) {

        int dec = 10;

        String bin = "1111";

        int n1 = 20,n2 = 30;

        int n =13,i = 2;

        int start = 3,goal = 4;

        System.out.println("Binary Value for " + dec + " : "+Dec2Bin(dec));  // TC -> O(logn)  SC  -> O(logn);

        System.out.println("Decimal Value for " + dec + " : "+Bin2Dec(bin)); // TC -> O(size)  SC  -> O(1);

        System.out.println("Number before Swaping : "+ n1+" "+n2+" ");

        swap2numbers(n1,n2);  // XOR

        IthBitSetOrNot(n,i);  // AND

        setTheIthBit(n,i);   // OR

        clearTheIthBit(n,i);  //AND

        toogleIthBit(n,i);   //XOR 

        removeLastSetBit(n);  // N & N - 1

        checkPowerOfTwo(n); // N & N - 1 == 0
        
        countSetBits(n);  // N & 1 , N = N >> 1

        startAndGoal(start,goal); // start ^ goal,countSetBitLength
    }
}
