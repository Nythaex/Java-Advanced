package TwentyThree_Oct_TwentyNine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheGarden {
    private static int carrots;
    private static int potatoes;
    private static int lettuce;
    private static int harmed;
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int rows=Integer.parseInt(reader.readLine());
        String [][] garden=new String[rows][];
        for (int i = 0; i < rows; i++) {
            garden[i]=reader.readLine().split("\\s+");
        }
        String command=reader.readLine();
        while (!command.equals("End of Harvest")){
            String []tokens=command.split("\\s+");
            if (checkMatrixRadius(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),garden)){
                switch (tokens[0]){
                    case "Harvest":
                        harvest(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),garden);
                        break;
                    case "Mole":
                        mole(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),garden,tokens[3]);
                        break;
                }

            }
            command=reader.readLine();
        }
        for (int i = 0; i < garden.length; i++) {
            System.out.println(String.join(" ",garden[i]));
        }

        System.out.println("Carrots: "+carrots);
        System.out.println("Potatoes: "+potatoes);
        System.out.println("Lettuce: "+lettuce);
        System.out.println("Harmed vegetables: "+harmed);
    }

    private static void mole(int row, int col, String[][] garden, String move) {
        switch (move){
            case "up":
                for (int i = row; i >=0 ; i-=2) {
                  if (!garden[i][col].equals(" ")){
                      harmed++;
                      garden[i][col]=" ";
                  }
                }
                break;
            case "down":
                for (int i = row; i <garden.length ; i+=2) {
                    if (!garden[i][col].equals(" ")){
                        harmed++;
                        garden[i][col]=" ";
                    }
                }
                break;
            case "right":
                for (int i = col; i <garden[row].length ; i+=2) {
                    if (!garden[row][i].equals(" ")){
                        harmed++;
                        garden[row][i]=" ";
                    }
                }
                break;
            case "left":
                for (int i = col; i >=0 ; i-=2) {
                    if (!garden[row][i].equals(" ")){
                        harmed++;
                        garden[row][i]=" ";
                    }
                }
                break;
        }

    }

    private static void harvest(int row, int col, String[][] garden) {
        String vegeType=garden[row][col];
        switch (vegeType){
            case "C":
                carrots++;
                break;
            case "L":
                lettuce++;
                break;
            case "P":
                potatoes++;
                break;
        }
        garden[row][col]=" ";
    }

    private static boolean checkMatrixRadius(int row,int col,String [][] matrix){
        return row<matrix.length&&row>=0&&col<matrix[row].length&&col>=0;
    }
}
