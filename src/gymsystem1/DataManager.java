package gymsystem1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DataManager {

    public void loadAllData(ListClass list) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("gymSystem.data"));
            list.memList = (ArrayList<Member>) is.readObject();
            list.empList = (ArrayList<Employee>) is.readObject();
            list.equipList = (ArrayList<Equipment>) is.readObject();
            list.fitClassList = (ArrayList<FitnessClasses>) is.readObject();
            list.classList = (ArrayList<MemberClass>) is.readObject();
            is.close();
            JOptionPane.showMessageDialog(null, "Data loaded");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Load Aborted");
            e.printStackTrace();
        }
    }

    public void saveAllData(ListClass list) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("gymSystem.data"));
            os.writeObject(list.memList);
            os.writeObject(list.empList);
            os.writeObject(list.equipList);
            os.writeObject(list.fitClassList);
            os.writeObject(list.classList);
            os.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Save Aborted");
            e.printStackTrace();
        }
    }
}
