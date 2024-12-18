package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import hello.proxy.config.v1_proxy.InterfaceProxyConfig;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class) // 원하는 컨피그를 정의하기 위해 설정
//@Import({AppV1Config.class, AppV2Config.class}) // 원하는 컨피그를 정의하기 위해 설정
@Import(InterfaceProxyConfig.class) //Porxy 등록
@SpringBootApplication(scanBasePackages = "hello.proxy.app.v3") // ComponentScan 위치를 지정하여 필요한부분만 스캔
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}
