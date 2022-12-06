package shapes;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        ShapeIdentifier si = new ShapeIdentifier();
        ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
    
        Scanner scanner = new Scanner(System.in);
        boolean looping = true;
        while(looping) {
            System.out.println("Entered coordinates:");
            for (Coordinate coordinate : coordinates) {
                System.out.println("X: " + coordinate.x() + " | " + "Y: " + coordinate.y() + " | " + "Z: " + coordinate.z());
            }
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("Identified shape: " + si.identify(coordinates));
            System.out.println("[1] - Add coordinate");
            System.out.println("[2] - Identify shape of entered coordinates");
            System.out.println("[3] - Exit");

            String choice = scanner.next();

            if (choice.equals("1")) {
                System.out.println("Enter X:");
                float inputX = scanner.nextFloat();
                System.out.println("Enter Y:");
                float inputY = scanner.nextFloat();
                System.out.println("Enter Z:");
                float inputZ = scanner.nextFloat();
                coordinates.add(new Coordinate(inputX, inputY, inputZ));
            }
            if (choice.equals("2")) {
                System.out.println("Identified shape: " + si.identify(coordinates));
            }
            if (choice.equals("3")) {
                looping = false;
            }
            
        }
        scanner.close();


    }

}
