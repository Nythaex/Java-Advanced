package PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Rectangle rectangle=readRectangle(reader.readLine().split("\\s+"));
        int pointsCount = Integer.parseInt(reader.readLine());
        System.out.println(checkpoints(pointsCount,rectangle,reader));
    }

    private static String checkpoints(int pointsCount,Rectangle rectangle,BufferedReader reader) throws IOException {
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i <pointsCount; i++) {
            String []tokens=reader.readLine().split("\\s+");
         builder.append(rectangle.contains(readPoint(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]))));
         builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    private static Point readPoint(int first,int second) {
        return new Point(first,second);
    }

    private static Rectangle readRectangle(String[] tokens) {
        return new Rectangle(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));
    }
}
