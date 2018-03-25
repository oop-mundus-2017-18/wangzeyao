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
    private List<Being> conta_beings = new ArrayList<>();


    public void start() {

    }

    public void LocInitialize() {
        for (Being b : beings) {
           b.location.InitialLoc();
        }
    }
    public void event(){
        for (Being being : beings)
        {
            State state  = being.getState();
            Location location = being.getLocation();
            switch (state)
            {
                case HEALTHY:
                    int[] count = CountState(location);
                    if (count[1] >0 || count[2] > 0 || count[3] >0)
                    {

                    }
            }
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
    int[] CountState(Location location)
    {
        int[] count  = new int[5];
        for (Being being : beings)
        {
            if (being.getLocation() == location)
            {
                State state = being.getState();
                switch (state)
                {
                    case HEALTHY:
                        count[0]++;
                        break;
                    case CONTA_SICK:
                        count[1]++;
                        conta_beings.add(being);
                        break;
                    case DEAD_CONTA:
                        count[2]++;
                        conta_beings.add(being);
                        break;
                    case CONTAGIOUS:
                        count[3]++;
                        conta_beings.add(being);
                        break;
                    case RECOVERD:
                        break;
                    default:
                }
            }
        }
    return count;
    }
    State IfInfect(ArrayList<Being> infected_being)
    {
        int size = infected_being.size();
        double rate;
        for (Being being : infected_being)
        {
            rate = (1/size)*being.getVirus().getContag_rate();
        }
        Random random = new Random(9);
        
    }
}



