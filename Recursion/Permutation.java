
import java.util.ArrayList;
import java.util.List;


public class Permutation {

    public static void swap(int n1 , int n2 , int arr[]){

        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;

    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void permutationsI(int arr[] , int n , List<Integer> temp , List<List<Integer>> ans , boolean flag[]){

        if(temp.size() == n){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0 ; i < n ; i++){

            if(!flag[i]){
                flag[i] = true;
                temp.add(arr[i]);
                permutationsI(arr, n, temp, ans, flag);
                temp.remove(temp.size() - 1);
                flag[i] = false;
            }

        }
    }

    public static void permutationsII(int ind , int arr[] , int n , List<List<Integer>> ans){

        if(ind == n){

            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){

                temp.add(arr[i]);

            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = ind ; i < n ; i++){

            swap(ind , i , arr);
            permutationsII(ind + 1, arr, n, ans);
            swap(ind , i , arr);
        }

    }

    public static String permutationKthPair(int n , int k , String res){
        int fact = 1;

        List<Integer> ans = new ArrayList<>();
        for(int i = 1 ; i < n ; i++){
            fact = fact * i;
            ans.add(i);
        }
        ans.add(n);

        k -= 1;

        while(true){

            res = res + ans.get(k / fact);
            ans.remove(k / fact);

            if(ans.size() == 0){
                break;
            }

            k = k % fact;
            fact = fact / ans.size();
        }

        return res;
    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4};

        int n = arr.length;

        int k = 9;

        String res = "";

        List<List<Integer>> ans = new ArrayList<>();

        boolean flag[] = new boolean[n];

        // permutationsI(arr, n, new ArrayList<>(), ans, flag);

        // permutationsII(0, arr, n, ans);

        permutationKthPair(n, k, res);

        for(List<Integer> i : ans){
            System.out.println(i);
        }

        System.out.println(permutationKthPair(n, k, res));

    }
}
