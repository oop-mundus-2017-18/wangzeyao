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
    private Climate climate = Climate.SUNNY;
    private List<Being> beings = new ArrayList();
    private ArrayList conta_beings = new ArrayList<Being>();
    private Map<Location, ArrayList<Being>> count = new HashMap<>();
    private ArrayList<Human> humans = new ArrayList();
    private ArrayList<Duck> ducks = new ArrayList();
    private ArrayList<Chicken> chickens = new ArrayList();
    private ArrayList<Pig> pigs = new ArrayList();
    static int  colupsize = 0;
    static int  rowupsize = 0;

    public void start() {
        System.out.println("Welcome to the sim world of flu" + "\n" + "How mach day you want to run it?");
        Scanner scanner = new Scanner(System.in);
        int numberofday = scanner.nextInt();
//        int numberofday = 50;
        System.out.println("How many humans do you want in the world?");
        Scanner scanner1 = new Scanner(System.in);
        int numberofhuman = scanner1.nextInt();
//        int numberofhuman = 10;
        System.out.println("How many pigs do you want in the world?");
        Scanner scanner2 = new Scanner(System.in);
        int numberofpig = scanner2.nextInt();
//        int numberofpig = 20;
        System.out.println("How many ducks do you want in the world?");
        Scanner scanner3 = new Scanner(System.in);
        int numberofduck = scanner3.nextInt();
//        int numberofduck = 12;
        System.out.println("How many chickens do you want in the world?");
        Scanner scanner4 = new Scanner(System.in);
        int numberofchicken = scanner4.nextInt();
        System.out.println("How many cols do you want in the world?");
        Scanner scanner5 = new Scanner(System.in);
        int col = scanner5.nextInt();
        System.out.println("How many rows do you want in the world?");
        Scanner scanner6 = new Scanner(System.in);
        int row = scanner6.nextInt();
        SetSize(col,row);
//        int numberofchicken = 13;
        BeingIniti(numberofhuman, numberofpig, numberofduck, numberofchicken);
        LocInitialize();
        System.out.println("Initialization complete");
        for (int i = 1; i <= numberofday; i++) {
            ChangeLoc();
            for (Being being : beings) {
                event(being);
            }
           PrintResult("human");
            PrintResult("duck");
            PrintResult("pig");
            PrintResult("chicken");
        }


    }
    void superini(){
        for (Being b : beings) {
            b.location.setRow(1);
            b.location.setCol(1);
        }
        SetMap();
    }

    void BeingIniti(int numberofhuman, int numberofpig, int numberofduck, int numberofchicken) {
        for (int i = 1; i <= numberofhuman; i++) {
            Human human = new Human();
            humans.add(human);
            beings.add(human);
        }
        for (int i = 1; i <= numberofchicken; i++) {
            Chicken chicken = new Chicken();
            chickens.add(chicken);
            beings.add(chicken);
        }
        for (int i = 1; i <= numberofduck; i++) {
            Duck duck = new Duck();
            ducks.add(duck);
            beings.add(duck);
        }
        for (int i = 1; i <= numberofpig; i++) {
            Pig pig = new Pig();
            pigs.add(pig);
            beings.add(pig);
        }
            Random random = new Random();
            int sourcechicken = random.nextInt(numberofchicken);
            Random random1 = new Random();
            int sourceduck = random1.nextInt(numberofduck);
            Random random2 = new Random();
            int sourcepig = random2.nextInt(numberofpig);
            for (int a = 0; a < sourcechicken; a++) {
                chickens.get(a).setVirus(Virus.H5N1);
                chickens.get(a).setState(State.INFECTED);
            }
            for (int b = 0; b < sourcepig; b++) {
                pigs.get(b).setVirus(Virus.H1N1);
                pigs.get(b).setState(State.INFECTED);
            }
            for (int c = 0; c < sourceduck; c++) {
                ducks.get(c).setVirus(Virus.H5N1);
                ducks.get(c).setState(State.INFECTED);
            }

    }

    public void LocInitialize() {
        for (Being b : beings) {
            b.location.InitialLoc();
        }

        for (int i = 1; i <= colupsize; i++) {
            for (int j = 1; j <= rowupsize; j++) {
                Location location = new Location(i, j);
                count.put(location, new ArrayList<Being>());
            }
        }
    }


    private void ChangeLoc() {
        switch (climate) {
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
                for (Being being : beings) {
                    if (being.getState() != State.DEAD) {
                        Random rand = new Random();
                        int prob = rand.nextInt(10) + 1;
                        if (prob <= 3) {
                            being.location.ChangeLoc();
                        }
                    }
                }
                break;
            default:
                for (Being being : beings) {
                    if (being.getState() != State.DEAD) {
                        Random rand = new Random();
                        int prob = rand.nextInt(2);
                        if (prob == 1) {
                            being.location.ChangeLoc();
                        }
                    }
                }
        }
        SetMap();
    }

    // count the number of pople by state
    //return a int[]
    //0:healthy  1:conta_sick  2:conta  3:dead  4:recovering  5:infected
    ArrayList<Being> findlocation(Location location){
        int row = location.getRow();
        int col = location.getCol();
        ArrayList<Being> arrayList = new ArrayList();
        for (Location location1 : count.keySet()){
            if (location1.getRow() == row && location1.getCol() == col){
                arrayList = count.get(location1);
            }
        }
        return arrayList;
    }
    public int[] CountState(Location location) {
        conta_beings.clear();
        int[] count = new int[6];
        for (Being being : findlocation(location)) {
            switch (being.getState()) {
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
                    case DEAD:
                        count[3]++;
                        break;
                    case RECOVERING:
                        count[4]++;
                        break;
                    case INFECTED:
                        count[5]++;
                        break;
                    default:
                }
        }
        return count;
        }


    State IfInfect(ArrayList<Being> infected_being, Being being) {
        if (being.isVaccinal()) {
            return being.getState();
        }
        int size = infected_being.size();
        double rate = 0;
        for (Being being1 : infected_being) {
            rate += (1 / size) * being1.getVirus().getContag_rate();
        }
        BigDecimal b = new BigDecimal(rate);
        double rate1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        Random random = new Random();
        int prob = random.nextInt(999) + 1;
        if (prob < rate1 * 1000 + 1) {
            return State.INFECTED;
        } else {
            return being.getState();
        }

    }

    public void event(Being being) {
        switch (being.getState()) {
            case HEALTHY:
                Location location = being.getLocation();
                int[] count = CountState(location);
                event4heal(conta_beings, being, location,count);
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
                break;
            case CONTA_SICK:
                event4sick(being);
            default:

        }
    }

    void event4heal(ArrayList<Being> contagious_being, Being being, Location location,int[] count) {
        if (contagious_being.size() > 0) {
            if (being.isVaccinal()) {
                return;
            }
            double size = contagious_being.size();
            double rate = 0;
            for (Being being1 : contagious_being) {
                double rate3 = being1.getVirus().getContag_rate();
                rate = rate + (1 / size) * rate3;
            }

            double rate1 = CalRate(rate);
            Random random = new Random();
            int prob = random.nextInt(999) + 1;
            if (prob < rate1) {
                int h1n1 = 0;
                int h5n1 = 0;
                for (Being being1 : contagious_being) {
                    if (being1.getVirus() == Virus.H1N1) {
                        h1n1++;
                    } else if (being1.getVirus() == Virus.H5N1) {
                        h5n1++;
                    }
                    double rateh1n1 = CalRate(h1n1 / contagious_being.size());
                    Random random1 = new Random();
                    int prob1 = random.nextInt(999) + 1;
                    if (prob1 < rateh1n1) {
                        if (!being.CheckAntibody(Virus.H1N1)) {
                            being.setVirus(Virus.H1N1);
                            being.setState(State.INFECTED);
                        }
                    } else if (!being.CheckAntibody(Virus.H5N1)) {
                        being.setVirus(Virus.H5N1);
                        being.setState(State.INFECTED);
                    }
                }
            }
        }
    }

    void event4inf(Being being) {
        being.setInf_time();
        int inftime = being.getInf_time();
        if (inftime >= 2) {
            Random random = new Random();
            int prob = random.nextInt(9) + 1;
            if (prob <= 3) {
                being.setState(State.CONTAGIOUS);
            } else if (prob + 1 > 3 && prob + 1 <= 6) {
                being.setState(State.CONTA_SICK);
            } else {
                being.setState(State.SICK);
            }
        }
    }

    void event4conta(Being being) {
        being.setConta_time();
        int contatime = being.getConta_time();
        if (contatime >= 4) {
            being.setState(State.RECOVERING);
            being.setRecov_time();
        }
    }

    void event4sick(Being being) {
        Random random = new Random();
        int prob = random.nextInt(9) + 1;
        double deathrate = being.getVirus().getDeath_rate();
        if (being.getSick_time() < 4) {
            if (prob <= deathrate * 10) {
                    being.setState(State.DEAD);
            } else {
                being.setState(State.RECOVERING);
                being.setRecov_time();
            }
        }
    }

    void event4recov(Being being) {
        int recovtime = being.getRecov_time();
        if (recovtime <= 3) {
            being.setRecov_time();
        } else {
            being.setState(State.HEALTHY);
            being.AddAntibody(being.getVirus());
        }
    }

    double CalRate(double rate) {
        BigDecimal b = new BigDecimal(rate);
        double rate1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double rate2 = rate1 * 1000 + 1;
        return rate2;

    }

    void SetMap() {
        count.clear();
        for (int i = 1; i <= colupsize; i++) {
            for (int j = 1; j <= rowupsize; j++) {
                Location location = new Location(i, j);
                count.put(location, new ArrayList<Being>());
            }
        }
        for (Being being : beings) {
            int col = being.getLocation().getCol();
            int row = being.getLocation().getRow();
            for (Location location : count.keySet()) {
                if (location.getRow() == row && location.getCol() == col) {
                    count.get(location).add(being);
                }
            }
        }
    }

    Map<String, int[]> CountAllState() {
       Map<String,int[]> countstate = new HashMap<>();
        int[] duck = new int[6];
        int[] human = new int[6];
        int[] pig = new int[6];
        int[] chicken = new int[6];
        countstate.put("human",human);
        countstate.put("duck",duck);
        countstate.put("pig",pig);
        countstate.put("chicken",chicken);
        for (Being being : beings) {
            switch (being.getState()) {
                case HEALTHY:
                    countstate.get(WhichBeing(being))[0]++;
                    break;
                case CONTA_SICK:
                    countstate.get(WhichBeing(being))[1]++;
                    break;
                case CONTAGIOUS:
                    countstate.get(WhichBeing(being))[2]++;
                    break;
                case DEAD:
                    countstate.get(WhichBeing(being))[3]++;
                    break;
                case RECOVERING:
                    countstate.get(WhichBeing(being))[4]++;
                    break;
                case INFECTED:
                    countstate.get(WhichBeing(being))[5]++;
                    break;
                default:
            }
        }
        return countstate;
    }
    void coutloc(){
        int i = 0;
        for (Location location : count.keySet()) {
            i = i+ count.get(location).size();
        }
        System.out.println(i);
    }
    String WhichBeing(Being being){
        if (being instanceof Human){
           return "human";
        }else if (being instanceof Duck){
            return "duck";
        }else if (being instanceof Pig){
            return "pig";
        }else {
            return "chicken";
        }
    }
    void PrintResult(String being){
        System.out.println("Today have "+ CountAllState().get(being)[0]+" healthy "+being);
        System.out.println("Today have "+ CountAllState().get(being)[1]+" sick and contagious "+being);
        System.out.println("Today have "+ CountAllState().get(being)[2]+" contagious but not sick "+being);
        System.out.println("Today have "+ CountAllState().get(being)[3]+" dead "+being);
        System.out.println("Today have "+ CountAllState().get(being)[4]+" humans in "+being);
        int infected = CountAllState().get(being)[5]+ CountAllState().get(being)[1]+ CountAllState().get(being)[2];
        System.out.println("Today have "+ infected+" infected "+being+"\n");
    }
    public static int[] getsize(){
        int[] size = new int[3];
        size[0] = colupsize;
        size[1] = rowupsize;
        return size;
    }
    public void SetSize(int col,int row){
        this.colupsize = col;
        this.rowupsize = row;
    }
}



