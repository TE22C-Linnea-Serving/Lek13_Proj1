import java.util.Random;
import java.util.Scanner;

public class App {

    static void load() throws Exception{
        
        System.out.print("\nLoading");
        
        for(int i=0; i<3; i++){
            System.out.print(".");
            Thread.sleep(300);
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) throws Exception {       //Att göra:
                                                                    //Flera olika sorters loopar
                                                                    //Score system (För hela spelet)
                                                                    //+ Streak
                                                                    //Fixa så att motstånaren inte kan röra sig efter lyckat försvar

        Scanner tangentbord = new Scanner(System.in);
        Random tärning = new Random();
        int attack1 = 0;
        int attack2 = 0;            
        int f1=1;
        int f2=1;
        int HP1 = 150;
        int HP2 = 150;
        int nr = 0;

        while(HP1>0 && HP2>0){
            
            nr++;
               
            //Meny:
            System.out.println("\n\n\n");
            System.out.println("Omgång "+nr);
            System.out.println("\nMeny:\n1. Attack\n2. Försvar\n3. Info");          
            System.out.println("\nDu har "+HP1+" HP\nDin motståndare har "+HP2+" HP");
            int svar = tangentbord.nextInt();

            if(f1==1){

            //Användaren
            if(svar==1){                                            //Attack
                int miss1 = tärning.nextInt(10);              //Ser om miss

                if(miss1==0){  
                    load();                                     //Attacken missar
                    System.out.println("\nDin attack missade!");
                    attack1 = 0;
                }else{                      
                    load();                       //Attacken lyckas
                    attack1 = tärning.nextInt(20);           
                    attack1++;
                    System.out.println("\nDu gör "+attack1+" skada!");
                }

            }else if(svar==2){      //Användaren försvarar
                int missAF = tärning.nextInt(2);
                if(missAF==0){      //Misslyckas med försvar
                    load();
                    System.out.println("Försvaret misslyckades!");
                    attack1=0;
                }else{              //Lyckas med försvar
                    load();
                    System.out.println("Försvaret lyckades!");
                    attack2/=2;
                    f2=0;
                }

            }else if(svar==3){      //Info
                load();
                System.out.println("\n1. Du börjar med 150 HP. Ditt mål är att få din motståndares HP till 0.\n2. Attack har en 90% chans att lyckas. Om lyckad gör du 1-20 skada på motståndaren.\n3. Försvar har en 50% chans att lyckas. Om lyckad, halverar du motståndarens attack, \noch gör att dom inte kan röra sig nästa runda.\n");


            }else{
                System.out.println("Du skrev in ett ogitligt tal. Försök igen.");
                System.out.println();
            }

        }else{
            load();
            System.out.println("Du kan inte röra dig denna runda");
            f1=1;
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
                    attack1 /= 2; 
                    System.out.println("Du gjorde totalt "+attack1+" skada!");
                    HP2-=attack1;
                    if(svar==1){
                        f1 = 0;
                    }
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

        }

                

                    if(HP1<=0 && HP1<HP2){
                        System.out.println("Du Förlorade!");
                        
                    }else if(HP2<=0 && HP2<HP1){
                        System.out.println("Du Vann!");
        
                    }else if(HP1==HP2 && HP1<=0){
                        System.out.println("Det blev lika!");
                    }
                }
            }
