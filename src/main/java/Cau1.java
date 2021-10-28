import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cau1 {
    public static void main(String[] args) {
        Student[] listST = new Student[]{
                new Student(18424005, "Đặng Văn Thường", "dvthuong@gmail.com", 0, 0, 0, 4.5),
                new Student(18424005, "Nguyễn Ngọc Châu", "dvthuong@gmail.com", 0, 0, 0, 5.0),
                new Student(18424005, "Đặng Văn Ngọc", "dvthuong@gmail.com", 0, 0, 0, 9.1),
                new Student(18424005, "Nguyễn Ngọc Quỳnh", "dvthuong@gmail.com", 0, 0, 0, 2.9),
                new Student(18424005, "Đặng Văn Quý", "dvthuong@gmail.com", 0, 0, 0, 8.5),

                new Student(18424005, "Nguyễn Ngọc Hưng", "dvthuong@gmail.com", 0, 0, 0, 6.0),
                new Student(18424005, "Đặng Văn Hòa", "dvthuong@gmail.com", 0, 0, 0, 4.5),
                new Student(18424005, "Nguyễn Ngọc Hoa", "dvthuong@gmail.com", 0, 0, 0, 7.4),
                new Student(18424005, "Đặng Văn Huy", "dvthuong@gmail.com", 0, 0, 0, 9.2),
                new Student(18424005, "Nguyễn Ngọc Thom", "dvthuong@gmail.com", 0, 0, 0, 4.7),

                new Student(18424005, "Đặng Văn Thường", "dvthuong@gmail.com", 0, 0, 0, 4.5),
                new Student(18424005, "Nguyễn Ngọc Châu", "dvthuong@gmail.com", 0, 0, 0, 5.0),
                new Student(18424005, "Đặng Văn Ngọc", "dvthuong@gmail.com", 0, 0, 0, 9.0),
                new Student(18424005, "Nguyễn Ngọc Quỳnh", "dvthuong@gmail.com", 0, 0, 0, 2.8),
                new Student(18424005, "Đặng Văn Quý", "dvthuong@gmail.com", 0, 0, 0, 8.5),

                new Student(18424005, "Nguyễn Ngọc Hưng", "dvthuong@gmail.com", 0, 0, 0, 6.3),
                new Student(18424005, "Đặng Văn Hòa", "dvthuong@gmail.com", 0, 0, 0, 4.5),
                new Student(18424005, "Nguyễn Ngọc Hoa", "dvthuong@gmail.com", 0, 0, 0, 7.4),
                new Student(18424005, "Đặng Văn Huy", "dvthuong@gmail.com", 0, 0, 0, 9.9),
                new Student(18424005, "Nguyễn Ngọc Thom", "dvthuong@gmail.com", 0, 0, 0, 4.3)
        };
        String path = "data.csv";
        //ghi dssv vào file
//        writeStudentToFile(path, listST);
//        System.out.println("Done");
        //doc dssv tu file
//        readStudentFromFile(path);
        //trả về dssv
//        System.out.println(returnListStudent(path));
        //lay 10 sv co diem ly thuyet cao nhat
//        System.out.println(list10maxLT(returnListStudent(path)));
        //liet ke 10 sv co diem tong ket thap nhat
//        System.out.println(list10MinTotalMark(returnListStudent(path)));
        //Save to output
        String output="output.csv";
//        saveStudentWithMark(output,returnListStudent(path));
//Hiển thị
        sprintConsole(path);
    }

    //ghi file
    public static void writeStudentToFile(String path, Student[] listStudent) {
        File file = new File(path);
        if (file.exists()) {
            try {
                FileOutputStream fos = new FileOutputStream(path);
                DataOutputStream dos = new DataOutputStream(fos);
                for (Student st : listStudent) {
                    dos.writeInt(st.getID());
                    dos.writeUTF(st.getName());
                    dos.writeUTF(st.getEmail());
                    dos.writeInt(st.getBonus());
                    dos.writeInt(st.getReport());
                    dos.writeInt(st.getApp());
                    dos.writeDouble(st.getLt());
                }
                dos.flush();
                dos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
                writeStudentToFile(path, listStudent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //doc file
    public static void readStudentFromFile(String path) {
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

    //return list student
    public static List<Student> returnListStudent(String path) {
        List<Student> st = new ArrayList<Student>();
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
                    Student outST = new Student(ID, name, email, bonus, report, app, lt);
                    st.add(outST);
                }
                dis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("File not exist!");
        }
        return st;

    }

    //sắp xếp list giam dan
    public static void sortListST(List<Student> listST) {
        int n = listST.size();
        Student temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listST.get(i).getLt() < listST.get(j).getLt()) {
                    temp = listST.get(j);
                    listST.set(j, listST.get(i));
                    listST.set(i, temp);
                }
            }
        }
    }

    //tim 10 sv có diem ly thuyet lon nhat
    public static List<Student> list10maxLT(List<Student> listST) {
        List<Student> listSTMaxLT = new ArrayList<>();
        if (listST.size() == 0) {
            System.out.println("List is empty");
        } else {
            sortListST(listST);
            for (int i = 0; i < 10; i++) {
                listSTMaxLT.add(listST.get(i));
            }
        }
        return listSTMaxLT;
    }

    public static double totalMark(Student st) {
        double total;
        total = Math.ceil((st.getBonus() * 0.1 + st.getReport() * 0.3 + st.getApp() * 0.15 + st.getLt() * 0.45) * 100 / 100);
        return total;
    }


    //sap xep diem tang dan
    public static void sortToMark(List<Student> listST) {
        int n = listST.size();
        List<Student> listSTMinTotal = new ArrayList<>();
        Student temp;
        if (listST.size() == 0) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (totalMark(listST.get(i)) > totalMark(listST.get(j))) {
                        temp = listST.get(j);
                        listST.set(j, listST.get(i));
                        listST.set(i, temp);
                    }
                }
            }

        }
    }
    public static List<Student> list10MinTotalMark(List<Student> listST) {
        List<Student> listSTMaxLT = new ArrayList<>();
        if (listST.size() == 0) {
            System.out.println("List is empty");
        } else {
            sortToMark(listST);
            for (int i = 0; i < 10; i++) {
                listSTMaxLT.add(listST.get(i));
            }
        }
        return listSTMaxLT;
    }
    //luu file có thêm diem tong ket
    public static void saveStudentWithMark(String path,List<Student>listST){
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
                FileOutputStream fos = new FileOutputStream(path);
                DataOutputStream dos = new DataOutputStream(fos);
                for (Student st : listST) {
                    dos.writeInt(st.getID());
                    dos.writeUTF(st.getName());
                    dos.writeUTF(st.getEmail());
                    dos.writeInt(st.getBonus());
                    dos.writeInt(st.getReport());
                    dos.writeInt(st.getApp());
                    dos.writeDouble(st.getLt());
                    dos.writeDouble(totalMark(st));
                }
                dos.flush();
                dos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public static void sprintConsole(String path) {

    }

}
