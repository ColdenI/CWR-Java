package CWRlibrary;

public class CWRFileBase {

    protected String path;
    protected String bufferText;

    public CWRFileBase(String path){
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
