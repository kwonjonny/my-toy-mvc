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

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
	}

	// ConnectionTest
	@Test
	public void connectionTest() {
		try(Connection connection = dataSource.getConnection()) {
			log.info("==============================");
			log.info("==============================");
			log.info("connection" + connection);
			log.info("==============================");
			log.info("==============================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
