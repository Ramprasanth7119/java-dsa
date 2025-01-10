
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

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
        System.out.println(isPrime(1001));

        List<Integer> ans = new ArrayList<>();

        int n = 10;

        factors(n, ans);

        Collections.sort(ans);

        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
