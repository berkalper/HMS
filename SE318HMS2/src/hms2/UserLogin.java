package hms2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    private boolean flag=false;


        Scanner scanner = new Scanner(System.in);

        public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblNewLabel = new JLabel("Login");
            lblNewLabel.setForeground(Color.BLACK);
            lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
            lblNewLabel.setBounds(423, 13, 273, 93);
            contentPane.add(lblNewLabel);

            textField = new JTextField();
            textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
            textField.setBounds(481, 170, 281, 68);
            contentPane.add(textField);
            textField.setColumns(10);

            passwordField = new JPasswordField();
            passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
            passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();

                    for (int i = 0; i < Main.customers.size(); i++) {
                        if (userName.equals(Main.customers.get(i).name) && password.equals(Main.customers.get(i).password)) {
                            Main.customerCheck = true;
                            Main.index = i;
                            dispose();
                            UserHome ah = new UserHome();
                            ah.setTitle("Welcome");
                            ah.setVisible(true);
                            flag = true;
                            break;
                            //   UserHome userHome = new UserHome();
                        }
                    }

                    for (int i = 0; i < Main.staff.size(); i++) {
                        if (userName.equals(Main.staff.get(i).name) && password.equals(Main.staff.get(i).password)) {
                            Main.staffCheck = true;
                            Main.indexStaff = i;
                            System.out.println("helal");
                            if (Main.staffCheck)
                                System.out.println("tureeeeee");
                            dispose();
                            UserHome ah = new UserHome();
                            ah.setTitle("Welcome");
                            ah.setVisible(true);
                            flag = true;
                            break;
                            // UserHome userHome = new UserHome();
                        }
                    }


                    if (userName.equals("SerhatUzunbayır") && password.equals("nightshift")) {
                        System.out.println("Please enter key to proceed.");
                        String key = scanner.next();
                        System.out.println("bbbbb");
                        if (key.equals(Manager.getAdminKey()))
                            Main.managerCheck = true;
                        System.out.println("aaaaaa");
                        dispose();
                        UserHome ah = new UserHome();
                        ah.setTitle("Welcome");
                        ah.setVisible(true);
                        flag = true;


                    }

            }
        });
        contentPane.add(btnNewButton);
       // label = new JLabel("");
       // label.setBounds(0, 0, 1008, 562);
       // contentPane.add(label);

    }

    public JButton getBtnNewButton() {
        return btnNewButton;
    }

    public boolean getFlag(){
            return flag;
    }


}