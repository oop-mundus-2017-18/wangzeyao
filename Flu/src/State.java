/**
 * @Author: WANG ZEYAO
 * @Description:
 * @Date: 2018/2/23  9:08
 * @ProjectName: Flu
 * @Version: 1.0
 */
public enum State {
    HEALTHY("healthy"),INFECTED("infected"),SICK("sick"),RECOVERD("recovered"),DEAD("dead");
    private String state;
    State(String state) {
        this.state = state;
    };


}
