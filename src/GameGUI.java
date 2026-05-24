import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame implements ActionListener {

    // ================= LABELS =================

    JLabel titleLabel;
    JLabel wordLabel;
    JLabel livesLabel;
    JLabel difficultyLabel;
    JLabel messageLabel;
    JLabel scoreLabel;

    // ================= BUTTONS =================

    JButton restartButton;

    JButton[] letterButtons = new JButton[26];

    // ================= PANELS =================

    JPanel keyboardPanel;

    // ================= GAME DATA =================

    WordManager wordManager = new WordManager();

    String secretWord;

    char[] hiddenWord;

    int lives;

    int difficulty;

    int score = 0;

    public GameGUI(int difficulty) {

        this.difficulty = difficulty;

        // ================= GET WORD =================

        secretWord = wordManager.getRandomWord(difficulty);

        // ================= LIVES =================

        if (difficulty == 1) {

            lives = 8;

        } else if (difficulty == 2) {

            lives = 6;

        } else {

            lives = 4;
        }

        // ================= HIDDEN WORD =================

        hiddenWord = new char[secretWord.length()];

        for (int i = 0; i < secretWord.length(); i++) {

            hiddenWord[i] = '_';
        }

        // ================= WINDOW =================

        setTitle("GuessMaster");

        setSize(900, 650);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout(20, 20));

        getContentPane().setBackground(
                new Color(18, 18, 18)
        );

        // ================= TITLE =================

        titleLabel = new JLabel(
                "GUESSMASTER",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 36)
        );

        titleLabel.setForeground(
                new Color(0, 255, 180)
        );

        // ================= WORD LABEL =================

        wordLabel = new JLabel(
                getHiddenWord(),
                SwingConstants.CENTER
        );

        wordLabel.setFont(
                new Font("Arial", Font.BOLD, 50)
        );

        wordLabel.setForeground(Color.WHITE);

        // ================= LIVES LABEL =================

        livesLabel = new JLabel(
                "Lives: " + lives
        );

        livesLabel.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        livesLabel.setForeground(
                new Color(255, 170, 50)
        );

        // ================= SCORE LABEL =================

        scoreLabel = new JLabel(
                "Score: 0"
        );

        scoreLabel.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        scoreLabel.setForeground(
                new Color(0, 220, 255)
        );

        // ================= DIFFICULTY LABEL =================

        String difficultyText;

        if (difficulty == 1) {

            difficultyText = "EASY";

        } else if (difficulty == 2) {

            difficultyText = "MEDIUM";

        } else {

            difficultyText = "HARD";
        }

        difficultyLabel = new JLabel(
                "Difficulty: " + difficultyText
        );

        difficultyLabel.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        if (difficulty == 1) {

            difficultyLabel.setForeground(
                    new Color(80, 255, 120)
            );

        } else if (difficulty == 2) {

            difficultyLabel.setForeground(
                    new Color(255, 200, 80)
            );

        } else {

            difficultyLabel.setForeground(
                    new Color(255, 90, 90)
            );
        }

        // ================= MESSAGE LABEL =================

        messageLabel = new JLabel(
                "Guess the word",
                SwingConstants.CENTER
        );

        messageLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        messageLabel.setForeground(
                Color.LIGHT_GRAY
        );

        // ================= RESTART BUTTON =================

        restartButton = new JButton("Restart");

        styleButton(restartButton);

        restartButton.setBackground(
                new Color(255, 120, 120)
        );

        restartButton.setForeground(Color.BLACK);

        restartButton.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255, 80, 80),
                        2
                )
        );

        restartButton.addActionListener(this);

        // ================= PANELS =================

        JPanel topPanel = new JPanel();

        JPanel centerPanel = new JPanel();

        JPanel bottomPanel = new JPanel();

        keyboardPanel = new JPanel();

        // Colors
        topPanel.setBackground(
                new Color(18, 18, 18)
        );

        centerPanel.setBackground(
                new Color(18, 18, 18)
        );

        bottomPanel.setBackground(
                new Color(18, 18, 18)
        );

        keyboardPanel.setBackground(
                new Color(18, 18, 18)
        );

        // Layouts
        topPanel.setLayout(
                new BoxLayout(
                        topPanel,
                        BoxLayout.Y_AXIS
                )
        );

        keyboardPanel.setLayout(
                new GridLayout(4, 7, 10, 10)
        );

        // ================= LETTER BUTTONS =================

        for (int i = 0; i < 26; i++) {

            char letter = (char) ('A' + i);

            letterButtons[i] =
                    new JButton(String.valueOf(letter));

            styleButton(letterButtons[i]);

            letterButtons[i].setPreferredSize(
                    new Dimension(70, 55)
            );

            letterButtons[i].addActionListener(this);

            keyboardPanel.add(letterButtons[i]);
        }

        // ================= ALIGNMENTS =================

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        difficultyLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        livesLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        scoreLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        messageLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ================= ADD COMPONENTS =================

        topPanel.add(Box.createVerticalStrut(15));

        topPanel.add(titleLabel);

        topPanel.add(Box.createVerticalStrut(10));

        topPanel.add(difficultyLabel);

        topPanel.add(Box.createVerticalStrut(5));

        topPanel.add(livesLabel);

        topPanel.add(Box.createVerticalStrut(5));

        topPanel.add(scoreLabel);

        topPanel.add(Box.createVerticalStrut(10));

        topPanel.add(messageLabel);

        topPanel.add(Box.createVerticalStrut(10));

        JPanel restartPanel = new JPanel();

        restartPanel.setBackground(
                new Color(18, 18, 18)
        );

        restartPanel.add(restartButton);

        topPanel.add(restartPanel);

        centerPanel.add(wordLabel);

        bottomPanel.setLayout(
                new BorderLayout()
        );

        bottomPanel.add(
                keyboardPanel,
                BorderLayout.CENTER
        );

        // ================= ADD TO FRAME =================

        add(topPanel, BorderLayout.NORTH);

        add(centerPanel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // ================= BUTTON STYLE =================

    public void styleButton(JButton button) {

        button.setBackground(
                new Color(45, 45, 55)
        );

        button.setForeground(
                new Color(0, 255, 180)
        );

        button.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(0, 255, 180),
                        2
                )
        );
    }

    // ================= HIDDEN WORD =================

    public String getHiddenWord() {

        String result = "";

        for (int i = 0; i < hiddenWord.length; i++) {

            result += hiddenWord[i] + " ";
        }

        return result;
    }

    // ================= BUTTON EVENTS =================

    @Override
    public void actionPerformed(ActionEvent e) {

        // ================= RESTART BUTTON =================

        if (e.getSource() == restartButton) {

            dispose();

            new LoadingScreen(
                    "Restarting Your Game...",
                    difficulty
            );

            return;
        }

        // ================= LETTER BUTTONS =================

        for (int i = 0; i < 26; i++) {

            if (e.getSource() == letterButtons[i]) {

                JButton clickedButton =
                        letterButtons[i];

                // Get guessed letter
                char guess = clickedButton
                        .getText()
                        .toLowerCase()
                        .charAt(0);

                boolean correctGuess = false;

                // ================= CHECK LETTER =================

                for (int j = 0;
                     j < secretWord.length();
                     j++) {

                    if (secretWord.charAt(j)
                            == guess) {

                        hiddenWord[j] = guess;

                        correctGuess = true;
                    }
                }

                // ================= CORRECT GUESS =================

                if (correctGuess) {

                    // Hide button ONLY if correct
                    clickedButton.setVisible(false);

                    // Increase score
                    score += 10;

                    scoreLabel.setText(
                            "Score: " + score
                    );

                    messageLabel.setForeground(
                            new Color(0, 255, 140)
                    );

                    messageLabel.setText(
                            "✓ Correct Guess"
                    );

                } else {

                    // ================= WRONG GUESS =================

                    // Lose life
                    lives--;

                    livesLabel.setText(
                            "Lives: " + lives
                    );

                    messageLabel.setForeground(
                            new Color(255, 90, 90)
                    );

                    messageLabel.setText(
                            "✗ Wrong Guess"
                    );

                    UIManager.put(
                            "OptionPane.background",
                            new Color(35, 35, 45)
                    );

                    UIManager.put(
                            "Panel.background",
                            new Color(35, 35, 45)
                    );

                    UIManager.put(
                            "OptionPane.messageForeground",
                            Color.WHITE
                    );

                    JOptionPane.showMessageDialog(
                            this,
                            "❌ Wrong Guess!\n\nYou lost 1 life.",
                            "WRONG GUESS",
                            JOptionPane.WARNING_MESSAGE
                    );
                }

                // ================= UPDATE WORD =================

                wordLabel.setText(
                        getHiddenWord()
                );

                // ================= WIN CHECK =================

                if (secretWord.equals(
                        String.valueOf(hiddenWord))) {

                    score += lives * 20;

                    scoreLabel.setText(
                            "Score: " + score
                    );

                    messageLabel.setForeground(
                            new Color(0, 255, 140)
                    );

                    messageLabel.setText(
                            "🎉 YOU WON!"
                    );

                    UIManager.put(
                            "OptionPane.background",
                            new Color(35, 35, 45)
                    );

                    UIManager.put(
                            "Panel.background",
                            new Color(35, 35, 45)
                    );

                    UIManager.put(
                            "OptionPane.messageForeground",
                            Color.WHITE
                    );

                    String[] options = {
                            "Restart Game",
                            "Back To Menu"
                    };

                    int choice =
                            JOptionPane.showOptionDialog(
                                    this,
                                    "🎉 CONGRATULATIONS!\n\n"
                                            + "Final Score: "
                                            + score,
                                    "YOU WON",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null,
                                    options,
                                    options[0]
                            );

                    // Disable buttons
                    for (int k = 0; k < 26; k++) {

                        letterButtons[k]
                                .setEnabled(false);
                    }

                    // Restart
                    if (choice == 0) {

                        dispose();

                        new LoadingScreen(
                                "Restarting Your Game...",
                                difficulty
                        );

                    } else {

                        dispose();

                        new MenuGUI();
                    }

                    return;
                }

                // ================= LOSE CHECK =================

                if (lives <= 0) {

                    messageLabel.setForeground(
                            new Color(255, 90, 90)
                    );

                    messageLabel.setText(
                            "💀 GAME OVER"
                    );

                    UIManager.put(
                            "OptionPane.background",
                            new Color(35, 35, 45)
                    );

                    UIManager.put(
                            "Panel.background",
                            new Color(35, 35, 45)
                    );

                    UIManager.put(
                            "OptionPane.messageForeground",
                            Color.WHITE
                    );

                    JOptionPane.showMessageDialog(
                            this,
                            "💀 GAME OVER\n\n"
                                    + "The word was: "
                                    + secretWord,
                            "GAME OVER",
                            JOptionPane.ERROR_MESSAGE
                    );

                    // Disable buttons
                    for (int k = 0; k < 26; k++) {

                        letterButtons[k]
                                .setEnabled(false);
                    }
                }

                return;
            }
        }
    }
}