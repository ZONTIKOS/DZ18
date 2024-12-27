import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class UI extends JFrame implements MouseMotionListener {

    private Label label = new Label();
    private Color color = Color.black;
    private int x = 0;
    private int y = 0;
    private int LastX = 0;
    private int LastY = 0;
    private float pencilSize = 5.0f;

    UI() {
        setSize(1280, 720);
        setTitle("Paint");
        addMouseMotionListener(this);
        setLayout(null);
        label.setBounds(20, 20, 200, 50);
        add(label);
        JButton button1 = new JButton("Red");
        button1.setBounds(0, 300, 70, 50);
        button1.setBackground(Color.lightGray);
        button1.addActionListener(e -> {
            color = Color.red;
            label.setText("Color is red");
        });
        add(button1);
        JButton button2 = new JButton("Black");
        button2.setBounds(0, 350, 70, 50);
        button2.setBackground(Color.lightGray);
        button2.addActionListener(e -> {
            color = Color.BLACK;
            label.setText("Color is black");
        });
        add(button2);
        JButton button3 = new JButton("Green");
        button3.setBounds(0, 400, 70, 50);
        button3.setBackground(Color.lightGray);
        button3.addActionListener(e -> {
            color = Color.green;
            label.setText("Color is green");
        });
        add(button3);
        JButton button4 = new JButton("Blue");
        button4.setBounds(70, 300, 70, 50);
        button4.setBackground(Color.lightGray);
        button4.addActionListener(e -> {
            color = Color.blue;
            label.setText("Color is blue");
        });
        add(button4);
        JButton button5 = new JButton("Pink");
        button5.setBounds(70, 350, 70, 50);
        button5.setBackground(Color.lightGray);
        button5.addActionListener(e -> {
            color = Color.pink;
            label.setText("Color is pink");
        });
        add(button5);
        JButton button6 = new JButton("Yellow");
        button6.setBounds(70, 400, 70, 50);
        button6.setBackground(Color.lightGray);
        button6.addActionListener(e -> {
            color = Color.yellow;
            label.setText("Color is yellow");
        });
        add(button6);
        JButton button9 = new JButton("Orange");
        button9.setBounds(0, 450, 70, 50);
        button9.setBackground(Color.lightGray);
        button9.addActionListener(e -> {
            color = Color.orange;
            label.setText("Color is orange");
        });
        add(button9);
        JButton button10 = new JButton("White");
        button10.setBounds(70, 450, 70, 50);
        button10.setBackground(Color.lightGray);
        button10.addActionListener(e -> {
            color = Color.white;
            label.setText("Color is white");
        });
        add(button10);
        JButton button11 = new JButton("Cyan");
        button11.setBounds(0, 500, 70, 50);
        button11.setBackground(Color.lightGray);
        button11.addActionListener(e -> {
            color = Color.CYAN;
            label.setText("Color is pink");
        });
        add(button11);
        JButton button12 = new JButton("Grey");
        button12.setBounds(70, 500, 70, 50);
        button12.setBackground(Color.lightGray);
        button12.addActionListener(e -> {
            color = Color.GRAY;
            label.setText("Color is gray");
        });
        add(button12);
        JButton button7 = new JButton("Square");
        button7.setBounds(0, 575, 100, 50);
        button7.setBackground(Color.GRAY);
        button7.addActionListener(e -> {
            Graphics g = getGraphics();
            g.setColor(color);
            g.fillRect(LastX - 35, LastY - 25, 70, 50);
            label.setText("Square created");
        });
        add(button7);
        JButton button8 = new JButton("Circle");
        button8.setBounds(0, 625, 100, 50);
        button8.setBackground(Color.GRAY);
        button8.addActionListener(e -> {
            Graphics g = getGraphics();
            g.setColor(color);
            g.drawOval(LastX - 35, LastY - 25, 70, 70);
            label.setText("Circle created");
        });
        add(button8);
        JButton button = new JButton("Clear");
        button.setBounds(0, 200, 100, 50);
        button.setBackground(Color.GRAY);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = getGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, 1280, 720);
                label.setText("Clear");
            }
        });
        add(button);

        JButton increaseButton = new JButton("+");
        increaseButton.setBounds(1150, 10, 50, 30);
        increaseButton.setBackground(Color.lightGray);
        increaseButton.addActionListener(e -> {
            pencilSize += 1.0f;
            label.setText("Pencil size: " + pencilSize);
        });
        add(increaseButton);

        JButton decreaseButton = new JButton("-");
        decreaseButton.setBounds(1210, 10, 50, 30);
        decreaseButton.setBackground(Color.lightGray);
        decreaseButton.addActionListener(e -> {
            pencilSize = Math.max(1.0f, pencilSize - 1.0f);
            label.setText("Pencil size: " + pencilSize);
        });
        add(decreaseButton);

        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        label.setText("X: " + e.getX() + " Y: " + e.getY());
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(pencilSize));
        LastX = e.getX();
        LastY = e.getY();
        if (x == 0 && y == 0) {
            x = e.getX();
            y = e.getY();
            return;
        }
        g2d.drawLine(x, y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = 0;
        y = 0;
    }

    public static void main(String[] args) {
        new UI();
    }
}
