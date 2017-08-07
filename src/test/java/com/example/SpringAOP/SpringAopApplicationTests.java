package com.example.SpringAOP;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.AppConfig;
import com.example.config.AspectConfig;
import com.example.entities.User;
import com.example.services.UserService;
import com.example.types.Role;
import com.example.ui.ComponentsForAdmin;
import com.example.ui.ComponentsForAdminAndGuest;
import com.example.ui.ComponentsForGuest;
import com.example.ui.ComponentsForWriter;
import com.example.ui.UIFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {AspectConfig.class, AppConfig.class})
public class SpringAopApplicationTests {
	
	@Autowired
	private UIFactory uiFactory;
	@Autowired
	private UserService userService;
	
	@Test
	public void adminTest() throws Exception {
		userService.setCurrentUser(new User(Role.ADMIN));
		Assert.assertNotNull(uiFactory.createComponent(ComponentsForAdmin.class));
		Assert.assertNotNull(uiFactory.createComponent(ComponentsForAdminAndGuest.class));
		Assert.assertNotNull(uiFactory.createComponent(ComponentsForGuest.class));
		Assert.assertNotNull(uiFactory.createComponent(ComponentsForWriter.class));
	}

}
