import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ToDo {
    public static void main(String[] args) {
        // Frame setup
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(245, 245, 245)); // Light grey

        // Title
        JLabel title = new JLabel("TO - DO LIST");
        title.setBounds(180, 30, 300, 60);
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        title.setForeground(new Color(33, 33, 33));

        // Input field
        JTextField task = new JTextField();
        task.setBounds(60, 120, 350, 40);
        task.setFont(new Font("SansSerif", Font.PLAIN, 18));
        task.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        task.setBackground(Color.WHITE);

        // Add button
        JButton add = new JButton("ADD");
        add.setBounds(430, 120, 90, 40);
        add.setFont(new Font("SansSerif", Font.BOLD, 16));
        add.setBackground(new Color(33, 150, 243));
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add.setBorder(BorderFactory.createEmptyBorder());

        final int[] Yposition = {200};

        add.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String text = task.getText().trim();
                if (text.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a task.","Error",JOptionPane.ERROR_MESSAGE);
                } else {
                    // Panel for each task with border
                    JPanel taskPanel = new JPanel();
                    taskPanel.setLayout(null);
                    taskPanel.setBounds(50, Yposition[0], 480, 50);
                    taskPanel.setBackground(Color.WHITE);
                    taskPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

                    // Task label
                    JLabel ListItem = new JLabel(text);
                    ListItem.setBounds(10, 10, 360, 30);
                    ListItem.setFont(new Font("SansSerif", Font.BOLD, 20));
                    ListItem.setForeground(new Color(33, 33, 33));

                    // Checkbox
                    JCheckBox check = new JCheckBox();
                    check.setBounds(400, 10, 30, 30);
                    check.setBackground(Color.WHITE);
                    check.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent e) {
                           
                            if (check.isSelected()) {
                               
                                ListItem.setForeground(Color.GRAY);
                                taskPanel.setBackground(new Color(169, 169, 169));
                                check.setBackground(new Color(169, 169, 169));
                            } else {
                                
                                ListItem.setForeground(new Color(33, 33, 33));
                                taskPanel.setBackground(Color.WHITE);
                                check.setBackground(Color.WHITE);
                            }
                           
                        }
                    });

                    taskPanel.add(ListItem);
                    taskPanel.add(check);
                    frame.add(taskPanel);

                    Yposition[0] += 60;

                    frame.repaint();
                    frame.revalidate();
                    task.setText("");
                }
            }
        });

        frame.add(add);
        frame.add(task);
        frame.add(title);
        frame.setVisible(true);
    }
}
