import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        Random tärning = new Random();

        int m=0;
        while(m==0){
            System.out.println("Meny:\n1. Attack\n2. Försvar\n3. Info");
            System.out.println();
            int svar = tangentbord.nextInt();
            

            if(svar==1){
                int miss1 = tärning.nextInt(10);

                if(miss1==0){
                    System.out.println("Din attack missade. Du gör ingen skada.");
                    int attack1 = 0;
                }else{
                    break;
                }

                //Motståndaren:
                int val1 = tärning.nextInt(6);
                if(val1==0){        //Försvar
                    int missMf = tärning.nextInt(2);
                }else{              //Attack
                    int missMa = tärning.nextInt(9);
                    if(missMa==0){
                        int attack2 = 0;
                    }else{
                        
                    }
                }

            }else if(svar==2){

            }else if(svar==3){
                System.out.println("\n1. Du börjar med 150 HP. Ditt mål är att få din motståndares HP till 0.\n2. Attack har en 90% chans att lyckas. Om lyckad gör du 1-20 skada på motståndaren.\n3. Försvar har en 50% chans att lyckas. Om lyckad, halverar du motståndarens attack, \noch gör att dom inte kan röra sig nästa runda.\n");


            }else{
                System.out.println("Du skrev in ett ogitligt tal. Försök igen.");
                System.out.println();
                m=0;

            }

        }
        
    }
}
