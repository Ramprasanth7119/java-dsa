
import java.util.*;


public class MaximalRectangle {

    public static int largestHistogram(int arr[]){

        int n = arr.length;

        int nse = 0 , pse = 0 , el = 0 , max = Integer.MIN_VALUE;

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]){

                el = st.pop();

                nse = i;
                pse = st.isEmpty() ? -1 : st.peek();

                max = Math.max(max , arr[el] * (nse - pse - 1));

            }
            st.push(i);
        }

        while(!st.isEmpty()){

            el = st.pop();

            nse = n;
            pse = st.isEmpty() ? -1 : st.peek();

            max = Math.max(max , arr[el] * (nse - pse - 1));

        }
        return max;
    }

    public static int[][] prefixSum(int mat[][]){

        int n = mat.length;
        int m = mat[0].length;

        int pre[][] = new int[n][m];

        int sum = 0;

        for(int j = 0 ; j < m ; j++){

            sum = 0;

            for(int i = 0 ; i < n ; i++){

                sum += mat[i][j];

                if(mat[i][j] == 0) sum = 0;

                pre[i][j] = sum;

            }

        }
        return pre;
    }

    
    public static void main(String[] args) {
        
        int mat[][] = { {1,0,1,0,1} , {1,0,1,1,1} , {1,1,1,1,1} , {1,0,0,1,0}};

        int pre[][] = prefixSum(mat);

        int max = 0;

        for(int i = 0 ; i < pre.length ; i++){

            max = Math.max(max , largestHistogram(pre[i]));

        }

        System.out.println(max); // TC --> O(M * N) + O(2 * M * N)  , SC --> O(N + M) + O(N)

    }

}
