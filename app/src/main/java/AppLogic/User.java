package AppLogic;

import android.util.Log;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import CommUtil.RequestDataFactory;
import CommUtil.WebClientDependency;
import CommUtil.WebPayload;
import CommUtil.WebRequestController;
import CommUtil.WebRequestPair;

/**
 * Created by tdunham on 3/13/2015.
 */
public class User {
    private String m_Username = "";
    private String m_Password = "";

    public User(String Username, String Password){
        this.m_Username = Username;
        this.m_Password = Password;
    }

    public String getUsername(){return this.m_Username;}
    public String getPassword(){return this.m_Password;}

    public CompositeResult Login(){

        CompositeResult LoginResult = new CompositeResult();

        try{

            List<WebRequestPair> requestData = new ArrayList<WebRequestPair>();
            requestData = RequestDataFactory.BuildLoginRequestData(this);

            WebPayload wp = new WebPayload();
            wp.BuildPayload(requestData);

            URL loginUrl = new URL("http://www.aspothought.com/External/ff/processing/login.php");

            WebClientDependency RequestDependency = new WebClientDependency(loginUrl,wp);

            LoginResult =  new WebRequestController().execute(RequestDependency).get();


        }
        catch(Exception e){
            LoginResult.ConsumeException(e);
        }

        return LoginResult;

    }



}
