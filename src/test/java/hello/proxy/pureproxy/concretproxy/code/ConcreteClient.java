package hello.proxy.pureproxy.concretproxy.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConcreteClient {

    private final ConcreteLogic concreteLogic;

    public void execute() {
        concreteLogic.operation();
    }
}
