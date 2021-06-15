package PetClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Map<String,Pet> pets = new HashMap<String,Pet>();
        Map<String,Clinic> clinics= new HashMap<String,Clinic>();
        for (int i = 0; i < count; i++) {
            String[] token = reader.readLine().split("\\s+");
            switch (token[0]) {
                case "Create":
                    switch (token[1]) {
                        case "Pet":
                            Pet pet = new Pet(token[2],token[4],Integer.parseInt(token[3]));
                            pets.put(token[2],pet);
                            break;
                        case "Clinic":
                            if (Integer.parseInt(token[3])%2==0){
                                System.out.println("Invalid Operation!");
                            }else {
                                Clinic clinic=new Clinic(token[2],Integer.parseInt(token[3]));
                                clinics.put(token[2],clinic);
                            }
                            break;
                    }
                    break;
                case "Add":
                    System.out.println(clinics.get(token[2]).add(pets.get(token[1])));
                    break;
                case "Release":
                    System.out.println(clinics.get(token[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(token[1]).hasEmptyRooms());
                    break;
                case "Print":
                    switch (token.length) {
                        case 2:
                            clinics.get(token[1]).print();
                            break;
                        case 3:
                            clinics.get(token[1]).print(Integer.parseInt(token[2]));
                            break;
                    }
                    break;
            }
        }
    }
}
