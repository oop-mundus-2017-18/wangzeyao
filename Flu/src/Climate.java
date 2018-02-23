/**
 * @Author: WANG ZEYAO
 * @Description:
 * @Date: 2018/2/23  9:50
 * @ProjectName: Flu
 * @Version: 1.0
 */
public enum Climate {
        SUNNY("sunny"),RAINY("rainy"),CLOUDY("cloudy"),WINDY("windy");
        private String weather;
        private int temperature;

    public String getWeather() {
        return weather;
    }

    public int getTemperature() {
        return temperature;
    }

    Climate(String weather) {
            this.weather = weather;

        }
    }

