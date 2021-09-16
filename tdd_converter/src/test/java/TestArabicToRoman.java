import converter.RomanNumerals;
import junit.framework.Assert;
import org.junit.Test;

public class TestArabicToRoman {
    @Test
    public void TestConvertToRoman5(){
        RomanNumerals rm = new RomanNumerals();
        var romanNumberal = rm.convertToRoman(5);
        Assert.assertEquals("V", romanNumberal);
    }

    @Test
    public void TestConvertToRoman32(){
        RomanNumerals rm = new RomanNumerals();
        var romanNumberal = rm.convertToRoman(32);
        Assert.assertEquals("XXXII", romanNumberal);
    }

    @Test
    public void TestConvertToRoman77(){
        RomanNumerals rm = new RomanNumerals();
        var romanNumberal = rm.convertToRoman(77);
        Assert.assertEquals("LXXVII", romanNumberal);
    }
}
