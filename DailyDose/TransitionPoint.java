//{ Driver Code Starts
import java.io.*;
import java.util.*;
 
class Sorted_Array {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.transitionPoint(arr));
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    int transitionPoint(int arr[]) {
        int n = arr.length;
        
       int flag = 0 , left = 0 , right = n - 1;
       
       if(n == 1 && arr[0] == 1) return -1;
       
       while(left <= right){
           
            int mid = (left + right) / 2;
            
            if(arr[mid] == 1 && arr[mid - 1] == 0) return mid;
            else if(arr[mid] == 1){
                flag = 1;
                right = mid - 1;
            }
            else left = mid + 1;
           
       }
       
       if(flag == 0) return -1;
       return 0;
    }
}
