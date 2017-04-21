/*Window.java*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

public class Window {
    JTextArea textArea;
    JTextArea ta;
    JTextField key;
    JComboBox comboBox;
    String[] items = {
            "UTF-8",
            "KOI8",
            "CP437",
            "CP850",
            "ISCII"
    };

    public Window() {
        JFrame frame = new JFrame("YouXOR");
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 20, 20));

        textArea = new JTextArea("Input", 5, 20);
        panel.add(textArea);

        ta = new JTextArea(5,20);
        ta.setEditable(false);
        panel.add(ta);

        JPanel panel2 = new JPanel(new GridLayout(1,3,20, 0 ));
        key = new JTextField("KEY", 4);
        panel2.add(key);

        JButton button = new JButton("?????????");
        button.addActionListener(new Action());
        panel2.add( button);

        comboBox = new JComboBox(items);

        panel2.add(comboBox);

        mainPanel.add(panel);
        mainPanel.add(panel2);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add("Center",mainPanel);
        frame.setSize(885,553);
        frame.setResizable(false);
    }
    class Action implements ActionListener {
        int count = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (key.getText().equals("")) {
                JOptionPane.showConfirmDialog(null,"Please, fill the key-area","Error!",JOptionPane.PLAIN_MESSAGE);
            }
            else {
                byte[] k = (key.getText().getBytes());
                byte[] arr = (textArea.getText().getBytes());
                int n = arr.length;
                for (int i = 0; i < n; i++) {
                    byte j = bytes(k);
                    arr[i] = (byte) (arr[i] ^ j);
                    count++;
                }
                try {
                    ta.setText(new String(arr, items[comboBox.getSelectedIndex()]));
                } catch (UnsupportedEncodingException exp) {
                }
            }
            count = 0;
        }
        public byte bytes(byte[] arr) {
            int n = arr.length - 1;
            if (count <= n)
            return arr[count];
            else {
                count = 0;
                return arr[count];
            }
        }
    }
}
===================================
/*Main*/
public class Main {
    public static void main(String[] args) {
        new Window();
    }
}
========================================

/*step to execute 
gescoe@node13:~/Desktop/cl3_programs/Xor$ javac Window.java 
gescoe@node13:~/Desktop/cl3_programs/Xor$ javac Main.java 
gescoe@node13:~/Desktop/cl3_programs/Xor$ java Main
*/
