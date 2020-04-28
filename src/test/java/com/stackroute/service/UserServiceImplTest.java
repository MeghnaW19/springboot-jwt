//package com.stackroute.service;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import java.util.Optional;
//import com.stackroute.domain.User;
//import com.stackroute.exception.UserAlreadyExistException;
//import com.stackroute.exception.UserNotFoundException;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import com.stackroute.repo.UserRepository;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//public class UserServiceImplTest {
//
//
//	@Mock
//	private UserRepository repository;
//
//	private User user;
//
//	@InjectMocks
//	private UserServiceImpl userService;
//
//	Optional<User> mockResult;
//
//	@BeforeEach
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		user = new User("mainkandankasi", "P@ssw0rd", "Manikandan", "Kasi");
//		mockResult = Optional.of(user);
//	}
//
//	@AfterEach
//	public void tearDown() {
//		user = null;
//		mockResult = null;
//	}
//
//	@Test
//	public void testRegisterUser() throws Exception{
//		when(repository.save(Mockito.any(User.class))).thenReturn(user);
//		boolean flag =userService.saveUser(user);
//		boolean value = true;
//		assertEquals(value, flag);
//		verify(repository, times(1)).save(user);
//	}
//
//	@Test
//	public void testRegisterFailure() throws UserAlreadyExistException, Exception{
//		when(repository.findById(user.getId())).thenReturn(mockResult);
//		when(repository.save(Mockito.any(User.class))).thenReturn(user);
//		userService.saveUser(user);
//	}
//
//	@Test
//	public void testValidationSucces() throws Exception{
//		when(repository.findByUserIdAndPassword(user.getId(), user.getPassword())).thenReturn(user);
//		User result = repository.findByUserIdAndPassword(user.getId(), user.getPassword());
//		assertNotNull(result);
//		assertEquals(user.getId(), result.getId());
//		verify(repository, times(1)).findByUserIdAndPassword(user.getId(), user.getPassword());
//	}
//
//	@Test
//	public void testValidationFailure() throws Exception, UserNotFoundException{
//		when(repository.findById("Anitha")).thenReturn(null);
//		userService.findByUserIdAndPassword(user.getId(), user.getPassword());
//	}
//}
