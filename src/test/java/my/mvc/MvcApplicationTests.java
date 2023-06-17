package my.mvc;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@SpringBootTest
class MvcApplicationTests {

	// 의존성 주입
	@Autowired
	private DataSource dataSource;

	// dataBase 연결 확인을 위한 Test
	@Test
	public void dbConnectionTest() {
		try(Connection connection = dataSource.getConnection()) {
		log.info("======================= Yes Connection Ok =======================");
		} catch (Exception e) {
		log.info("====================== No Connection NOT Ok ======================");
			e.printStackTrace();
		}
	}
}
