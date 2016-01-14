package pl.pwr.edu.controller;

import com.dropbox.core.DbxWebAuthNoRedirect;
import pl.pwr.edu.view.login.LoginForm;

import java.net.MalformedURLException;

/**
 * Created by SQUIER on 2016-01-14.
 */
public class LoginFormController {

    private DbxWebAuthNoRedirect webAuth;

    public LoginFormController(DbxWebAuthNoRedirect dbxWebAuthNoRedirect){
        webAuth = dbxWebAuthNoRedirect;
    }

    public void startAuthorization() throws MalformedURLException {
        LoginForm loginForm = new LoginForm();
        String authURL = webAuth.start();
        loginForm.setClickHereText(authURL);

        loginForm.showForm();
    }

}
