package converter;

public class FahrenheitToCelcius {

    public double convertToCelsius(float fahrenheit){
        var result = (fahrenheit-32)/1.8;
        return result;
    }
}
