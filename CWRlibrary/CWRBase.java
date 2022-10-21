package CWRlibrary;

public class CWRBase {

    protected String path;
    protected String bufferText;

    public CWRBase(String path){
        this.path = path;
        this.bufferText = "";
    }

    public String getBufferText(){
        return bufferText;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

}
