import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FruitBasket {

     // Brute Force --> O(N * N) , O(3);
    public static int fruitBasketI(int arr[]){
        int n = arr.length;

        int maxLen = 0;

        for(int i = 0 ; i < n ; i++){
            Set<Integer> temp = new HashSet<>();

            for(int j = i ; j < n ; j++){

                temp.add(arr[j]);

                if(temp.size() > 2){

                    break;
                }

                maxLen = Math.max(maxLen , j - i + 1);
            }
        }
        return maxLen;
    }

     // Better Solution --> O(N + N) , O(3); 
     // one for Outer while Loop and another for inside while loop
    public static int fruitBasketII(int arr[] , int k){

        int n = arr.length;

        int left = 0 , right = 0 , maxLen = 0;

        HashMap<Integer , Integer> temp = new HashMap<>();

        while(right < n){
            
            temp.put(arr[right] , temp.getOrDefault(arr[right], 0) + 1);

            if(temp.size() > k){

                while(temp.size() > k){

                    temp.put(arr[left] , temp.get(arr[left]) - 1);

                    if(temp.get(arr[left]) == 0){
                        temp.remove(arr[left]);
                    }

                    left++;
                }
            }

            if(temp.size() <= k){
                maxLen = Math.max(maxLen , right - left + 1);
            }

            right++;

        }
        return maxLen;
    }

    // Optimal Solution --> O(N) , O(3)
    public static int fruitBasketIII(int arr[] , int k){

        int n = arr.length;

        int left = 0 , right = 0 , maxLen = 0;

        HashMap<Integer , Integer> temp = new HashMap<>();

        while(right < n){
            
            temp.put(arr[right] , temp.getOrDefault(arr[right], 0) + 1);

            if(temp.size() > k){

                temp.put(arr[left] , temp.get(arr[left]) - 1);

                if(temp.get(arr[left]) == 0){
                    temp.remove(arr[left]);
                }

                left++;
            }

            if(temp.size() <= k){
                maxLen = Math.max(maxLen , right - left + 1);
            }

            right++;

        }
        return maxLen;
    }


    public static void main(String[] args) {

        int arr[] = {3,3,3,1,2,1,1,2,3,3,4};

        System.out.println(fruitBasketI(arr)); // Brute Force --> O(N * N) , O(3);

        System.out.println(fruitBasketII(arr , 2)); // Better Solution --> O(N + N) , O(3);

        System.out.println(fruitBasketIII(arr , 2)); // Optimal Solution --> O(N) , O(3)
        
    }
}


