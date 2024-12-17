package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class) // 원하는 컨피그를 정의하기 위해 설정
@Import({AppV1Config.class, AppV2Config.class}) // 원하는 컨피그를 정의하기 위해 설정
@SpringBootApplication(scanBasePackages = "hello.proxy.app.v3") // ComponentScan 위치를 지정하여 필요한부분만 스캔
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

}
