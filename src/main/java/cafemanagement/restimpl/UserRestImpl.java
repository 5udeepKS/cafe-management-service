package cafemanagement.restimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cafemanagement.constants.CafeConstants;
import cafemanagement.rest.UserRest;
import cafemanagement.service.UserService;
import cafemanagement.utils.CafeUtils;

@RestController
public class UserRestImpl implements UserRest {
	
	@Autowired
	private UserService userService;
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		try {
			return userService.signUp(requestMap);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
