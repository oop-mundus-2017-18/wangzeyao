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
        for (Being b : beings) {
           b.location.InitialLoc();
        }
    }

    private void ChangeLoc() {
        switch (climate)
        {
            case SUNNY:
                for (Being being : beings)
                {
                    Random rand = new Random();
                    int prob = rand.nextInt(10) + 1;
                    if (prob >= 3)
                    {
                        being.location.ChangeLoc();

                    }
                }
                break;
            case RAINY:
                for (Being being : beings)
                {
                    Random rand = new Random();
                    int prob = rand.nextInt(10) + 1;
                    if (prob <= 3)
                    {
                        being.location.ChangeLoc();
                    }
                }
                break;
                default:
                    for (Being being : beings)
                    {
                        Random rand = new Random();
                        int prob = rand.nextInt(2);
                        if (prob == 1)
                        {
                            being.location.ChangeLoc();
                        }
                    }
        }
    }
}



