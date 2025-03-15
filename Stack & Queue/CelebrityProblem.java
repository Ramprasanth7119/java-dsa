

public class CelebrityProblem {

    public static int celebrityI(int mat[][]){

        int n = mat.length;

        int knowme[] = new int[n];

        int iknow[] = new int[n];

        for(int i = 0 ; i < n ; i++){

            for(int j = 0 ; j < n ; j++){

                if(mat[i][j] == 1){

                    knowme[j]++;
                    iknow[i]++;

                }

            }

        }

        for(int i = 0 ; i < n ; i++){

            if(iknow[i] == 0 && knowme[i] == n - 1) return i;

        }

        return -1;

    }

    public static int celebrityII(int mat[][]){

        int n = mat.length;

        int top = 0 , bottom = n - 1;

       while(top < bottom){

            if(mat[top][bottom] == 1){

                top++;

            }

            else if(mat[bottom][top] == 1){

                bottom--;

            }

            else {

                top--;
                bottom--;

            }

       } 

       if(top > bottom) return -1;

       for(int i = 0 ; i < n ; i++){

            if(mat[top][i] == 0 && mat[i][top] == 1) return 1;

            else return -1;

       }

       return -1;

    }
    
    public static void main(String[] args) {
        
        int mat[][] = { {0,1,1,0} , {0,0,0,0} , {0,1,0,0} , {1,1,0,0} };

        int n = mat.length;

        System.out.println(celebrityI(mat));

        System.out.println(celebrityII(mat));

    }

}
