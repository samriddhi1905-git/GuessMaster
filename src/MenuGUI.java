import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame implements ActionListener {

    JLabel titleLabel;

    JComboBox<String> difficultyBox;

    JButton startButton;

    public MenuGUI() {

        // Window setup
        setTitle("GuessMaster");

        setSize(500, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 1));

        getContentPane().setBackground(new Color(30, 30, 30));

        // Title
        titleLabel = new JLabel("GUESSMASTER", SwingConstants.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));

        titleLabel.setForeground(new Color(0, 255, 180));

        // Difficulty dropdown
        String[] difficulties = {
                "Easy",
                "Medium",
                "Hard"
        };

        difficultyBox = new JComboBox<>(difficulties);

        difficultyBox.setFont(new Font("Arial", Font.PLAIN, 20));

        // Start button
        startButton = new JButton("Start Game");

        startButton.setFont(new Font("Arial", Font.BOLD, 18));

        startButton.setBackground(new Color(0, 200, 140));

        startButton.addActionListener(this);

        // Panels
        JPanel titlePanel = new JPanel();

        JPanel difficultyPanel = new JPanel();

        JPanel buttonPanel = new JPanel();

        titlePanel.setBackground(new Color(30, 30, 30));

        difficultyPanel.setBackground(new Color(30, 30, 30));

        buttonPanel.setBackground(new Color(30, 30, 30));

        // Add components
        titlePanel.add(titleLabel);

        difficultyPanel.add(difficultyBox);

        buttonPanel.add(startButton);

        // Add panels
        add(titlePanel);

        add(difficultyPanel);

        add(buttonPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int difficulty;

        String selected =
                (String) difficultyBox.getSelectedItem();

        if (selected.equals("Easy")) {

            difficulty = 1;

        } else if (selected.equals("Medium")) {

            difficulty = 2;

        } else {

            difficulty = 3;
        }

        // Open game screen
        new LoadingScreen(
                "Loading Your Game...",
                difficulty
        );

        // Close menu
        dispose();
    }
}