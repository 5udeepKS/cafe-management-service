package cafemanagement.serviceimpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cafemanagement.constants.CafeConstants;
import cafemanagement.dao.UserDao;
import cafemanagement.model.User;
import cafemanagement.service.UserService;
import cafemanagement.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceimpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		log.info("Inside signup {}", requestMap);
		try {
			if(validateSignUpMap(requestMap)) {
				User user =  userDao.findByEmailId(requestMap.get("email"));
				if(Objects.isNull(user)) {
					userDao.save(getUserFromMap(requestMap));
					return CafeUtils.getResponseEntity(CafeConstants.SUCCESSFULLY_REGISTERED, HttpStatus.OK);
				} else {
					return CafeUtils.getResponseEntity(CafeConstants.EMAIL_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
				}
			} else {
				return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.BAD_REQUEST);	
	}
	
	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && 
		requestMap.containsKey("email") && requestMap.containsKey("password")) {
			return true;
		} 
		return false;
	}
	
	private User getUserFromMap(Map<String, String> requestMap) {
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setStatus(requestMap.get("false"));
		user.setRole(requestMap.get("user"));
		return user;
	}
	
}
