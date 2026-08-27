package furniture_management;

import java.io.*;
import java.util.ArrayList;


public class BinaryFileUtility {

    public static void writeFurniture(Furniture furniture){

        try {

            File file = new File("Furniture.bin");

            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos;

            if (file.length() == 0) {
                oos = new ObjectOutputStream(fos);
            } else {
                oos = new AppendableObjectOutputStream(fos);
            }

            oos.writeObject(furniture);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Furniture readFurniture() {

        try {

            FileInputStream fis = new FileInputStream("Furniture.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Furniture furniture = (Furniture) ois.readObject();
            ois.close();
            return furniture;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public static ArrayList<Furniture> readAllFurniture() {

        ArrayList<Furniture> furnitureList = new ArrayList<>();

        try {

            FileInputStream fis = new FileInputStream("Furniture.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {

                try {

                    Furniture furniture = (Furniture) ois.readObject();
                    furnitureList.add(furniture);

                } catch (EOFException e) {

                    break;
                }
            }

            ois.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return furnitureList;
    }
}

