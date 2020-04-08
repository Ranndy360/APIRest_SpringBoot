package com.sv.applaudo.studio.movies;

import com.sv.applaudo.studio.movies.model.Users;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.Assert.assertEquals;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
class MoviesApplicationTests extends AbstractTest{

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getToken() throws Exception
	{

		String uri = "/login";
		Users account = new Users( "randy.adonis@applaudostudio.com", "DemoPassword");

		String inputJson = super.mapToJson(account);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Toke is created successfully");
	}

}
