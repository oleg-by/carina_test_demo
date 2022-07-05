package com.qaprosoft.carina.demo.mywebtests;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.web.services.LoginService;

public class BaseTest extends AbstractTest {

    protected final String USERNAME = "xxxxxx@xxxx.xx";
    protected final String PASSWORD = "xxxxxxx";
    protected LoginService loginService = new LoginService();

}
