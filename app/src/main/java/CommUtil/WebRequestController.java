package CommUtil;

import android.os.AsyncTask;

import java.net.URL;

import AppLogic.CompositeResult;

/**
 * Created by tdunham on 3/12/2015.
 */
public class WebRequestController extends AsyncTask<WebClientDependency,Void,CompositeResult> {

    public CompositeResult doInBackground(WebClientDependency... Dependencies) {

        CompositeResult postResult = new CompositeResult();

        try {
            postResult = Dependencies[0].GetPostData();
        } catch (Exception e) {
            postResult.ConsumeException(e);
            e.printStackTrace();
        }

        return postResult;
    }
}
