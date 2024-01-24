import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        Random tärning = new Random();
        int attack1 = 0;
        int attack2 = 0;
        int f1=1;
        int HP1 = 150;
        int HP2 = 150;

        if(f1==1){
        int m=0;
        while(m==0){            //Meny:
                        

            if(HP1<=0||HP1<=0&&HP2<=0&&HP1<HP2){
                m=1;
                System.out.println("Du Förlorade!");

            }else if(HP2<=0||HP2<=0&&HP1<=0&&HP2<HP1){
                m=1;
                System.out.println("Du Vann!");

            }else if(HP1==HP2){
                m=1;
                System.out.println("Det blev lika!");
            }else{
                break;
            }


             

            System.out.println("\nMeny:\n1. Attack\n2. Försvar\n3. Info");          
            System.out.println("\nDu har "+HP1+" HP\nDin motståndare har "+HP2+" HP");
            int svar = tangentbord.nextInt();
            
            //Användaren
            if(svar==1){                                            //Attack
                int miss1 = tärning.nextInt(10);              //Ser om miss

                if(miss1==0){                                       //Attacken missar
                    System.out.println("\nDin attack missade!");
                    attack1 = 0;
                }else{                                              //Attacken lyckas
                    attack1 = tärning.nextInt(20);           
                    attack1++;
                    System.out.println("\nDu gör "+attack1+" skada!");
                }




                //Motståndaren:
                int val1 = tärning.nextInt(6);                //Försvar eller attack
                if(val1==0){                                        //Försvar

                    System.out.println("\nMotståndaren försvarar...");
                    int missMf = tärning.nextInt(2);

                    if(missMf==0){                                  //Försvar misslyckas
                        System.out.println("försvaret misslyckades!");
                        HP2-=attack1;

                    }else{                                          //Försvar lyckas
                        System.out.println("försvaret lyckades!");
                        f1 = 0;
                        attack1 /= 2; 
                        System.out.println("Du gjorde totalt "+attack1+" skada!");
                        HP2-=attack1;
                    }
                    
                }else{                                                              //Attack

                    int missMa = tärning.nextInt(9);
                    if(missMa==0){                                                  //Attacken missar
                        attack2 = 0;
                        System.out.println("Din motståndare missar sin attack!");
                        HP2-=attack1;
                    }else{                                                          //Attacken lyckas
                        attack2 = tärning.nextInt(20);
                        System.out.println("Din motståndare gör "+attack2+" sakda!");
                        HP2-=attack1;
                        HP1-=attack2;
                    }
                }

            }else if(svar==2){      //Användaren försvarar

            }else if(svar==3){      //Info
                System.out.println("\n1. Du börjar med 150 HP. Ditt mål är att få din motståndares HP till 0.\n2. Attack har en 90% chans att lyckas. Om lyckad gör du 1-20 skada på motståndaren.\n3. Försvar har en 50% chans att lyckas. Om lyckad, halverar du motståndarens attack, \noch gör att dom inte kan röra sig nästa runda.\n");


            }else{
                System.out.println("Du skrev in ett ogitligt tal. Försök igen.");
                System.out.println();
                m=0;

            }


        }
    }else{
        System.out.println("Du kan inte röra dig denna runda.");
    }
        
    }
}
