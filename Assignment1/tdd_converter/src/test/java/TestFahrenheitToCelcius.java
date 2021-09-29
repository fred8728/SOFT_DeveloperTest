import converter.FahrenheitToCelcius;
import org.junit.Assert;
import org.junit.Test;

public class TestFahrenheitToCelcius {

    @Test
    public void TestConvertToCelcius60(){
        FahrenheitToCelcius ftc = new FahrenheitToCelcius();
        var celcius = ftc.convertToCelsius(60);
        Assert.assertEquals(15.55556, celcius, 0.001);
    }

    @Test
    public void TestConvertToCelcius80(){
        FahrenheitToCelcius ftc = new FahrenheitToCelcius();
        var celcius = ftc.convertToCelsius(80);
        Assert.assertEquals(26.66667, celcius, 0.001);
    }
}
