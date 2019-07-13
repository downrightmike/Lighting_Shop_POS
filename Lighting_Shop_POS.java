        /********************************************************************************************************************
         * Lighting_Shop_POS.java
        * Author: downrightmike
        * 2/10/2019
        * 
        ********************************************************************************************************************/
        import java.util.Scanner;

        public class Lighting_Shop_POS {
        // keyboard is a global variable because it is above main. Notice the static label also. 
          static Scanner keyboard = new Scanner(System.in);
        
        public static void main(String[] args) {
            final   double S_BULB =4.5;
            final   double M_BULB = 7.0;
            final   double L_BULB = 9.0;
            final   double DISCOUNT_10 =0.1;
            final   double DISCOUNT_15 = 0.15;
            final   double DISCOUNT_20 = 0.2;
            final   double SHIPPING_LIMIT = 40.0;
            final   double SHIPPING_CHARGE = 5.0;
            final   double FREE_SHIPPING = 0.0;
            final   int S_BULB_LOW = 4;
            final   int S_BULB_HIGH = 6;
            final   int M_BULB_LOW = 7;
            final   int M_BULB_HIGH = 9;
            final   int L_BULB_LOW = 10;
            //final   int L_BULB_HIGH
            String sentinel = "a";
            int smallBulbQuantity = 0;
            int mediumBulbQuantity = 0;
            int largeBulbQuantity = 0;
            double thisOrderDiscount = 0.0;

            displayWelcomeMessage();      
            
            System.out.println("===========LIST OF PRODUCTS============++++=");
            System.err.println("ID ------ Description ---------------- Price");
            System.out.println("sbulb      Small 13 Watt bulb         $ 1.50");
            System.out.println("mbulb      Medium 18 Watt bulb        $ 3.00");
            System.out.println("lbulb      Large 23 Watt bulb         $ 4.00");
            System.out.println("");
            
            //Start of the do loop
            do{
            String bulbSelection = IR4.getString("Which product would you like to purchase? Please enter the product ID, or q to quit.");

            if(bulbSelection.equals("q")){sentinel = "q";}
            
            String bulbQuantity = IR4.getString("How many would you like to purchase?");
            if(bulbSelection. equals("sbulb")){
                smallBulbQuantity = smallBulbQuantity + Integer.parseInt(bulbQuantity);
            }
            if(bulbSelection. equals("mbulb")){
                mediumBulbQuantity = mediumBulbQuantity +  Integer.parseInt(bulbQuantity);
            }
            if(bulbSelection. equals("lbulb")){
                largeBulbQuantity = largeBulbQuantity +  Integer.parseInt(bulbQuantity);
            }
            //calc quantity discount
            if( Integer.parseInt(bulbQuantity) >= 10){
                //discount = 20
                thisOrderDiscount = DISCOUNT_10;
            }else if( Integer.parseInt(bulbQuantity) < 10 &&  Integer.parseInt(bulbQuantity) >= 7){
                //discount = 15
                thisOrderDiscount = DISCOUNT_15;
            }else if( Integer.parseInt(bulbQuantity) < 7 &&  Integer.parseInt(bulbQuantity) >= 4){
                //discount = 10
                thisOrderDiscount = DISCOUNT_20;
            }else{
                //discount = none
                thisOrderDiscount = thisOrderDiscount;
            }//end of quantity calcs

            if(smallBulbQuantity > 0) {
            displayResult(bulbSelection, smallBulbQuantity, thisOrderDiscount);  //Isolate the program output in its own module whenever possible
            }
            if(mediumBulbQuantity > 0){
                displayResult (bulbSelection, mediumBulbQuantity, thisOrderDiscount);  //Isolate the program output in its own module whenever possible
            }
            if(largeBulbQuantity > 0){
                displayResult (bulbSelection, largeBulbQuantity, thisOrderDiscount);  //Isolate the program output in its own module whenever possible
            }
        }while(!sentinel. equals("q"));


            displayGoodbyeMessage();  //Let the user know the program is finished
            IR4.closeScanner();       //It's good programming practice to close the keyboard
        }//end of main
        
        //-----------------------------------------------------------------------------------------------------------------
        
          static void displayWelcomeMessage() {
            System.out.println("***********************************************************************");
            System.err.println("          Welcome to the Just Cycling bulbs Ordering Program");
            System.out.println("");
            System.out.println("This program calculates the cost to the customer for their order.");
            System.out.println("Discounts and Shipping rates may apply.");
            System.out.println("***********************************************************************");
        }

          static void displayResult(String bulbSelection, int bulbQuantity, double orderDiscount) {  
            double orderTotal = 0.0;
            double discountTotal = 0.0;
            if(bulbSelection.equals("sbulb")){
                double localSbulbPrice = calcPrice(bulbSelection,  Integer.parseInt(bulbQuantity), orderDiscount);
                System.out.println("Product 1: small bulb unit price :  $ " + bulbSelection + " -quantity:  " + bulbQuantity + " - extended price: $  " + localSbulbPrice); 
                orderTotal = orderTotal + (bulbSelection *  Integer.parseInt(bulbQuantity));
            }
            if(bulbSelection.equals("mbulb")){
                double localMbulbPrice = calcPrice(bulbSelection,  Integer.parseInt(bulbQuantity), orderDiscount);
                System.out.println("Product 1: small bulb unit price :  $ " + bulbSelection + " -quantity:  " + bulbQuantity + " - extended price: $  " + localMbulbPrice); 
                orderTotal = orderTotal + (bulbSelection *  Integer.parseInt(bulbQuantity));
            }
            if(bulbSelection.equals("lbulb")){
                double localLbulbPrice = calcPrice(bulbSelection,  Integer.parseInt(bulbQuantity), orderDiscount);
                System.out.println("Product 1: small bulb unit price :  $ " + bulbSelection + " -quantity:  " + bulbQuantity + " - extended price: $  " + localLbulbPrice); 
                orderTotal = orderTotal + (bulbSelection *  Integer.parseInt(bulbQuantity));
            }
            if(sentinel.equals("q")){
                discountTotal = orderTotal * orderDiscount;
                //Print out receipt
                /*Price of products: $ 36.00
                -10% Discount: $ 3.60
                =Net purchase amount: $ 32.40
                +Shipping Cost: $ 5.00
                =Total: $ 37.40  */
                System.out.println("Price of products: $ " + orderTotal);
                System.out.println( "-"+ (discountTotal * 100) + "Discount: $ " + discountTotal);
                System.out.println("=Net purchase amount: $ " + orderTotal);
                System.out.println("Price of products: $ " + orderTotal);
                System.out.println("Price of products: $ " + orderTotal);


                //reset sentinel
                if(sentinel.equals("q")){ 
                    String localSentinelCheck = IR4.getString("Do you want to take another customer's order?");
                    if(localSentinelCheck. equals("n")){
                        System.out.println("Come back real soon!");
                    }else{sentinel = "a";}
                }
            }
            
        }
          static void calcPrice(String bulbSelection, int bulbQuantity, double orderDiscount) {
            //math stuff

            if(bulbSelection.equals("sbulb")){
                double sbulbPrice = bulbSelection * bulbQuantity * orderDiscount;
                return sbulbPrice;
            }//end of sbulb
            if(bulbSelection.equals("mbulb")){
                double mbulbPrice = bulbSelection * bulbQuantity * orderDiscount;
                return mbulbPrice;
            }
            if(bulbSelection.equals("lbulb")){
                double lbulbPrice = bulbSelection * bulbQuantity * orderDiscount;
                return lbulbPrice;
            }
        }   
        
          static void displayGoodbyeMessage() {
            System.out.println("");
            System.out.println("---Program complete---");
        }   
        
        }//end of class 