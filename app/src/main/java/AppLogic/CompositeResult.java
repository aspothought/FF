package AppLogic;

/**
 * Created by tdunham on 3/12/2015.
 */
public class CompositeResult {
    private boolean m_BooleanResult = false;
    private String m_ResultText = "";

    public void setBooleanResult(boolean booleanResult){
        this.m_BooleanResult = booleanResult;
    }

    public void setResultText(String resultText){
        this.m_ResultText = resultText;
    }

    public String getResultText(){
        return this.m_ResultText;
    }

    public boolean getBooleanResult(){
        return this.m_BooleanResult;
    }

    public void ConsumeException(Exception e){
        this.m_BooleanResult = false;
        this.m_ResultText = e.getMessage();
    }
}
