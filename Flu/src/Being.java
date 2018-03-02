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
    private List<State> state = new ArrayList();
     Location location;
    private boolean IsVaccinal;

    public Being(int age,boolean isMale,ArrayList state,Location location,boolean isVaccinal){
        this.age = age;
        this.IsMale = isMale;
        this.state = state;
        this.location = location;
        this.IsVaccinal = isVaccinal;
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

    public List<State> getState() {
        return state;
    }

    public void setState(ArrayList state) {
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
