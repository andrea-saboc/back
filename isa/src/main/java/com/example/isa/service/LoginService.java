package com.example.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.isa.dto.LoginDTO;
import com.example.isa.dto.UserTokenState;
import com.example.isa.model.Client;
import com.example.isa.model.User;
import com.example.isa.repository.ClientRepository;
import com.example.isa.security.TokenUtils;

@Service
public class LoginService {

	@Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ClientRepository clientRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public UserTokenState logIn(LoginDTO authenticationRequest) {
        System.out.println("U LogIn metodi servisa");
        return getUserTokenState(authenticationRequest);
    }

/*
    public UserTokenState firstLogInPasswordChange(LoginDTO authenticationRequest) {
        User user = userRepository.findByEmail(authenticationRequest.getEmail());
        if (user.isEnabled()) {
            throw new UserAlreadyEnabled();
        }

        if (!passwordEncoder.matches(authenticationRequest.getOldPassword(), user.getPassword())) {
            throw new BadPasswordException();
        }
        if (isValidType(user)) {
            user.Enable();
            user.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
            userRepository.save(user);
            return getUserTokenState(authenticationRequest);
        } else {
            throw new BadUserInformationException();
        }
    }

    private boolean isValidType(User user) {
        return user.getClass() == SystemAdmin.class || user.getClass() == Supplier.class || user.getClass() == PharmacyAdmin.class ||
                user.getClass() == Pharmacist.class;
    }
*/
    private UserTokenState getUserTokenState(LoginDTO authenticationRequest) {
        System.out.println("U get user token state");
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));
        
        System.out.println("izasli iz auth");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        
        System.out.println("Ulogovani user");
        System.out.println(user.getEmail());
        
        
        String username = user.getUsername();
        String userType = user.getClass().getSimpleName();
        String accessToken = tokenUtils.generateToken(username);
        int accessExpiresIn = tokenUtils.getExpiredIn();
        return new UserTokenState(userType, accessToken, accessExpiresIn);
    }
    
    public boolean checkActivationCode(String code) {
    	
    	Client c = clientRepo.findByActivationCode(code);

    	System.out.println("Pronadjeni user je"+c.getName());
    	if(c!= null) {
    		if(c.isBlocked()) 
				return true;
    	}
    	return false;
    }
}
