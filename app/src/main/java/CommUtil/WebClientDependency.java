package CommUtil;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;

import AppLogic.CompositeResult;

/**
 * Created by tdunham on 3/12/2015.
 */
public class WebClientDependency {

    private URLConnection m_Connection;
    private URL m_Url;
    private WebPayload m_WebPayload;

    public WebClientDependency(){}
    public WebClientDependency(URL RequestURL, WebPayload webPayload){
        this.m_Url = RequestURL;
        this.m_WebPayload = webPayload;
    }

    public CompositeResult GetPostData(){
        CompositeResult postResult = new CompositeResult();

        try{
            this.m_Connection = this.m_Url.openConnection();
            this.m_Connection.setDoOutput(true);

            OutputStreamWriter webResultWriter = new OutputStreamWriter(this.m_Connection.getOutputStream());
            webResultWriter.write(this.m_WebPayload.getPayloadData());
            webResultWriter.flush();

            postResult.setResultText(this.WriteOutputData());

        }
        catch(Exception e){
            e.printStackTrace();
            postResult.ConsumeException(e);
        }

        return  postResult;
    }

    private String WriteOutputData() throws IOException{
        String outputData = "";

        try{
            BufferedReader webResultReader = new BufferedReader(new InputStreamReader(this.m_Connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = webResultReader.readLine()) != null){sb.append(line); break;}

            outputData = sb.toString();
            Log.d("OUTPU DATA", outputData);

        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }

        return outputData;
    }

}
