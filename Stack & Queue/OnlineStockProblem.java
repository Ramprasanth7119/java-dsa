import java.util.*;

class Pair{
    int first;
    int second;

    Pair(int first , int second){

        this.first = first;
        this.second = second;

    }
}

class StockSpannerI{

    List<Integer> arr;

    public StockSpannerI(){

        arr = new ArrayList<>();

    }

    public int next(int price){

        arr.add(price);

        int cnt = 1;

        for(int i = arr.size() - 2 ; i >= 0 ; i--){

            if(arr.get(i) <= price){

               cnt++;
           }

           else break;

        }
        return cnt;
    }

}

class StockSpannerII{

    Stack<Pair> st;
    int ind = -1;

    public StockSpannerII(){

        st = new Stack<>();
        ind = -1;

    }

      public int next(int price){

        int ans = 0;

        ind++;

        while(!st.isEmpty() && st.peek().first <= price) st.pop();

        ans = ind - (st.empty() ? -1 : st.peek().second);

        st.push(new Pair(price , ind));

        return ans;

    }

}

public class OnlineStockProblem {
    

    public static void main(String[] args) {
        
        int n = 7;

        int[] stocks = {100, 80, 60, 70, 60, 75, 85};

        StockSpannerI ob = new StockSpannerI();

        for(int i = 0 ; i < n ; i++){

            System.out.print(ob.next(stocks[i]) + " ");

        }

        System.out.println();
        
        int x = 7;

        int[] stock = {100, 80, 60, 70, 60, 75, 85};

        StockSpannerII obj = new StockSpannerII();

        for(int i = 0 ; i < x ; i++){

            System.out.print(obj.next(stocks[i]) + " ");

        }

    }

}
