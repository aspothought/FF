package CommUtil;

/**
 * Created by tdunham on 3/12/2015.
 */
public class WebRequestPair {

    private String m_RequestParameter = "";
    private String m_RequestValue = "";
    private String m_Encoding  = "UTF-8";

    public void setRequestParameter(String requestParameter){this.m_RequestParameter = requestParameter;}
    public String getRequestParameter(){return this.m_RequestParameter;}

    public void setRequestValue(String requestValue){this.m_RequestValue = requestValue;}
    public String getRequestValue(){return this.m_RequestValue;}

    
    public void setEncoding(String encoding){this.m_Encoding = encoding;}
    public String getEncoding(){return this.m_Encoding;}


}
