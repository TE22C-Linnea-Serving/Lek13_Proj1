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
                                                                    //switch.case
                                                                    //Array/fält
                                                                    //enkel algoritm
                                                                    //Inga globala variabler
                                                                    //Inparametrar
                                                                    //3 metoder som ger struktur
                                                                    //Varje metod gör exact ett jobb

                                                                    
        Scanner tangentbord = new Scanner(System.in);
        Random tärning = new Random();
        int attack1 = 0;        //Användarens attack
        int attack2 = 0;        //Motståndarens attack  
        int försvar2=0;         //När motståndarens försvar inte lyckas
        int försvar1=0;         //När användarens försvar inte lyckas
        int HP1 = 150;
        int HP2 = 150;
        int nr = 0;             //Antal omgångar
        int totaltPoäng1 = 0;   //Användarens antal vinster
        int totaltPoäng2 = 0;   //Motståndarens antal vinster

        System.out.println(totaltPoäng1);
        
        while(HP1>0 && HP2>0){
            nr++;

            
            /*-------------------------------------------------------------------------------------
            *MENY
            ---------------------------------------------------------------------------------------*/
            System.out.println("\n\n\n");
            System.out.println("Omgång "+nr);
            System.out.println("\nMeny:\n1. Attack\n2. Försvar\n3. Info");          
            System.out.println("\nDu har "+HP1+" HP\nDin motståndare har "+HP2+" HP");
            int svar = tangentbord.nextInt();
            
            if(försvar2==0){
                

                /*-------------------------------------------------------------------------------------
                 * ANVÄNDAREN
                ---------------------------------------------------------------------------------------*/
                switch(svar){
                    
                    case 1:                                              //ATTACK
                    int missA1 = tärning.nextInt(10);
                    
                    if(missA1==0){  
                        load();                                             //Attacken misslyckas
                        System.out.println("\nDin attack missade!");
                        attack1 = 0;
                    }else{                      
                        load();                                             //Attacken lyckas
                        attack1 = tärning.nextInt(20);           
                        attack1++;
                        System.out.println("\nDu gör "+attack1+" skada!");
                    }
                    break;
                    
                    case 2:                                         //FÖRSVAR
                    int missA2 = tärning.nextInt(2);
                    
                    if(missA2==0){                                          //Försvaret misslyckas
                        load();
                        System.out.println("Försvaret misslyckades!");
                        attack1=0;
                    }else{                                                  //Försvaret lyckas
                        load();
                        System.out.println("Försvaret lyckades!");
                        attack2/=2;
                        försvar1=1;
                    }
                    break;
                    
                    case 3:                                        //INFO
                    load();
                    System.out.println("\n1. Du börjar med 150 HP. Ditt mål är att få motståndarens HP till 0.\n2. Attack har en 90% chans att lyckas. Om lyckad gör du 1-20 skada på motståndaren.\n3. Försvar har en 50% chans att lyckas. Om lyckad, halverar du motståndarens attack, \noch gör att dom inte kan röra sig nästa runda.\n");
                    nr--;
                    break;
                    default:
                    System.out.println("Du skrev in ett ogitligt tal. Försök igen.");
                    System.out.println();
                    break;
                }
            }else{
                load();
                System.out.println("Du kan inte röra dig denna runda");
                försvar2=0;
            }


          
            /* --------------------------------------------------------------------------------------
             * MOTSTÅNDAREN
             ----------------------------------------------------------------------------------------*/

            if(svar!=3){                                                //Om användaren inte valde info
                int val1 = tärning.nextInt(6);
                
                if(försvar1==0){                                              //Om användarens försvar inte lyckades
                    
                    if(val1==0){                                                //FÖRSVAR
                        System.out.println("\nMotståndaren försvarar...");
                        int missM2 = tärning.nextInt(2);
                        
                        if(missM2==0){                                          //Försvar misslyckas
                            System.out.println("försvaret misslyckades!");
                            HP2-=attack1;
                        }else{                                                  //Försvar lyckas
                            System.out.println("försvaret lyckades!");
                            attack1 /= 2; 
                            System.out.println("Du gjorde totalt "+attack1+" skada!");
                            HP2-=attack1;
                            försvar2 = 1;
                            
                        }
                    }else{                                                      //ATTACK
                        int missM1 = tärning.nextInt(9);
                        
                        if(missM1==0){                                          //Attacken misslyckas
                            attack2 = 0;
                            System.out.println("Din motståndare missar sin attack!");
                            HP2-=attack1;
                        }else{                                                  //Attacken lyckas
                            attack2 = tärning.nextInt(20);
                            attack2++;
                            System.out.println("Din motståndare gör "+attack2+" skada!");
                            HP2-=attack1;
                            HP1-=attack2;
                        }
                    }
                /*-------------------------------------------------------------------------------------
                 * 
                ---------------------------------------------------------------------------------------*/
                }else if(försvar1==3){                                                //Rundan efter användarens försvar lyckas
                    System.out.println("Motståndaren kan inte röra dig denna runda");
                    HP2-=attack1;
                    försvar1=0;
                }else if(försvar1==1){                                                //Om användarens försvar lyckades
                    
                    if(val1==0){                                                //Om motståndaren valde försvar
                        System.out.println("Motståndaren försvarar");
                        försvar1=0;
                    }else{                                                      //Om moståndaren valde attack
                        int missM1 = tärning.nextInt(9);
                        
                        if(missM1==0){                                          //Attacken misslyckas
                            attack2 = 0;
                            System.out.println("Din motståndare missar sin attack!");
                            HP2-=attack1;
                        }else{                                                  //Attacken lyckas
                            attack2 = tärning.nextInt(20);
                            attack2++;
                            attack2/=2;
                            HP1-=attack2;
                            HP2-=attack1;
                            System.out.println("Din motståndare gör "+attack2+" skada!");
                        }
                    }

                    if(försvar1!=0){
                        försvar1=3;           //Gör att motståndaren inte kan göra något nästa runda.
                    }
                }


                /*-------------------------------------------------------------------------------------
                 * HÄLSA
                ---------------------------------------------------------------------------------------*/

                if(HP1<=0 && HP1<HP2){                                          //FÖRLORADE
                    System.out.println("Du Förlorade!");  
                    totaltPoäng2++;
                }else if(HP2<=0 && HP2<HP1){                                    //VANN
                    System.out.println("Du Vann!");
                    totaltPoäng1++;
                }else if(HP1==HP2 && HP1<=0){                                   //LIKA
                    System.out.println("Det blev lika!");
                    totaltPoäng1++;
                    totaltPoäng2++;
                }
            }

            /*-------------------------------------------------------------------------------------
             * SPELA IGEN
            ---------------------------------------------------------------------------------------*/
     
            if(HP1<=0 || HP2<=0){       
            
                int i=0;
                do{
            System.out.println("\nVill du spela igen?");
            String igen = tangentbord.next();

        
            if(igen.equalsIgnoreCase("ja")){
                HP1=150;
                HP2=150;
                nr=0;
                System.out.println("\n----------------------------------");
                System.out.println("\n"+totaltPoäng1+" - "+totaltPoäng2);
                i=1;
            }else if(igen.equalsIgnoreCase("nej")){
                i=1;
                break;
            }else{
                System.out.println("Du skrev in ett ogiltigt svar. Försök igen");
            }
        }while(i==0);
    }

        }
    }
}
