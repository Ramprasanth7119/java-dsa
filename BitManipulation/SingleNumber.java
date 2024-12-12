
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class SingleNumber {

    //Brute Force [Hashmap]
    public static void singleNumber1Brute(int arr[]){
        
        int n = arr.length;
        Map<Integer , Integer> hashmap = new HashMap<Integer,Integer>();

        for(int i = 0 ; i < n ; i++){
            hashmap.put(arr[i],hashmap.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> num : hashmap.entrySet()) {
            if(num.getValue() == 1) {
                System.out.println("The single number is : " + num.getKey());
            }
        }
    }
    
    // optimal [Bit Manipulation]
    public static void singleNumber1(int arr[]){ 

        int n = arr.length;
        int result = 0;

        for(int i = 0 ; i < n ; i++){
            result = result ^ arr[i];
        }

        System.out.println("The single number is : "+result);
    }
    
    public static void singleNumber2I(int arr[]){
        
        int n = arr.length;
        int ans= 0;

        for(int i = 0 ; i < 32 ; i++){

            int cnt = 0;

            for(int j = 0 ; j < n ; j++){

                int temp = arr[j] & (1 << i);
                if(temp != 0) cnt++; 

            }

            if(cnt % 3 != 0){
                ans = ans | ( 1 << i);
            }
        }

        System.out.println("The single number is : " + ans);
    }
    
    public static void singleNumber2II(int arr[]){

        Arrays.sort(arr);
        int n = arr.length;
        int ans = arr[n-1];
       
        for(int i = 1 ; i < n ; i = i + 3){
            
            if(arr[i] != arr[i-1]){
                ans = arr[i-1];
                break;
            }
            /* 
            if(i + 2 < n && arr[i] == arr[i+1] && arr[i+1] == arr[i+2]){
                continue;
            } else {
                ans = arr[i];
                break;
            }*/
        }
        System.out.println("The single number is : " + ans);
    
    }

    public static void singleNumber3III(int arr[]){

        int n = arr.length;
        int ones = 0,twos = 0;

        for(int i = 0 ; i < n ; i++){
            
            ones = ( ones ^ arr[i] ) & ~ twos;
            twos = ( twos ^ arr[i] ) & ~ ones;
        
        }

        System.out.println("The single number is : " + ones);
    }

    public static void main(String[] args) {
        
        int arr1[] = {1,3,2,3,1};

        int arr2[] = {1,1,3,3,1,3,2,4,5,4,5,5,4};

        singleNumber1Brute(arr1); // O(N * log M) + O(M) --> M = N / 2 + 1;
        
        singleNumber1(arr1); // O(N);

        singleNumber2I(arr2);  // TC --> O(N*32) , SC --> O(1);

        singleNumber2II(arr2);  // TC --> O(N * log N) + N / 3 , SC --> O(1)

        singleNumber3III(arr2);  // TC --> O(N)  SC  --> O(1)
    }
}
