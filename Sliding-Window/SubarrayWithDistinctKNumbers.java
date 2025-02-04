
import java.util.*;

public class SubarrayWithDistinctKNumbers {

    public static int subarrayWithDistinctKNumbers(int arr[] , int goal){

        int n = arr.length;

        if(goal < 0) return 0;

        int left = 0 , right = 0 , cnt = 0;

        Map<Integer , Integer> map = new HashMap<>();

        while(right < n){

            map.put(arr[right] , map.getOrDefault(arr[right] , 0) + 1);
 
            while(map.size() > goal){

                map.put(arr[left] , map.get(arr[left]) - 1);

                if(map.get(arr[left]) == 0) map.remove(arr[left]);
                left++;

            }

            cnt += (right - left + 1);
            right++;

        }

        return cnt;

    }
    
    public static void main(String[] args) {
        
        int arr[] = {1,2,1,3,4};

        int goal = 3;

        int result = subarrayWithDistinctKNumbers(arr,goal) - subarrayWithDistinctKNumbers(arr, goal - 1);

        System.out.println(result);

    }

}
