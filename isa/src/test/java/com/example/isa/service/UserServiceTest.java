package com.example.isa.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.isa.model.Client;
import com.example.isa.repository.ClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Mock
	private ClientRepository clientRepositoryMock;
	
	@Mock
	private Client clientMock;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	public void testFindAll() {
		

		when(clientRepositoryMock.findAll()).thenReturn(Arrays.asList(clientMock));
		
		// 2. Akcija
		List<Client> students = clientRepositoryMock.findAll();
		
		// 3. Verifikacija: asertacije i/ili verifikacija interakcije sa mock objektima
		assertThat(students).hasSize(1);
	}

}
