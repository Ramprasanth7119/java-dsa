import java.util.*;

class Pair{
    int price;
    int span;

    Pair(int price , int span){
        this.price = price;
        this.span = span;
    }
}

class StockSpanner{

    List<Integer> arr;

    public StockSpanner(){
        arr = new ArrayList<>();
    }

    public int next(int price){

        arr.add(price);

        int cnt = 0;

        for(int i = arr.size() - 2 ; i >= 0 ; i--){

            if(arr.get(i) <= price){
               cnt++;
           }

           else break;

        }
        return cnt;
    }

}

public class OnlineStockProblem {
    

    public static void main(String[] args) {
        
        int n = 7;

        int[] stocks = {100, 80, 60, 70, 60, 75, 85};

        StockSpanner ob = new StockSpanner();

        for(int i = 0 ; i < n ; i++){

            // System.out.println()
            System.out.println(ob.next(stocks[i]));

        }

    }

}
