import org.junit.Assert;
import org.junit.Test;

public class StringUtilityTest {

    private Word w;

    public StringUtilityTest() {
        w = new Word();
    }

    @Test
    public void checkWord_Expected_NullResult(){
        String word = w.getWord();
        Assert.assertNull(word);
    }

    @Test
    public void checkWord_Expected_HelloWorldResult(){
        String word = w.setWord("Hello World");
        Assert.assertEquals("Hello World", word);
    }

    @Test
    public void checkWord_expected_wordIsReversedResult(){
        String word = w.setWord("Hello World");
        String reversedWord = w.makeReverse(word);
        Assert.assertEquals("dlroW olleH", reversedWord);
    }

    @Test
    public void checkWord_expected_wordIsOnlyUppercase(){
        String word = w.setWord("Hello World");
        String uppercaseWord = w.makeUppercase(word);
        Assert.assertEquals("HELLO WORLD", uppercaseWord);
    }

    @Test
    public void checkWord_expected_wordIdOnlyLowercase(){
        String word = w.setWord("Hello World");
        String lowercaseWord = w.makeLowercase(word);
        Assert.assertEquals("hello world", lowercaseWord);
    }
}
