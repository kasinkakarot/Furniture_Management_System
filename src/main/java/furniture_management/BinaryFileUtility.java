package furniture_management;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class BinaryFileUtility {

    private static void writeFurniture(Furniture furniture){

        try {

            FileOutputStream fos = new FileOutputStream("Furniture.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(furniture);

        } catch (Exception e) {
        }

    }
}
