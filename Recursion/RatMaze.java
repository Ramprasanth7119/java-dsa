import java.util.ArrayList;
import java.util.List;

public class RatMaze {

    public static void visitedList(int[][] vis , int n){
       

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                vis[i][j] = 0;
            }
        }

    }

    public static void ratMaze(int i ,int j , int arr[][] , int n , List<String> ans , String move , int vis[][] , int dx[] , int dy[]){
        
        if(i == n-1 && j == n-1){
            ans.add(move);
            return;
        }

        String word = "DLRU";
        for(int ind = 0 ; ind < 4 ; ind++){

            int nx = i + dx[ind];
            int ny = j + dy[ind];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n && vis[nx][ny] == 0 && arr[nx][ny] == 1){

                vis[nx][ny] = 1;
                ratMaze(nx, ny, arr, n, ans, move + word.charAt(ind), vis, dx, dy);
                vis[nx][ny] = 0;

            }
        }   

    }

    public static void main(String[] args) {
        
        int arr[][] = {
            {1,0,0,0},
            {1,1,0,1},
            {1,1,0,0},
            {0,1,1,1}
        };

        int n = arr.length;

        int[][] visited = new int[n][n];

        visitedList(visited, n);

        int dx[] = {1,0,0,-1};
        int dy[] = {0,-1,1,0};

        List<String> ans = new ArrayList<>();

        if(arr[0][0] == 1){
            visited[0][0] = 1;
            ratMaze(0, 0, arr, n, ans, "", visited, dx, dy);
        } 

        System.out.println(ans.size());
        for(String i : ans){
            System.out.println(i);
        }
    }
}
