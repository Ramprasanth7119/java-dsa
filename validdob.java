public class validdob {

     public static String checkDob(int d,int m,int y){

        boolean leap = false;
        boolean odd = false;
        boolean even = false;

        if(d <= 0 || m <= 0 || y <= 0 || m > 12){
            return "Invalid date or month or year"; 
        }

        if(y%4 == 0 && y%100 != 0 || y%400 == 0){

            leap = true;
            if(leap && m == 2){
                if(d <= 29 ){
                    //leap = true;
                    return "valid";
                }
            }

        }
        if(m!=2) {
            if(m == 1 || m ==3 ||  m == 5 || m == 7 || m == 8 || m == 10 || m == 12){

                if(d <= 31 && d > 0){
                    return "valid";
                }
            } else if(m == 4 || m == 6 || m == 9 || m == 11){
                if(d <= 30 && d > 0){
                    return "valid";
                    //even = true;
                }
            }
    
        }

        if(leap && odd && even){
            return "valid";
        }
        return "invalid";
     }
    
    public static void main(String[] args) {

        int date = 30;
        int month = 2;
        int year = 2000;

        System.out.println(checkDob(date, month, year));
    }


}
