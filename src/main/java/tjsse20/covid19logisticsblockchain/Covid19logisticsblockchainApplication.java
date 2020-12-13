package tjsse20.covid19logisticsblockchain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("tjsse20.covid19logisticsblockchain.mapper")
@SpringBootApplication
public class Covid19logisticsblockchainApplication {

    public static void main(String[] args) {
        SpringApplication.run(Covid19logisticsblockchainApplication.class, args);
    }

}
