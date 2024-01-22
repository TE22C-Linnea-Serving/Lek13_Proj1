import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);

        int m=0;
        while(m==0){
            System.out.println("Meny:\n1. Attack\n2. Försvar\n3. Info");
            System.out.println();
            int svar = tangentbord.nextInt();

            if(svar==1){

            }else if(svar==2){

            }else if(svar==3){
                System.out.println("\n1. Du börjar med 150 HP. Ditt mål är att få din motståndares HP till 0.\n\n2. Attack har en 90% chans att lyckas. Om lyckad gör du 1-20 skada på motståndaren.\n\n3. Försvar har en 50% chans att lyckas. Om lyckad, halverar du motståndarens attack, och gör att dom inte kan röra sig nästa runda.\n");


            }else{
                System.out.println("Du skrev in ett ogitligt tal. Försök igen.");
                System.out.println();
                m=0;

            }

        }
        
    }
}
