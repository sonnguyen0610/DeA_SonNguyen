import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Cau2 {
    public static void main(String[] args) {
        String regex= "\\b[A-Za-z]+\\w*@([A-ZA-z]+\\.[A-Za-z]{2,})(\\\\.[A-Za-z]{2,})?\\b";
    }

    //doc file
    public static void listSTHaveGmail(String path) {
        File file = new File(path);
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(path);
                DataInputStream dis = new DataInputStream(fis);
                while (dis.available() > 0) {
                    int ID = dis.readInt();
                    String name = dis.readUTF();
                    String email = dis.readUTF();
                    int bonus = dis.readInt();
                    int report = dis.readInt();
                    int app = dis.readInt();
                    double lt = dis.readDouble();
                    if(email)
                    Student outST = new Student(ID, name, email, bonus, report, app, lt);
                    System.out.println(outST);
                }
                dis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("File not exist!");
        }
    }

}
