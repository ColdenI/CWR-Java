package CWRlibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CWRElement extends CWRItem {
    private String element;

    public CWRElement(String path, String element){
        super(path);
        this.element = element;
    }

    public String getElement(){
        return this.element;
    }
    public void setElement(String element){
        this.element = element;
    }

    private String readAll(){
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(this.path));
            String line, lines = "";

            while ((line = br.readLine()) != null){
                lines += line + "\n";
            }
            bufferText = lines;
            return lines;
        }catch (IOException exception){
            System.out.println("Error!" + exception);
            return "";
        }finally {
            try{
                br.close();
            }catch (IOException exception){
                System.out.println("Error!" + exception);
            }
        }
    }


    @Override
     public String getItemLine(String item){
        return readAll().split(element)[1].split("end.")[0].split("<" + item + ">")[1].split("</" + item + ">")[0];
    }
    @Override
    public Integer getItemInt(String item){
        return Integer.parseInt(this.getItemLine(item));
    }
    @Override
    public Float getItemFloat(String item){
        return Float.parseFloat(this.getItemLine(item));
    }
    @Override
    public Double getItemDouble(String item){
        return Double.parseDouble(this.getItemLine(item));
    }
    @Override
    public Boolean getItemBoolean(String item){
        return Boolean.parseBoolean(this.getItemLine(item));
    }
    @Override
    public Byte getItemByte(String item){
        return Byte.parseByte(this.getItemLine(item));
    }
    @Override
    public Short getItemShort(String item){
        return Short.parseShort(this.getItemLine(item));
    }



}
