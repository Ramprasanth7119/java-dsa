
import static java.lang.StrictMath.log10;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int numberCount(int n){
        int temp = n , cnt = 0; 

        while(temp > 0){
            int res = temp % 10;
            cnt++;
            temp /= 10;
        }
        return cnt;
    }

    public static int reverseNumber(int n){

        int temp = n , ans= 0 ;
        while(temp > 0){
            int res = temp % 10;
            ans = ans * 10 + res;
            temp /= 10;
        }
        return ans;
    }

    public static boolean palindromeNumber(int n){

        int temp = n , ans= 0 ;
        while(temp > 0){
            int res = temp % 10;
            ans = ans * 10 + res;
            temp /= 10;
        }

        if(n == ans) System.out.print("The Given number is Palindrome and ");
        else System.out.print("The given number is not a Palindrome and ");

        return n == ans;
    }

    public static boolean amstrongNumber(int n){
        
        int temp = n , res = 0 , sum = 0;
        while(temp > 0){
            int mod = temp % 10;
            sum += (mod * mod * mod);
            temp /= 10;
        }

        if(n == sum) System.out.print("The Given number is Amstrong Number and ");
        else System.out.print("The given number is not a Amstrong Number and ");

        return n == sum;
    }

    public static boolean isPrime(int n){
        int cnt = 0;

        for(int i=1;i*i<=n;i++){
            if(n%i == 0){
                cnt++;
                if((n/i) != i){
                    cnt++;
                }
            } 
        }

        if(cnt == 2) System.out.print("The given Number is Prime Number and ");
        else System.out.print("The Given Number is not a Prime Number and ");

        if(cnt == 2) return true;
        return false;
    }

    public static void factors(int n , List<Integer> arr){

        for(int i = 1 ; i * i < n ; i++){
            if(n % i == 0){
                arr.add(i);
                if((n/i) != i) arr.add(n/i);
            }
            
        }
    }
    public static void main(String[] args) {

        System.out.println(numberCount(7659));  // O(log (N))

        // import static java.lang.StrictMath.log10;
        System.out.println((int)log10(6754) + 1); // Another Method to find the numberCount using log function. Don't forget to add the import statement.

        System.out.println(reverseNumber(9876));

        System.out.println(palindromeNumber(121));

        System.out.println(amstrongNumber(1634));
        
        System.out.println(isPrime(2)); // O(sqrt(N))

        List<Integer> ans = new ArrayList<>();

        int n = 10;

        factors(n, ans); // O(sqrt(N))

        Collections.sort(ans);

        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
