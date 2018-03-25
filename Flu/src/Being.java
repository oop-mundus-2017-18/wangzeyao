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
     Location location;
    private boolean IsVaccinal;
    private List<Virus> DNA_Flaw = new ArrayList<>();
    private List<Virus> Antibody = new ArrayList<>();
    private int event_time;

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

    public Being(int age, boolean isMale, State state, Location location, boolean isVaccinal, ArrayList dna, ArrayList antibody,int event_time,Virus virus){
        this.age = age;
        this.IsMale = isMale;
        this.state = state;
        this.location = location;
        this.IsVaccinal = isVaccinal;
        this.DNA_Flaw = dna;
        this.Antibody = antibody;
        this.event_time = event_time;
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
}
