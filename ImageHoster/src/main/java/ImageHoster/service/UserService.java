package ImageHoster.service;

import ImageHoster.model.User;
import ImageHoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    private static final String PASSWORD_PATTERN =
            "^(?=.*\\d)(?=.*[A-za-z])(?=.*[@#$%]).{1,20}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    @Autowired
    private UserRepository userRepository;
    //Call the registerUser() method in the UserRepository class to persist the user record in the database
    public void registerUser(User newUser) {
            if (isValidPassword(newUser.getPassword())) {
                newUser.setFlag(false);
                userRepository.registerUser(newUser);
            } else {
                newUser.setFlag(true);
            }
    }

    //Since we did not have any user in the database, therefore the user with username 'upgrad' and password 'password' was hard-coded
    //This method returned true if the username was 'upgrad' and password is 'password'
    //But now let us change the implementation of this method
    //This method receives the User type object
    //Calls the checkUser() method in the Repository passing the username and password which checks the username and password in the database
    //The Repository returns User type object if user with entered username and password exists in the database
    //Else returns null
    public User login(User user) {
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return existingUser;
        } else {
            return null;
        }
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = pattern.matcher(password);
        return ((Matcher) matcher).matches();
    }

}