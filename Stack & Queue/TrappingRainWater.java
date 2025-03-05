
public class TrappingRainWater {

    public static int trapI(int arr[]){

        int n = arr.length , total = 0;

        int pre[] = new int[n];

        int post[] = new int[n];

        pre[0] = arr[0];

        post[n - 1] = arr[n - 1];

        for(int i = 1 ; i < n ; i++){

            pre[i] = Math.max(pre[i-1], arr[i]);

        }

        for(int i = n - 2 ; i >= 0 ; i--){

            post[i] = Math.max(post[i+1] , arr[i]);

        }

        int premax = 0 , postmax = 0;

        for(int i = 0 ; i < n ; i++){

            premax = pre[i];
            postmax = post[i];

            if(arr[i] < premax && arr[i] < postmax) total += Math.min(premax , postmax) - arr[i];

        }
        return total;
    }
    
    public static void main(String[] args) {
        
        int arr[] = {0,1,1};

    }

}
