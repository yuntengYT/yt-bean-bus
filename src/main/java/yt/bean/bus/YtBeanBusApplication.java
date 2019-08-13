package yt.bean.bus;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目主启动类
 *
 * @author yunteng
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class YtBeanBusApplication {

	public static void main(String[] args) {
		MDC.put("request-id", "-");
		SpringApplication.run(YtBeanBusApplication.class, args);
	}


}
