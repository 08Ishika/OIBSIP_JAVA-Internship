import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumGuess extends JFrame{
    final private Font f= new Font("Times New Roman",Font.BOLD,20);
    Cursor cur = new Cursor(Cursor.HAND_CURSOR);
    JTextField t1;
    JLabel l1, l2, l3, l4,l5,l6,l7,l8;
    JButton b1;
    int num;
    
       NumGuess() {
            l1 = new JLabel("<html><center><h1><font color='red'>Welcome to the Number Guessing Game!</font></h1></center></html>");
            l1.setHorizontalAlignment(JLabel.CENTER);
            l1.setOpaque(true);
            l1.setBackground(new Color(255, 226, 242));
            l1.setFont(new Font("Monospaced",Font.BOLD,20));
            l1.setBounds(0, 0, 820, 60);
            
            l2 = new JLabel("<html><center>A Number between 1 and 100 will be generated<br>when guess button is clicked</center></html>");
            l2.setHorizontalAlignment(JLabel.CENTER);
            l2.setFont(new Font("Monospaced",Font.BOLD,20));
            l2.setBounds(10, 100, 800, 60);

            l3 = new JLabel("You have to guess the number");
            l3.setHorizontalAlignment(JLabel.CENTER);
            l3.setFont(new Font("Monospaced",Font.BOLD,20));
            l3.setBounds(10, 170, 800, 30);

            l4 = new JLabel("<html><center>You will get <font color='#E49B0F'>10 attemps</font> to guess the number.<br>Your initial Score will be <font color='green'>100 Points</font> and with each wrong attempts <font color='red'>5 Points</font> will be deducted<center></html>");
            l4.setHorizontalAlignment(JLabel.CENTER);
            l4.setFont(new Font("Monospaced",Font.BOLD,20));
            l4.setBounds(10, 200, 800, 100);

            JButton b1 = new JButton("Guess");
            b1.setBounds(340, 320, 120, 30);
            b1.setFont(f);
            b1.setCursor(cur);
            b1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    l5.setText("");
                    l6.setText("");
                    l7.setText("");
                    Random ran = new Random();
                    num = ran.nextInt(100);
                    boolean flag=false;
                    int attempts = 10;
                    int count=0;
                    int points=100;
                    while(flag==false){
                    String n = JOptionPane.showInputDialog(null,"Guess the number");
                    int x = Integer.parseInt(n);
                    if(attempts==0){
                        JOptionPane.showMessageDialog(null,"Out of attempts");
                        l5.setText("You made "+count+" wrong attemps");
                        l6.setText("<html><center><h1><Font color='red'> You Lost! </h1></center></font></html>");
                        break;
                    }
                    if(x>num){
                        JOptionPane.showMessageDialog(null,"The number is lesser than "+x);
                        flag=false;
                        count++;
                        attempts--;
                        points = points-5;
                    }
                    else if(x<num){
                        JOptionPane.showMessageDialog(null,"The number is greater than "+x);
                        flag=false;
                        count++;
                        attempts--;
                        points = points-5;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You guessed it right the number is "+x);
                        flag=true;
                        l5.setText("You made "+count+" wrong attemps");
                        l6.setText("<html><center><h1><Font color='green'> You Guessed the number Right! </h1></center></font></html>");
                        l7.setText("<html><center><h1><Font color='red'> Your Score is: "+points+ " Ponits</h1></center></font></html>");
                    }
                }
                    
                }
            });

            l5 = new JLabel("");
            l5.setHorizontalAlignment(JLabel.CENTER);
            l5.setFont(new Font("Monospaced",Font.BOLD,20));
            l5.setBounds(10, 370, 800, 30);

            l6 = new JLabel("");
            l6.setHorizontalAlignment(JLabel.CENTER);
            l6.setFont(new Font("Monospaced",Font.BOLD,20));
            l6.setBounds(10, 400, 800, 30);

            l7 = new JLabel("");
            l7.setHorizontalAlignment(JLabel.CENTER);
            l7.setFont(new Font("Monospaced",Font.BOLD,20));
            l7.setBounds(10, 430, 800, 30);

            l8 = new JLabel("CopyRight \u00A9 Ishika Bhattacharya | OIBSIP");
            l8.setHorizontalAlignment(JLabel.CENTER);
            l8.setFont(new Font("Monospaced",Font.BOLD,10));
            l8.setBounds(0, 540, 820, 25);
            l8.setBackground(new Color(154,154,154));
            l8.setOpaque(true);




            JPanel pan = new JPanel();
            pan.setBackground(new Color(200,255,224));
            pan.setLayout(null);
            pan.add(l1);
            pan.add(l2);
            pan.add(l3);
            pan.add(b1);
            pan.add(l4);
            pan.add(l5);
            pan.add(l6);
            pan.add(l7);
            pan.add(l8);

        
            

            JFrame frame = new JFrame();
            frame.setTitle("Number Guessing Game");
            frame.setSize(820,600);
            frame.setResizable(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            
            frame.getContentPane().add(pan);
            
        }
        public static void main(String[] args) {
            new NumGuess();
            
        }

    }

