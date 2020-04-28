//
//package com.stackroute.controller;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.domain.User;
//import com.stackroute.configuration.JWTTokenGenerator;
//import com.stackroute.service.UserService;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
////@WebMvcTest(UserController.class)
//public class UserControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private UserService userService;
//
//	@MockBean
//	private JWTTokenGenerator securityTokenGenrator;
//
//	private User user;
//
//	@InjectMocks
//	private UserController userController;
//
//
//	@BeforeEach
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		user = new User("mainkandankasi", "P@ssw0rd", "Manikandan");
//
//	}
//
//	@AfterEach
//	public void tearDown() {
//		user = null;
//	}
//
//	public static String asJsonString(final Object obj) {
//		try {
//			return new ObjectMapper().writeValueAsString(obj);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//
//	@Test
//	public void testRegisterUser() throws Exception {
//		when(userService.saveUser(user)).thenReturn(true);
//		mockMvc.perform(post("/user/register").contentType(MediaType.APPLICATION_JSON)
//				.content(asJsonString(user))).andExpect(status().isCreated());
//		verify(userService, times(1)).saveUser(Mockito.any(User.class));
//		verifyNoMoreInteractions(userService);
//	}
//
//	@Test
//	public void testLoginUser()throws Exception {
//		when(userService.findByUserIdAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(user);
//		mockMvc.perform(post("/user/login").contentType(MediaType.APPLICATION_JSON)
//				.content(asJsonString(user))).andExpect(status().isOk());
//		verify(userService, times(1)).findByUserIdAndPassword(user.getId(), user.getPassword());
//		verifyNoMoreInteractions(userService);
//
//	}
//}
