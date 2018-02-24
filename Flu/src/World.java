import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: WANG ZEYAO
 * @Description:
 * @Date: 2018/2/23  9:18
 * @ProjectName: Flu
 * @Version: 1.0
 */
public class World {
    private Climate climate;
    private List<Being> beings = new ArrayList();


    public void start() {

    }

    public void LocInitialize() {
        int i = 0;
        for (Being b : beings) {
            Location Initlocation = new Location(new int[i][i]);
            b.setLocation(Initlocation);
            i++;
        }
    }

    private void ChangeLoc() {
        //        从0开始往后1000个数随机取整数


        switch (climate.getWeather()) {
            case "sunny":
                for (Being being : beings) {
                    Random random0 = new Random();
                    int RandLoc0 = random0.nextInt(1001);
                    Random random1 = new Random();
                    int RandLoc1 = random1.nextInt(1001);
                    Location Initlocation = new Location(new int[RandLoc0][RandLoc1]);
                }
                break;
            case "rainy":
                for (Being being : beings) {
                    Random random2 = new Random();
                    int randnum = random2.nextInt(10) + 1;
                    if (randnum <= 3) {
                        Random random0 = new Random();
                        int RandLoc0 = random0.nextInt(1001);
                        Random random1 = new Random();
                        int RandLoc1 = random1.nextInt(1001);
                        Location Initlocation = new Location(new int[RandLoc0][RandLoc1]);
                    } else if (being instanceof Human) {
//
//                        being.setLocation();
                    }
                }
        }
    }
}



