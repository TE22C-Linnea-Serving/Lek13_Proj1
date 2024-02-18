import java.util.Random;
import java.util.Scanner;


public class App {


    public static void laddar() throws Exception{
        
        System.out.print("\nLaddar");
        
        for(int i=0; i<3; i++){
            System.out.print(".");
            Thread.sleep(300);
        }
        System.out.println("\n\n");
    }

    public static String info(String info) throws Exception{
        laddar();
        System.out.println("\n1. Du börjar med 150 HP. Ditt mål är att få motståndarens HP till 0.\n2. Attack har en 90% chans att lyckas. Om lyckad gör du 1-20 skada på motståndaren.\n3. Försvar har en 50% chans att lyckas. Om lyckad, halverar du motståndarens attack, \noch gör att dom inte kan röra sig nästa runda.\n");
        return info;
    }

    public static void ogiltigtTal(){
        System.out.println("Du skrev in ett ogiltigt svar. Försök igen");
        System.out.println();
    }


    public static void main(String[] args) throws Exception {
                                                                    
        Scanner tangentbord = new Scanner(System.in);
        Random tärning = new Random();
        int[] attack = {0,0};               //Attack
        int[] försvar = {0,0};              //När användaresn[0]- och motståndarens[1] förvsar inte har lyckats
        int[] HP = {150,150};               //Hälsa
        int[] totaltPoäng = {0,0};          //Antal vinster och förluster
        int nr = 0;                         //Antal omgångar

        while(HP[0]>0 && HP[1]>0){
            nr++;

            /*-------------------------------------------------------------------------------------
            *MENY
            ---------------------------------------------------------------------------------------*/
            System.out.println("\n\n\n");
            System.out.println("Omgång "+nr);
            System.out.println("\nMeny:\n1. Attack\n2. Försvar\n3. Info");          
            System.out.println("\nDu har "+HP[0]+" HP\nDin motståndare har "+HP[1]+" HP");
            int svar = tangentbord.nextInt();
            
            /*-------------------------------------------------------------------------------------
             * ANVÄNDAREN
            ---------------------------------------------------------------------------------------*/
            if(försvar[1]==0){
                
                switch(svar){
                    
                    case 1:                                              //ATTACK
                    int missA1 = tärning.nextInt(10);
                    
                    if(missA1==0){  
                        laddar();                                            //Attacken misslyckas
                        System.out.println("\nDin attack missade!");
                        attack[0]=0;
                    }else{                      
                        laddar();                                             //Attacken lyckas
                        attack[0] = tärning.nextInt(20);           
                        attack[0]++;
                        System.out.println("\nDu gör "+attack[0]+" skada!");
                    }
                    break;
                    
                    case 2:                                         //FÖRSVAR
                    int missA2 = tärning.nextInt(2);
                    
                    if(missA2==0){                                          //Försvaret misslyckas
                        laddar();
                        System.out.println("Försvaret misslyckades!");
                        attack[0]=0;
                    }else{                                                  //Försvaret lyckas
                        laddar();
                        System.out.println("Försvaret lyckades!");
                        attack[1]/=2;
                        if(försvar[0]!=3){
                        försvar[0]=1;
                        }else if(försvar[0]==3){
                            försvar[0]=4;
                        }
                    }
                    break;

                    case 3:  
                    info(null);                                      //INFO
                    nr--;
                    break;

                    default:
                    ogiltigtTal();
                    nr--;
                    break;
                }
            }else{
                
                if(svar==3){
                    info(null);
                    nr--;
                }else if(svar==1 || svar==2){
                    laddar();
                    System.out.println("Du kan inte röra dig denna runda");
                    försvar[1]=0;
                    attack[1]=0;
                }else{
                    ogiltigtTal();
                    nr--;
                }
            }

            /* --------------------------------------------------------------------------------------
             * MOTSTÅNDAREN
             ----------------------------------------------------------------------------------------*/
            if(svar==1 || svar==2){                                    //Om användaren inte valde info
                int val1 = tärning.nextInt(6);
                
                if(försvar[0]==0){                                     //Om användarens försvar inte lyckades
                    
                    if(val1==0){                                       //FÖRSVAR
                        System.out.println("\nMotståndaren försvarar...");
                        int missM2 = tärning.nextInt(2);
                        
                        if(missM2==0){                                 //Försvar misslyckas
                            System.out.println("försvaret misslyckades!");
                            HP[1]-=attack[0];
                        }else{                                         //Försvar lyckas
                            System.out.println("försvaret lyckades!");
                            attack[0] /= 2; 
                            System.out.println("Du gjorde totalt "+attack[0]+" skada!");
                            HP[1]-=attack[0];

                            if(svar==1){
                            försvar[1] = 1;
                            } 
                        }
                    }else{                                                      //ATTACK
                        int missM1 = tärning.nextInt(9);
                        
                        if(missM1==0){                                          //Attacken misslyckas
                            attack[1] = 0;
                            System.out.println("Din motståndare missar sin attack!");
                            HP[1]-=attack[0];
                        }else{                                                  //Attacken lyckas
                            attack[1] = tärning.nextInt(20);
                            attack[1]++;
                            System.out.println("Din motståndare gör "+attack[1]+" skada!");
                            HP[1]-=attack[0];
                            HP[0]-=attack[1];
                        }
                    }
                
                }else if(försvar[0]==3){                                                //Rundan efter användarens försvar lyckas
                System.out.println("Motståndaren kan inte röra dig denna runda");
                HP[1]-=attack[0];
                försvar[0]=0;
                }else if(försvar[0]==1){                                                //Om användarens försvar lyckades
                    
                    if(val1==0){                                                //Om motståndaren valde försvar
                        System.out.println("Motståndaren försvarar");
                        försvar[0]=0;
                    }else{                                                      //Om moståndaren valde attack
                        int missM1 = tärning.nextInt(9);
                        
                        if(missM1==0){                                          //Attacken misslyckas
                            attack[1] = 0;
                            System.out.println("Din motståndare missar sin attack!");
                        }else{                                                  //Attacken lyckas
                            attack[1] = tärning.nextInt(20);
                            attack[1]++;
                            attack[1]/=2;
                            HP[0]-=attack[1];
                            System.out.println("Din motståndare gör "+attack[1]+" skada!");
                        }
                        försvar[0]=3;           //Gör att motståndaren inte kan göra något nästa runda.
                    }
                }else if(försvar[0]==4){        //Om användares försvar lyckas två gånger i rad
                    försvar[0]=3;
                    attack[1]=0;
                    System.out.println("Motståndaren kan inte röra dig denna runda");
                }
                

                /*-------------------------------------------------------------------------------------
                 * HÄLSA
                ---------------------------------------------------------------------------------------*/
                if(HP[0]<=0 && HP[0]<HP[1]){                                          //FÖRLORADE
                    System.out.println("Du Förlorade!");  
                    totaltPoäng[1]++;
                }else if(HP[1]<=0 && HP[1]<HP[0]){                                    //VANN
                    System.out.println("Du Vann!");
                    totaltPoäng[0]++;
                }else if(HP[0]==HP[1] && HP[0]<=0){                                   //LIKA
                    System.out.println("Det blev lika!");
                    totaltPoäng[0]++;
                    totaltPoäng[1]++;
                }
                
                /*-------------------------------------------------------------------------------------
                * SPELA IGEN
                ---------------------------------------------------------------------------------------*/
                if(HP[0]<=0 || HP[1]<=0){       
                    int i=0;

                    do{
                        System.out.println("\nVill du spela igen?");
                        String igen = tangentbord.next();
                        
                        if(igen.equalsIgnoreCase("ja")){
                            HP[0]=150;
                            HP[1]=150;
                            nr=0;
                            System.out.println("\n----------------------------------");
                            System.out.println("\n"+totaltPoäng[0]+" - "+totaltPoäng[1]);
                            i=1;
                        }else if(igen.equalsIgnoreCase("nej")){
                            i=1;
                            break;
                        }else{
                            ogiltigtTal();
                        }
                    }while(i==0);
                }
            }
        }
    }
}