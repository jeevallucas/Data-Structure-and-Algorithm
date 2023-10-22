package praktikum_02_72210512;

public class Matematika {
    public static String fibo(int n){
        String s = "";
        int x = 0,fib1 = 0,fib2 = 1,fib3;   
        
        while (x < n){
            s = s + fib1 + " ";
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
            x += 1;
        }
        
        return s;
    }
    
    public static boolean isPrima(int n){
        
        boolean Prima = true;
        
        if(n < 2)
            Prima = false;
        
        if(n > 2){
            for(int i = 2; i <= (n / 2); i++)
                if(n % i == 0){
                    Prima = false;
                    break;
                }
        }
        
        return Prima;
    }
    
    public String deretPrima(int n){
         String bil_prima = "";
         int i = 0;
         int prima = 0;
         while(prima < n){
             if(isPrima(i)){
                 bil_prima = bil_prima + " "+ i;
                 prima++;
             }
             
             i++;
         }
                           
          return bil_prima;
    }
}