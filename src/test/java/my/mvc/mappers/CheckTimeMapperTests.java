package my.mvc.mappers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@SpringBootTest
public class CheckTimeMapperTests {

    // timeCheck 를 위한 test
    @Autowired
    private CheckTimeMapper checkTimeMapper;

    @Test
    @Commit
    @Transactional
    public void timeCheck() {
        log.info("=======================");
        log.info("=======================");
        log.info(checkTimeMapper.getTime());
        log.info("=======================");
        log.info("=======================");
    }
}
