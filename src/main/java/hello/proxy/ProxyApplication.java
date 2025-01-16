package hello.proxy;

import hello.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import hello.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import hello.proxy.config.v4_postprocessor.postprocessor.BeanPostProcessorConfig;
import hello.proxy.config.v5_autoproxy.AutoProxyConfig;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class}) // 원하는 컨피그를 정의하기 위해 설정
//@Import({InterfaceProxyConfig.class, ConcreteProxyConfig.class}) // 인터페이스를 이용한 proxy / 구체클래스를 로  proxy 구현
//@Import(DynamicProxyBasicConfig.class) // 동적프로시를 이용하여 남기는 config
//@Import(DynamicProxyFilterConfig.class) // 특정패턴만 로그를 남기는 Config
//@Import(ProxyFactoryConfigV1.class) // ProxyFactory interface 적용하는 config
//@Import(ProxyFactoryConfigV2.class) // ProxyFactory 구체클레스 cglib 적용하는 config
//@Import(BeanPostProcessorConfig.class)
@Import(AutoProxyConfig.class)
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
