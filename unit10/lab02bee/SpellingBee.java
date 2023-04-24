import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SpellingBee {

    private char[] letters;
    private char mustUse;

    public SpellingBee(char[] letters, char mustUse){
        this.letters = letters;
        this.mustUse = mustUse;
    }

    public boolean checkWord(String word) {
        char[] wordInChars = word.toCharArray();
        int countCorrect = 0;
        boolean requiredWord = false;

        for(int i = 0; i < wordInChars.length; i++){
            if(wordInChars[i] == mustUse){
                requiredWord = true;
            }
            for(int j = 0; j < letters.length; j++){
                if(wordInChars[i] == letters[j]){
                    countCorrect++;
                }
            }
        }

        if(countCorrect == wordInChars.length - 1 && requiredWord){
            return true;
        }
        return false;
    }

    /**
     * Loads the contents of file "filename" as a String.
     * 
     * @param filename the file to load
     * @return the contents of file "filename"
     */
    public static String loadFile(String filename) {
        String contents = "";
        Path path = Paths.get(filename);
        try {
            path = Path.of(ClassLoader.getSystemResource(filename).toURI());
            contents = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static void main(String[] args) {
        String[] words = loadFile("words_dropped.txt").split("\n");
        System.out.println("Loaded " + words.length + " words");

        SpellingBee bee = new SpellingBee("laucjo".toCharArray(), 'r');

        for(int i = 0; i < words.length; i++){
            if(bee.checkWord(words[i])){
                System.out.println(words[i]);
            }
        }
    }
}
