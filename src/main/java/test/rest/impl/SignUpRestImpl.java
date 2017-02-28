package test.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.model.to.SignUpTO;
import test.rest.SignUpRest;
import test.service.SignUpService;

@RestController
@RequestMapping(value = "/rest")
public class SignUpRestImpl implements SignUpRest {
	
	@Autowired
	private SignUpService signUpService;
	
	@Override
	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void signUpUser(@ModelAttribute SignUpTO signUpTO){
		signUpService.signUser(signUpTO);
	}

}
