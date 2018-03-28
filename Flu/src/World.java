import java.math.BigDecimal;
import java.util.*;

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
    private ArrayList conta_beings = new ArrayList<Being>();
    private Map<Location,List> count = new HashMap<>();
    private ArrayList humans = new ArrayList();
    private ArrayList ducks = new ArrayList();
    private ArrayList chickens = new ArrayList();
    private ArrayList pigs = new ArrayList();


    public void start() {
        System.out.println("Welcome to the sim world of flu" + "\n" + "How mach day you want to run it?");
        Scanner scanner = new Scanner(System.in);
        int numberofday = scanner.nextInt();
        System.out.println("How many humans do you want in the world?" );
        Scanner scanner1 = new Scanner(System.in);
        int numberofhuman = scanner.nextInt();
        System.out.println("How many pigs do you want in the world?" );
        Scanner scanner2 = new Scanner(System.in);
        int numberofpig = scanner.nextInt();
        System.out.println("How many ducks do you want in the world?" );
        Scanner scanner3 = new Scanner(System.in);
        int numberofduck = scanner.nextInt();
        System.out.println("How many chickens do you want in the world?" );
        Scanner scanner4 = new Scanner(System.in);
        int numberofchicken = scanner.nextInt();
        BeingIniti(numberofhuman,numberofpig,numberofduck,numberofchicken);
        LocInitialize();
        System.out.println("Initialization complete" );



    }
    void BeingIniti(int numberofhuman,int numberofpig,int numberofduck,int numberofchicken){
    for (int i = 1;i <= numberofhuman;i++){
        Human human = new Human();
        humans.add(human);
        beings.add(human);
    }
    for (int i = 1;i <= numberofchicken;i++){
        Chicken chicken = new Chicken();
        chickens.add(chicken);
        beings.add(chicken);
    }
    for (int i = 1;i <= numberofduck;i++){
        Duck duck = new Duck();
        ducks.add(duck);
        beings.add(duck);
    }
    for (int i = 1;i <= numberofpig;i++){
        Pig pig  = new Pig();
        pigs.add(pig);
        beings.add(pig);
    }

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
                for (Being being : beings) {
                    if (being.getState() != State.DEAD) {
                        Random rand = new Random();
                        int prob = rand.nextInt(10) + 1;
                        if (prob >= 3) {
                            being.location.ChangeLoc();

                        }
                    }
                }
                break;
            case RAINY:
                for (Being being : beings)
                {
                    if (being.getState() != State.DEAD){
                    Random rand = new Random();
                    int prob = rand.nextInt(10) + 1;
                    if (prob <= 3)
                    {
                        being.location.ChangeLoc();
                    }
                }
                }
                break;
                default:
                    for (Being being : beings)
                    {
                        if (being.getState() != State.DEAD){
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
    public int[] CountState(Location location)
    {
        int[] count  = new int[5];
        for (Being being : beings)
        {
            if (being.getLocation().IsSame(location))
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
                    case CONTAGIOUS:
                        count[2]++;
                        conta_beings.add(being);
                        break;
                    default:
                }
            }
        }
    return count;
    }
    State IfInfect(ArrayList<Being> infected_being,Being being)
    {
        if (being.isVaccinal() == true){
            return being.getState();
        }
        int size = infected_being.size();
        double rate = 0;
        for (Being being1 : infected_being)
        {
            rate += (1/size)*being1.getVirus().getContag_rate();
        }
        BigDecimal b = new BigDecimal(rate);
        double rate1 = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        Random random = new Random(999);
        int prob = random.nextInt();
        if (prob + 1 < rate1 * 1000 +1){
            return State.INFECTED;
        }else {
            return being.getState();
        }
        
    }
    public void event(Being being){
        State state  = being.getState();
        Location location = being.getLocation();
        switch (state)
        {
            case HEALTHY:
                event4heal(conta_beings,being,location);
                break;
            case INFECTED:
                event4inf(being);
                break;
            case CONTAGIOUS:
                event4conta(being);
                break;
            case SICK:
                event4sick(being);
                break;
            case RECOVERING:
                event4recov(being);
                default:

        }
    }
    void event4heal(ArrayList<Being> infected_being,Being being,Location location){
        int[] count = CountState(location);
        if (infected_being.size() > 0)
        {
            if (being.isVaccinal()){
                return;
            }
            int size = infected_being.size();
            double rate = 0;
            for (Being being1 : infected_being)
            {
                rate += (1/size)*being1.getVirus().getContag_rate();
            }
            double rate1 = CalRate(rate);
            Random random = new Random(999);
            int prob = random.nextInt();
            if (prob + 1 < rate1){
                int h1n1 = 0;
                int h5n1 = 0;
                for (Being being1 : infected_being) {
                    if (being1.getVirus() == Virus.H1N1){
                        h1n1++;
                    }else if (being1.getVirus() == Virus.H5N1){
                        h5n1++;
                    }
                    double rateh1n1 = CalRate(h1n1/infected_being.size());
                    Random random1 = new Random(999);
                    int prob1 = random.nextInt();
                    if (prob1 +1 < rateh1n1){
                        if (being.CheckAntibody(Virus.H1N1)){
                            return;
                        }else {
                        being.setVirus(Virus.H1N1);
                        being.setState(State.INFECTED);
                        }

                    }else if (being.CheckAntibody(Virus.H5N1)){
                        return;
                    }else {
                        being.setVirus(Virus.H5N1);
                        being.setState(State.INFECTED);
                    }
                }
            }else {
                return;
            }
        }
    }
    void event4inf(Being being) {
        being.setInf_time();
        int inftime = being.getInf_time();
        if (inftime >= 3) {
            Random random = new Random(9);
            int prob = random.nextInt();
            if (prob + 1 <= 3) {
                being.setState(State.CONTAGIOUS);
            } else if (prob + 1 > 3 && prob + 1 <= 6) {
                being.setState(State.CONTA_SICK);
            } else {
                being.setState(State.SICK);
            }
        }
    }
    void event4conta(Being being){
        being.setConta_time();
        int contatime = being.getConta_time();
        if(contatime >= 4){
            being.setState(State.RECOVERING);
            being.setRecov_time();
        }
    }
    void event4sick(Being being) {
        Random random = new Random(9);
        int prob = random.nextInt();
        double deathrate = being.getVirus().getDeath_rate();
        if (being.getSick_time() < 4) {
            if (prob + 1 <= deathrate * 10) {
                if (being instanceof Animal) {
                    being.setSick_time();
                } else {
                    being.setState(State.DEAD);
                }
            } else {
                being.setState(State.RECOVERING);
                being.setRecov_time();
            }
        }
    }
    void event4recov(Being being){
        int recovtime = being.getRecov_time();
        if(recovtime <=3){
            being.setRecov_time();
        }else {
            being.setState(State.HEALTHY);
            being.AddAntibody(being.getVirus());
            being.setVirus(null);
        }
    }
    double CalRate(double rate){
        BigDecimal b = new BigDecimal(rate);
        double rate1 = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        double rate2 = rate1 * 1000 + 1;
        return rate2;

    }
}



