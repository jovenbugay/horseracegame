
package horseracegame;

import java.util.Scanner;
import java.util.InputMismatchException;



public class HorseRaceGame {

    static Scanner i = new Scanner(System.in);
    static int bet = 0;
    static Horse h1 = new Horse(1);
    static Horse h2 = new Horse(2);
    static Horse h3 = new Horse(3);
    static Horse h4 = new Horse(4);
    static Horse[] winningOrder;
    public static void main(String[] args) {
        Horse[] horsey = new Horse[4];
        try {
            System.out.println("Select a Horse you want to place your bet on(1,2,3, or 4): ");
            bet = i.nextInt();
            horsey = checkTheFastest(h1, h2, h3, h4);

            if (bet == horsey[0].id) {
                System.out.println("YOU WIN!");
                for (int horsenumber = 0; horsenumber < 4; horsenumber++) {
                    System.out.println(horsenumber­ + 1 + ":" + horsey[horsenumber].id + " SPEED " + horsey[horsenumber].speed);
                }
            } else if (bet != 1&& bet !=2 && bet!=3 && bet!=4 && bet>4) {
                throw new InvalidNumberHorseException();
            } else {
                System.out.println("YOU LOSE!");
                for (int horsenumber = 0; horsenumber < 4; horsenumber++) {
                    System.out.println(horsenumber­ + 1 + ":" + horsey[horsenumber].id + " SPEED " + horsey[horsenumber].speed);
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid Input: Please try running the program again");
        } catch (Exception e) {
            System.out.println("Error: Please Input a Valid Horse Number");
        }
        
    }
    //Horse Rankings
    public static Horse[] checkTheFastest(Horse... horses) {
        int[] ranking = {3, 3, 3, 3};
        for (int place = 0; place < 4; place++) {
            if (horses[place].speed > horses[0].speed) {
                ranking[place] -= 1;
            }
            if (horses[place].speed > horses[1].speed) {
                ranking[place] -= 1;
            }
            if (horses[place].speed > horses[2].speed) {
                ranking[place] -= 1;
            }
            if (horses[place].speed > horses[3].speed) {
                ranking[place] -= 1;
            }
        }
        Horse[] winningOrder = new Horse[4];
        for (int a = 0; a < 4; a++) {
            winningOrder[ranking[a]] = horses[a];
        }
        return winningOrder;
    }

      

    static class Horse {

        int speed = 0;
        int id = 0;

        public Horse(int id) {
            this.id = id;
            startRacing();

        }

        public void startRacing() {
            speed = (int) (Math.random()* 99);

        }
    }
    }
    

