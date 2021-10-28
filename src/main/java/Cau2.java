import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cau2 {
    public static void main(String[] args) {
        String regex= "\\b[A-Za-z]+\\w*@([A-ZA-z]+\\.[A-Za-z]{2,})(\\\\.[A-Za-z]{2,})?\\b";
        String path = "data.csv";
        listSTHaveGmail(path);
    }

    //doc file
    public static void listSTHaveGmail(String path) {
        File file = new File(path);
        Pattern p = Pattern.compile("\\b[a-zA-Z]\\w*(@{1})gmail(\\.[a-z]{2,}){1,2}");

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
                    Matcher m = p.matcher(email);
                    if(m.matches()){

                        Student outST = new Student(ID, name, email, bonus, report, app, lt);
                        System.out.println(outST);
                    }
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
