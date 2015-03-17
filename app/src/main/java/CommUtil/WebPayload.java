package CommUtil;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.net.URLEncoder;
/**
 * Created by tdunham on 3/12/2015.
 *
 * Class used to contain any payload data needed to send in web request
 */
public class WebPayload {

    private String m_PayloadData = "";
    public String getPayloadData(){return this.m_PayloadData;}

    public void BuildPayload(List<WebRequestPair> WebRequestCollection) throws UnsupportedEncodingException{

        int i=0;

        try {
            for(WebRequestPair currentRequest : WebRequestCollection ){

                String Encoding = currentRequest.getEncoding();
                String RequestParameter = currentRequest.getRequestParameter();
                String RequestValue = currentRequest.getRequestValue();

                if (i<1){
                    this.m_PayloadData += URLEncoder.encode(RequestParameter, Encoding) + "=" + URLEncoder.encode(RequestValue, "UTF-8");
                    i+=1;
                }else{
                    this.m_PayloadData += "&" + URLEncoder.encode(RequestParameter, Encoding) + "=" + URLEncoder.encode(RequestValue, "UTF-8");
                }
            }
        }
        catch(Exception e){
            throw e;
        }
    }
}
