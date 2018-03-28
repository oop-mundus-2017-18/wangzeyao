import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WANG ZEYAO
 * @Description:
 * @Date: 2018/2/23  9:04
 * @ProjectName: Flu
 * @Version: 1.0
 */
public class Being {
    private int age;
    private boolean IsMale;
    private State state;
    Location location = new Location();
    private boolean IsVaccinal;
    private List<Virus> DNA_Flaw = new ArrayList<>();
    private List<Virus> Antibody = new ArrayList<>();
    private int inf_time;
    private int recov_time;
    private int conta_time;
    private int sick_time;

    public int getSick_time() {
        return sick_time;
    }

    public void setSick_time() {
        this.sick_time++;
    }

    public int getConta_time() {
        return conta_time;
    }

    public void setConta_time() {
        this.conta_time++;
    }

    public Virus getVirus() {
        return virus;
    }

    public void setVirus(Virus virus) {
        this.virus = virus;
    }

    private Virus virus = null;

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Virus> getDNA_Flaw() {
        return DNA_Flaw;
    }

    public void setDNA_Flaw(List<Virus> DNA_Flaw) {
        this.DNA_Flaw = DNA_Flaw;
    }

    public List<Virus> getAntibody() {
        return Antibody;
    }

    public void setAntibody(List<Virus> antibody) {
        Antibody = antibody;
    }

    public Being(int age, boolean isMale, State state, Location location, boolean isVaccinal, ArrayList dna, ArrayList antibody, Virus virus) {
        this.age = age;
        this.IsMale = isMale;
        this.state = state;
        this.location = location;
        this.IsVaccinal = isVaccinal;
        this.DNA_Flaw = dna;
        this.Antibody = antibody;
        this.virus = virus;
    }

    public int getAge() {
        return age;
    }

    public Being() {
    }

    public void setAge(int age) {
        this.age = age;

    }

    public boolean isMale() {
        return IsMale;
    }

    public void setMale(boolean male) {
        IsMale = male;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Location getLocation() {
        return location;
    }

//    public void ChangeLocation() {
//        this.location.ChangeLoc();
//    }

    public boolean isVaccinal() {
        return IsVaccinal;
    }

    public void setVaccinal(boolean vaccinal) {
        IsVaccinal = vaccinal;
    }


    public int getInf_time() {
        return inf_time;
    }

    public void setInf_time() {
        this.inf_time++;
    }

    public int getRecov_time() {
        return recov_time;
    }

    public void setRecov_time() {
        this.recov_time++;
    }
    void AddAntibody(Virus virus){
        Antibody.add(virus);
    }
    boolean CheckAntibody(Virus virus){
        for (Virus virus1 : Antibody) {
            if (virus1 == virus1){
                return true;
            }
        }
        return false;
    }
}
