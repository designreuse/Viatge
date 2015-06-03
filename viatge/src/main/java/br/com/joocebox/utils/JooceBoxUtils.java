package br.com.joocebox.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.com.joocebox.model.Role;

public class JooceBoxUtils {
	
	public Map<Role, String> getListOfSytemRoles(){
		Map<Role, String> roleMap = new HashMap<Role, String>();
		for (Role role : Arrays.asList(Role.values())) {
			if(!Role.ROLE_MASTER.equals(role))
			roleMap.put(role, role.getRole());
		}
		return roleMap;
	}
	
	public void validForm(BindingResult result, ModelMap model) {
		List<String> error = new ArrayList<String>();
		List<ObjectError> allErrors = result.getAllErrors();
		for (ObjectError objectError : allErrors) {
			String objectName = objectError.getDefaultMessage();
			error.add(objectName);
		}
		model.put("errors", error);
		model.put("validator", true);
	}

}
