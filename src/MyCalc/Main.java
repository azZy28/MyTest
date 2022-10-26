package MyCalc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

         String maze = "..W..W.....\n" +
                       "....W.W.WWW\n" +
                       "WW.W....W..\n" +
                       ".W.W.....W.\n" +
                       "...WW..W...\n" +
                       "..W........\n" +
                       "...........\n" +
                       "W...W.....W\n" +
                       ".....W....W\n" +
                       ".W.W.....W.\n" +
                       "W...W.W....";

       /* String maze = ".W.\n" +
                      ".W.\n" +
                      "...";
       */

        //String maze = ".";

        int line = 0;

        if (maze.length() < 2) {
            System.out.println("ok");
        }
        else line = maze.indexOf("\n");


        System.out.println(line);
        byte[][] mazeArray = new byte[line][line];
        int x = 0;
        int y = 0;
        mazeArray[0][0] = 1;
        int prevStep = 0;
        int nextStep = 0;

        while (mazeArray[line - 1][line - 1] != 1 || x * y != (line)*(line)) {
            prevStep = nextStep;

            for (y = 0; y < line; y++ ) {
               for (x = 0; x < line; x ++) {

                   if (maze.charAt(line * y + x + y) == 'W' || mazeArray[y][x] == 0);
                   else {

                      // Check left
                      if (x > 0 && maze.charAt(line * y + x + y - 1) != 'W' && mazeArray[y][x - 1] == 0) {
                          mazeArray[y][x - 1] = 1;
                          nextStep++;
                      }

                      // Check Up
                       if (y > 0 && maze.charAt(line * y + x + y - line - 1) != 'W' && mazeArray[y - 1][x] == 0) {
                           mazeArray[y - 1][x] = 1;
                           nextStep++;
                       }

                       // Check Down
                       if (y < line - 1 && maze.charAt(line * y + x + y + line + 1) != 'W' && mazeArray[y + 1][x] == 0) {
                           mazeArray[y + 1][x] = 1;
                           nextStep++;
                       }

                       // Check Right
                       if (x < line - 1 && maze.charAt(line * y + x + y + 1) != 'W' && mazeArray[y][x + 1] == 0) {
                           mazeArray[y][x + 1] = 1;
                           nextStep++;
                       }
                   }
               }
                 System.out.println(Arrays.deepToString(mazeArray));
           }
            if (mazeArray[line - 1][line - 1] == 1) {
                System.out.println("Success" + x + "  " + y);
                System.out.println("Prev step " + prevStep + "Next Step  " + nextStep + "  X: " + x + "  Y " + y);
                break;
            }
            else if (nextStep == prevStep) {
                System.out.println("No Exit");
                break;
            }

        }
    }
}

