package cafemanagement.serviceimpl;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cafemanagement.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
