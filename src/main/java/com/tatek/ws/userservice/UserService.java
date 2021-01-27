package com.tatek.ws.userservice;

import com.tatek.ws.ui.model.request.UserDetailsRequestModel;
import com.tatek.ws.ui.model.response.UserRest;

public interface UserService {

	UserRest creatUser(UserDetailsRequestModel userDetails);
}
