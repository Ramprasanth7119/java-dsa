
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.lang.StrictMath.log10;

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

        // if(cnt == 2) System.out.print("The given Number is Prime Number and ");
        // else System.out.print("The Given Number is not a Prime Number and ");

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

    public static int gcdI(int n1 , int n2){

        int gcd = 1;
        for(int i=1;i<=n1;i++){
            if(n1 % i == 0 && n2 % i == 0){
                gcd =  i;
            }
        }

        return gcd;
    }

    public static int gcdII(int n1 , int n2){
        
        while(n1 > 0 && n2 > 0){

            if(n1 > n2) n1 = n1 % n2;
            else n2 = n2 % n1;

        }
        if(n1 == 0) return n2;
        return n1;
    }

    public static void primeFactorsI(int n , List<Integer> arr){
        for(int i=2;i<=n;i++){
            if(n%i==0){
                if(isPrime(i)){
                    arr.add(i);
                }
            }
        }
    }

    public static void primeFactorsII(int n , List<Integer> arr){
        for(int i=2;i<=n;i++){
            if(n%i == 0){
                arr.add(i);
                while(n%i == 0){
                    n = n / i;
                }
            }
        }
    }
    public static void primeFactorsIII(int n , List<Integer> arr){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                arr.add(i);
                while(n%i == 0){
                    n = n / i;
                }
            }
        }
        if(n != 1) arr.add(n);
    }

    public static int powerSet(int base , int exp){
        int temp = exp;

        int ans = 1;
        while(exp > 0){
            if(exp%2 == 1){
                ans = ans * base;
                exp = exp - 1;
            } else{
                exp = exp / 2;
                base = base * base;
            }
        }
        if(exp < 0) ans = 1/ans; // If power value is negative
        return ans;
    }

    // Steve of Eratosthenes [An optimal solution to find the n range of prime numbers]
    public static void primeToN(int n , List<Integer> arr){
        
        int prime[] = new int[n + 1];

        for(int i=2;i<prime.length;i++){

            prime[i] = 1;

        }

        for(int i = 2 ; i * i <= n ; i++){

            if(prime[i] == 1){

                for(int j = i * i ; j <= n ; j += i){

                    prime[j] = 0;
                }
            }
        }

        for(int i = 2 ; i <= n ; i++){
            if(prime[i] == 1){
                arr.add(i);
            }
        }
    }

    public static int[] funPrime(int n){
        int prime[] = new int[n + 1];

        for(int i = 2 ; i < n ; i++){

            prime[i] = 1;

        }

        for(int i = 2 ; i * i <= n ; i++){

            if(prime[i] == 1){

                for(int j = i * i ; j <= n ; j += i){

                    prime[j] = 0;

                }
            }
        }
        return prime;
    }

    public static void primeLeftToRight(int queries[][] , List<Integer> arr){

        int prime[] = funPrime(1000000);

        int cnt = 0;

        for(int i = 2 ; i < prime.length ; i++){
            cnt += prime[i];
            prime[i] = cnt; 
        }

        for(int i = 0 ; i < queries.length ; i++){

            int left = queries[i][0];
            int right = queries[i][1];

            int ans = prime[right] - prime[left - 1];

            arr.add(ans);
        }

    }

    public static void smallPrimeFactors(List<List<Integer>> arr , int[] queries){
        
        int spf[] = new int[100000 + 1];

        int len = spf.length;

        for(int i = 1 ; i < len ; i++){
            spf[i] = i;
        }

        for(int i = 2 ; i * i < len ; i++){

            if(spf[i] == i){

                for(int j = i * i ; j < len ; j += i){

                    if(spf[j] == j){

                        spf[j] = i;

                    }
                }
            }
        }

        List<Integer> te = new ArrayList<>();

        for(int i = 0 ; i < queries.length ; i++){

            int temp = queries[i];

            while(temp != 1){

                te.add(temp);
                temp = temp / spf[temp];

            }

            arr.add(te);
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

        int n = 15;

        int queries[][] = {{1,1},{3,11},{19,37}};

        int query[] = {5,7,20};

        List<List<Integer>> res = new ArrayList<>();

        factors(n, ans); // O(sqrt(N))

        primeFactorsI(n, ans); // O(N * sqrt(N))

        primeFactorsII(n, ans); // O(sqrt(N) * 2 * sqrt(N))

        primeFactorsIII(n, ans); // O(sqrt(N) * log(N))

        primeToN(n, ans); // TC -->  O(N) + O(log(log N)) + O(N)  //  SC --> O(N)

        primeLeftToRight(queries, ans); // TC --> O(10^6 log(log(10^6))) + O(10^6) + O(size of queries)

        smallPrimeFactors(res, query);
        
        Collections.sort(ans);

        for(int i : ans){
            System.out.print(i + " ");
        }

        System.out.println();

        for(List<Integer> i : res){
            System.out.println(i);
        }

        System.out.println(gcdI(12,24)); // O(Min(n1,n2))

        System.out.println(gcdII(20,40)); // O(log pi (min(n1,n2)))

        System.out.println(powerSet(2, 10)); // O(log 2 N)

    }
}
