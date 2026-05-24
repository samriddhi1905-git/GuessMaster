import javax.swing.*;
import java.awt.*;

public class LoadingScreen extends JFrame {

    public LoadingScreen(String message, int difficulty) {

        // Window setup
        setTitle("GuessMaster");

        setSize(500, 300);

        setLocationRelativeTo(null);

        setUndecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel panel = new JPanel();

        panel.setBackground(new Color(18, 18, 18));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Center spacing
        panel.add(Box.createVerticalGlue());

        // Title
        JLabel titleLabel = new JLabel("GUESSMASTER");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 34));

        titleLabel.setForeground(new Color(0, 255, 180));

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Loading message
        JLabel messageLabel = new JLabel(message);

        messageLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        messageLabel.setForeground(Color.LIGHT_GRAY);

        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Progress bar
        JProgressBar progressBar = new JProgressBar();

        progressBar.setIndeterminate(true);

        progressBar.setForeground(new Color(0, 200, 140));

        progressBar.setBackground(new Color(40, 40, 40));

        progressBar.setMaximumSize(new Dimension(250, 20));

        // Add components
        panel.add(titleLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        panel.add(messageLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        panel.add(progressBar);

        panel.add(Box.createVerticalGlue());

        add(panel);

        setVisible(true);

        // Timer
        Timer timer = new Timer(2200, e -> {

            dispose();

            new GameGUI(difficulty);
        });

        timer.setRepeats(false);

        timer.start();
    }
}