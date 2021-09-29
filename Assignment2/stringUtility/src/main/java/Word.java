import java.util.Locale;

public class Word {

    private String word;

    public Word() {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String setWord(String word) {
        return word;
    }

    public String makeReverse(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        sb.reverse();
        return sb.toString();
    }

    public String makeUppercase(String word) {
        return word.toUpperCase();
    }

    public String makeLowercase(String word) {
        return word.toLowerCase();
    }
}
