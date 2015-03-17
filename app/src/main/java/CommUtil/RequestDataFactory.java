package CommUtil;

import java.util.ArrayList;
import java.util.List;

import AppLogic.User;

/**
 * Created by tdunham on 3/13/2015.
 */
public class RequestDataFactory {

private  static final String USERNAME_PARAMETER = "username";
private  static final String PASSWORD_PARAMETER = "password";

    public static List<WebRequestPair> BuildLoginRequestData(User userToLogin){
        List<WebRequestPair> requestData = new ArrayList<WebRequestPair>();

            try{

            WebRequestPair userRequestPair = new WebRequestPair();
            userRequestPair.setRequestParameter(USERNAME_PARAMETER);
            userRequestPair.setRequestValue(userToLogin.getUsername());
            requestData.add(userRequestPair);

            WebRequestPair passwordRequestPair = new WebRequestPair();
            passwordRequestPair.setRequestParameter(PASSWORD_PARAMETER);
            passwordRequestPair.setRequestValue(userToLogin.getPassword());
            requestData.add(passwordRequestPair);

        }
        catch(Exception e){
            throw e;
        }

        return requestData;
    }

}


