package application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import model.application.ApiRadioApplication;
import org.apache.log4j.Logger;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApiRadioApplication.class)
@WebAppConfiguration
public class ApiRadioApplicationTests {

    private static final Logger LOGGER = Logger.getLogger(ApiRadioApplicationTests.class);
    
	@Test
	public void contextLoads() {
	    LOGGER.info("testing annotations");
	}

}
