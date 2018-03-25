/**
 * @Author: WANG ZEYAO
 * @Description:
 * @Date: 2018/2/23  9:52
 * @ProjectName: Flu
 * @Version: 1.0
 */
public enum Virus {
    H3N2("h3n2",0.1),H1N1("h1n1",0.2),H1N2("h1n2",0.2),H3N3("h3n3",0.3),H0N0("h0n0",0.9);
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getContag_rate() {
        return contag_rate;
    }

    public void setContag_rate(double contag_rate) {
        this.contag_rate = contag_rate;
    }

    private double contag_rate;
    Virus(String name,double contag_rate) {
        this.name = name;
        this.contag_rate = contag_rate;
    }
}
