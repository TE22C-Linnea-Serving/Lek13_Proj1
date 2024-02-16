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
                                                                    
        Scanner tangentbord = new Scanner(System.in);
        Random tärning = new Random();
        int attack1 = 0;        //Användarens attack
        int attack2 = 0;        //Motståndarens attack  
        int f1=1;               //När motståndarens försvar inte lyckas
        int f2=1;               //När användarens försvar inte lyckas
        int HP1 = 150;
        int HP2 = 150;
        int nr = 0;             //Antal omgångar
        int totalScore1 = 0;    //Användarens antal vinster
        int totalScore2 = 0;    //Motståndarens antal vinster

        System.out.println(totalScore1);
        
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
                if(svar==1){                                                //ATTACK
                    int miss1 = tärning.nextInt(10);
                    
                    if(miss1==0){  
                        load();                                             //Attacken misslyckas
                        System.out.println("\nDin attack missade!");
                        attack1 = 0;
                    }else{                      
                        load();                                             //Attacken lyckas
                        attack1 = tärning.nextInt(20);           
                        attack1++;
                        System.out.println("\nDu gör "+attack1+" skada!");
                    }
                }else if(svar==2){                                          //FÖRSVAR
                    int missAF = tärning.nextInt(2);
                    
                    if(missAF==0){                                          //Försvaret misslyckas
                        load();
                        System.out.println("Försvaret misslyckades!");
                        attack1=0;
                    }else{                                                  //Försvaret lyckas
                        load();
                        System.out.println("Försvaret lyckades!");
                        attack2/=2;
                        f2=0;
                    }
                }else if(svar==3){                                          //INFO
                    load();
                    System.out.println("\n1. Du börjar med 150 HP. Ditt mål är att få motståndarens HP till 0.\n2. Attack har en 90% chans att lyckas. Om lyckad gör du 1-20 skada på motståndaren.\n3. Försvar har en 50% chans att lyckas. Om lyckad, halverar du motståndarens attack, \noch gör att dom inte kan röra sig nästa runda.\n");
                    nr--;
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
            if(svar!=3){                                                //Om användaren inte valde info
                int val1 = tärning.nextInt(6);
                
                if(f2==1){  //Om användarens försvar inte lyckades
                    
                    if(val1==0){                                                //FÖRSVAR
                        System.out.println("\nMotståndaren försvarar...");
                        int missMf = tärning.nextInt(2);
                        
                        if(missMf==0){                                          //Försvar misslyckas
                            System.out.println("försvaret misslyckades!");
                            HP2-=attack1;
                        }else{                                                  //Försvar lyckas
                            System.out.println("försvaret lyckades!");
                            attack1 /= 2; 
                            System.out.println("Du gjorde totalt "+attack1+" skada!");
                            HP2-=attack1;
                            
                            if(svar==1){
                                f1 = 0;
                            }
                        }
                    }else{                                                      //ATTACK
                        int missMa = tärning.nextInt(9);
                        
                        if(missMa==0){                                          //Attacken misslyckas
                            attack2 = 0;
                            System.out.println("Din motståndare missar sin attack!");
                            HP2-=attack1;
                        }else{                                                  //Attacken lyckas
                            attack2 = tärning.nextInt(20);
                            System.out.println("Din motståndare gör "+attack2+" skada!");
                            HP2-=attack1;
                            HP1-=attack2;
                        }
                    }
                }else if(f2==3){                                                //Rundan efter användarens försvar lyckas
                    System.out.println("Motståndaren kan inte röra dig denna runda");
                    HP2-=attack1;
                    f2=1;
                }else if(f2==0){                                                //Om användarens försvar lyckades
                    
                    if(val1==0){                                                //Om motståndaren valde försvar
                        System.out.println("Motståndaren försvarar");
                        f2=1;
                    }else{                                                      //Om moståndaren valde attack
                        int missMa = tärning.nextInt(9);
                        
                        if(missMa==0){                                          //Attacken misslyckas
                            attack2 = 0;
                            System.out.println("Din motståndare missar sin attack!");
                            HP2-=attack1;
                        }else{                                                  //Attacken lyckas
                            attack2 = tärning.nextInt(20);
                            attack2/=2;
                            HP1-=attack2;
                            HP2-=attack1;
                            System.out.println("Din motståndare gör "+attack2+" skada!");
                        }
                    }

                    if(f2!=1){
                        f2=3;
                    }
                }
                
                //Hälsa
                if(HP1<=0 && HP1<HP2){                                          //FÖRLORADE
                    System.out.println("Du Förlorade!");  
                    totalScore2++;
                }else if(HP2<=0 && HP2<HP1){                                    //VANN
                    System.out.println("Du Vann!");
                    totalScore1++;
                }else if(HP1==HP2 && HP1<=0){                                   //LIKA
                    System.out.println("Det blev lika!");
                    totalScore1++;
                    totalScore2++;
                }
            }
            if(HP1<=0 || HP2<=0){
            System.out.println("\nVill du spela igen?");
            String again = tangentbord.next();

            if(again.equalsIgnoreCase("ja")){
                HP1=150;
                HP2=150;
                nr=0;
                System.out.println("\n----------------------------------");
                System.out.println("\n"+totalScore1+" - "+totalScore2);
            }else{
                break;
            }
        }

        }
    }
}
