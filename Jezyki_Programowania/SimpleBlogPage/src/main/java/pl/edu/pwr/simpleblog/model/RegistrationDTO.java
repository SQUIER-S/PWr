package pl.edu.pwr.simpleblog.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by SQUIER on 2015-12-20.
 */
@Getter
@Setter
public class RegistrationDTO {

    @NotEmpty
    @Size(min=3, max=45)
    public String login;

    @NotEmpty
    @Email
    public String userEmail;

    @NotEmpty
    @Size(min=8, max=45)
    public String password;

    @NotEmpty
    @Size(min=8, max=45)
    public String repeatedPassword;


}
