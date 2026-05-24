import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {

    public SplashScreen() {

        // Window setup
        setTitle("GuessMaster");

        setSize(600, 350);

        setLocationRelativeTo(null);

        setUndecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel panel = new JPanel();

        panel.setBackground(new Color(18, 18, 18));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Spacing
        panel.add(Box.createVerticalGlue());

        // App title
        JLabel titleLabel = new JLabel("GUESSMASTER");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 38));

        titleLabel.setForeground(new Color(0, 255, 180));

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Loading text
        JLabel loadingLabel = new JLabel("Loading...");

        loadingLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        loadingLabel.setForeground(Color.LIGHT_GRAY);

        loadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Progress bar
        JProgressBar progressBar = new JProgressBar();

        progressBar.setIndeterminate(true);

        progressBar.setBackground(new Color(40, 40, 40));

        progressBar.setForeground(new Color(0, 200, 140));

        progressBar.setMaximumSize(new Dimension(250, 20));

        // Add components
        panel.add(titleLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        panel.add(loadingLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        panel.add(progressBar);

        panel.add(Box.createVerticalGlue());

        add(panel);

        setVisible(true);

        // Loading delay
        Timer timer = new Timer(2500, e -> {

            dispose();

            new MenuGUI();
        });

        timer.setRepeats(false);

        timer.start();
    }
}