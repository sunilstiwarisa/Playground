package io.learn.demo;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.learn.demo.domain.Car;

//@RunWith(SpringJUnit4ClassRunner)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getCars_returnsCarDetails() throws Exception {

		// arrange

		// act
		ResponseEntity<Car> response = restTemplate.getForEntity("/cars/kia", Car.class) ;


		// assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getName()).isEqualTo("Kia");
		assertThat(response.getBody().getType()).isEqualTo("Petrol DCT");


	}

}
