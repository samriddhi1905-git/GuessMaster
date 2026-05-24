import java.util.Random;

public class WordManager {

    private String[] easyWords = {
            "java",
            "game",
            "code",
            "mouse",
            "phone"
    };

    private String[] mediumWords = {
            "computer",
            "developer",
            "internet",
            "keyboard",
            "software"
    };

    private String[] hardWords = {
            "programming",
            "application",
            "artificial",
            "cybersecurity",
            "microprocessor"
    };

    public String getRandomWord(int difficulty) {  //acc to the difficulty the word is selected

        Random random = new Random();  //to find random number

        if (difficulty == 1) {
            return easyWords[random.nextInt(easyWords.length)];

        } else if (difficulty == 2) {
            return mediumWords[random.nextInt(mediumWords.length)];

        } else {
            return hardWords[random.nextInt(hardWords.length)];
        }
    }
}