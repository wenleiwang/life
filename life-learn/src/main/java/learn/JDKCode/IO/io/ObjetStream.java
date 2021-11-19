package learn.JDKCode.IO.io;

import java.io.*;

/**
 * @author WangWenLei
 * @DATE: 2020/9/23
 **/
public class ObjetStream {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("D:/learn/User.txt");
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(new User(1L,"wwl","ww","25","ww",true));
            oos.writeObject(new User(1L,"gt","ww","25","ww",true));
            oos.writeObject(new User(1L,"st","ww","25","ww",true));
            oos.writeObject(new User(1L,"zw","ww","25","ww",true));

            ois = new ObjectInputStream(new FileInputStream(file));
            for(int i = 0 ; i < 4 ; i++){
                System.out.println(ois.readObject().toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
