package hello.proxy.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
public class TraceId {
    private String id;
    private int level;

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private String createId() {
        // uuid 값중 앞 8자리만 사용함 -> 다쓰면 너무 김, 중복 무시 , 로그이기 때문에
        return UUID.randomUUID().toString().substring(0, 8);
    }

    // 다음 level를 생성하기 위함
    // traceId는 같지만 level 깊이를 하나 주기 위함
    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }
}
