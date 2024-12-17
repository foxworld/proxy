package hello.proxy.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TraceStatus {

    private TraceId traceId;
    private Long startTimeMs; // 시작시간 : 종료시 걸리는 시간을 계산하기 위함
    private String message;
}
