package instrumentation;

import java.lang.instrument.Instrumentation;

public class Premain {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("now pre main");
        inst.addTransformer(new Transform());
    }
}
