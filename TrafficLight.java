import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLight extends JFrame implements ActionListener {

    private JRadioButton redButton, yellowButton, greenButton;
    private ButtonGroup buttonGroup;
    private JPanel panel;

    public TrafficLight() {
        this.setTitle("Traffic Light Simulation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 300);
        this.setLayout(new FlowLayout());

        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(yellowButton);
        buttonGroup.add(greenButton);

        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 200));
        panel.setBorder(BorderFactory.createLineBorder(Color.black));

        this.add(redButton);
        this.add(yellowButton);
        this.add(greenButton);
        this.add(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            panel.setBackground(Color.RED);
        } else if (e.getSource() == yellowButton) {
            panel.setBackground(Color.YELLOW);
        } else if (e.getSource() == greenButton) {
            panel.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}
