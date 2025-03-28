 import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static void swapArray(int arr[] ,int a,int b){ 
        int temp = arr[a];
        arr[a]  =  arr[b];
        arr[b]  =  temp; 
    }  
 
    // To avoid the unwanted return statement == >   @SuppressWarnings("UnnecessaryReturnStatement")

    
    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void printNTo1Count(int n,int count){
        
        if(count >= n){
            return;
        }

        //1 to N
        System.out.print(count + " ");
        count++;

        printNTo1Count(n,count);

        // N to 1
        System.out.print(count + " ");

    } 

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void printNameNTimes(int n){
        if(n < 1){
            return;
        } 

        System.out.println("ram " + n);
        printNameNTimes(n-1);

    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void number1ToN(int i ,int n){
        if(i > n){
            return;
        }

        System.out.println(i);

        number1ToN(i+1,n);
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void numberNTo1(int i ,int n){
        if(i < 1){
            return;
        }

        System.out.println(i);

        numberNTo1(i-1,n);
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void number1ToNBackTracking(int i,int n){

        if(i < 1){
            return;
        }

        number1ToNBackTracking(i-1, n);

        System.out.println(i);
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void numberNTo1BackTracking(int i,int n){

        if(i > n){
            return;
        }

        numberNTo1BackTracking(i+1, n);

        System.out.println(i);
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void sumOfNumbers(int n1 , int n,int sum){
  
        if(n < 0) {
            System.out.println("Sum of " + n1 +  " is : " + sum);
            return;
        }

        sumOfNumbers(n1 , n-1 , sum + n);
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void factorial1(int n1 , int n,int fact){
  
        if(n == 0) {
            System.out.println("factorial of 0  is : " + 1);
            return;
        }
        if(n == 1) {
            System.out.println("factorial of " + n1 +  " is : " + fact);
            return;
        }

        factorial1(n1 , n-1 , fact * n);
    }
    
    @SuppressWarnings("UnnecessaryReturnStatement")
    public static int factorial2( int n){
  
        if(n == 0) {
            return 1;
        }

        return  n * factorial2(n-1);
    }

    public static void reverseArray(int arr[]){

        System.out.print("Initail Array : ");
        for(int i : arr){
            System.out.print(" " + i);
        }

        System.out.println();

        int n = arr.length;

        for(int i=0;i<n/2;i++){
            swapArray(arr,i,n-i-1);
        }

        System.out.print("Reversed Array : ");
        for(int i : arr){
            System.out.print(" " + i);
        }

    }

    public static boolean palindrome(String s){ 

        int n = s.length();
        int flag = 0;

        for(int i = 0;i<n;i++){

            if(s.charAt(i) != s.charAt( n - i - 1)){
                flag = 1;
            }
        
        }
        if(flag == 1){
            System.out.println("The given String is not a palindrome");
            return false;
        }
        System.out.println("The given string is Palindrome");
        return true;
    }

    public static int nThFibbonacci(int n){
        
        if(n <= 1) return n;

        int last = nThFibbonacci(n-1);
        int secondLast = nThFibbonacci(n-2);

        return last + secondLast;
    }

    public static void fibbonacci(int n){

        int first = 0;
        int second = 1;
        
        System.out.print("The fibonacci number up to " + n + " is : ");

        for(int i = 0 ; i < n ; i++){

            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;

        }
    }   

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void subset(int arr[] , int ind , int n , List<Integer> ans){
        
        if(ind == n){
            for(int i:ans){
                System.out.print("[" + i + "]");
            }
            System.out.println();
            return;
        }

        ans.add(arr[ind]);

        subset(arr,ind+1,n,ans);

        ans.remove(ans.size() - 1);

        subset(arr, ind+1, n, ans);
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void subsetSum(int arr[] , int ind , int n , List<Integer> ans,int sum,int k){
        
        if(ind == n){
            if(sum == k){
                for(int i:ans){
                    System.out.print("[" + i + "]");
                }
                System.out.println();
            }
            return;
        }

        ans.add(arr[ind]);

        sum += arr[ind];

        subsetSum(arr,ind+1,n,ans,sum,k);

        ans.remove(ans.size() - 1);

        sum -= arr[ind];

        subsetSum(arr, ind+1, n, ans,sum,k);
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static boolean singleSubsetSum(int arr[] , int ind , int n , List<Integer> ans,int sum,int k){
        
        if(ind == n){
            if(sum == k){
                for(int i:ans){
                    System.out.print("[" + i + "] ");
                }
                return true;
            } else {
                return false;
            }
        }

        ans.add(arr[ind]);

        sum += arr[ind];

        if(singleSubsetSum(arr,ind+1,n,ans,sum,k) == true) return true;

        ans.remove(ans.size() - 1);

        sum -= arr[ind];

        if(singleSubsetSum(arr, ind+1, n, ans,sum,k) == true) return true;

        return false;
    }
    @SuppressWarnings("UnnecessaryReturnStatement")
    public static int subsetCount(int arr[] , int ind , int n ,int sum,int k){
        
        if(ind == n){
            if(sum == k){
                return 1;
            } else {
                return 0;
            }
        }

        sum += arr[ind];

        int l = subsetCount(arr,ind+1,n,sum,k);

        sum -= arr[ind];

        int r = subsetCount(arr, ind+1, n,sum,k);

        return l+ r;
    }

    public static void main(String[] args) {

        int n = 6;

        int arr[] = {1,2,3};

        int len = arr.length;

        int k = 3;

        String s = "madam";

        List<Integer> ans = new ArrayList<>();

        //  printNTo1Count(n,1);

        //  printNameNTimes(n);

        //  number1ToN(1,n);

        //  numberNTo1(n,n);

        //  number1ToNBackTracking(n, n);

        //  numberNTo1BackTracking(1, n);

        //  sumOfNumbers(n,n,0);

        //  factorial1(n,n,1);

        //  System.out.println("factorial of " + n +  " is : " + factorial2(n));

        //  reverseArray(arr);

        //  System.out.println(palindrome(s));

        // fibbonacci(n);

        // System.out.println(nThFibbonacci(n));  // O(2 ^ N);

        subset(arr,0,len,ans);

        subsetSum(arr,0,len,ans,0,k);

        // System.out.println(singleSubsetSum(arr,0,len,ans,0,k));

        // System.out.println(subsetCount(arr,0,len,0,3));

    }
}
