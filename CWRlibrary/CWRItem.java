package CWRlibrary;

import java.io.*;
import java.util.ArrayList;

public class CWRItem extends CWRBase {

    public CWRItem(String path){
        super(path);
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

    private void write(String text){
        try {
            File file = new File(this.path);
            if(!file.exists())
                file.createNewFile();

            PrintWriter pw = new PrintWriter(file);

            pw.print(text);
            pw.close();
        }catch (IOException exception){
            System.out.println("Error!" + exception);
        }
    }

    public String getItemLine(String item){
        return readAll().split("<" + item + ">")[1].split("</" + item + ">")[0];
    }

    public Integer getItemInt(String item){
        return Integer.parseInt(getItemLine(item));
    }

    public Float getItemFloat(String item){
        return Float.parseFloat(getItemLine(item));
    }

    public Double getItemDouble(String item){
        return Double.parseDouble(getItemLine(item));
    }

    public Boolean getItemBoolean(String item){
        return Boolean.parseBoolean(getItemLine(item));
    }

    public Byte getItemByte(String item){
        return Byte.parseByte(getItemLine(item));
    }

    public Short getItemShort(String item){
        return Short.parseShort(getItemLine(item));
    }

    public String[] getItems(){
        String[] i_item_1_a = readAll().split("</");
        ArrayList<String> i_item_1_l = new ArrayList<>();

        for(String i:i_item_1_a)
            i_item_1_l.add(i.split(">")[0]);

        i_item_1_l.remove(0);
        String[] i_item_2_a = new String[i_item_1_l.size()];

        for(int i=0;i<i_item_1_l.size();i++){
            i_item_2_a[i] = i_item_1_l.get(i);
        }

        return i_item_2_a;
    }

    public void removeItem(String name){
        if(this.containsItem(name))
            this.write(this.readAll().split("<" + name + ">")[0] + this.readAll().split("</" + name + ">")[1]);
    }

    public boolean containsItem(String name){
        for(String i:this.getItems()){
            if(i.equals(name))
                return true;
        }
        return false;
    }



    public void appendItem(String name, String value){
        if(!this.containsItem(name))
            this.write(readAll() + "<" + name + ">" + value + "</" + name + ">");
    }
    public void appendItem(String name, Integer value){
        if(!this.containsItem(name))
            this.write(readAll() + "<" + name + ">" + value + "</" + name + ">");
    }
    public void appendItem(String name, Float value){
        if(!this.containsItem(name))
            this.write(readAll() + "<" + name + ">" + value + "</" + name + ">");
    }
    public void appendItem(String name, Double value){
        if(!this.containsItem(name))
            this.write(readAll() + "<" + name + ">" + value + "</" + name + ">");
    }
    public void appendItem(String name, Short value){
        if(!this.containsItem(name))
            this.write(readAll() + "<" + name + ">" + value + "</" + name + ">");
    }
    public void appendItem(String name, Byte value){
        if(!this.containsItem(name))
            this.write(readAll() + "<" + name + ">" + value + "</" + name + ">");
    }
    public void appendItem(String name, Boolean value){
        if(!this.containsItem(name))
            this.write(readAll() + "<" + name + ">" + value + "</" + name + ">");
    }


    public void SetOrAddItem(String name, String value){
        if(this.containsItem(name))
            this.setItem(name, value);
        else
            this.addItem(name, value);
    }
    public void SetOrAddItem(String name, Integer value){
        if(this.containsItem(name))
            this.setItem(name, value);
        else
            this.addItem(name, value);
    }
    public void SetOrAddItem(String name, Float value){
        if(this.containsItem(name))
            this.setItem(name, value);
        else
            this.addItem(name, value);
    }
    public void SetOrAddItem(String name, Double value){
        if(this.containsItem(name))
            this.setItem(name, value);
        else
            this.addItem(name, value);
    }
    public void SetOrAddItem(String name, Byte value){
        if(this.containsItem(name))
            this.setItem(name, value);
        else
            this.addItem(name, value);
    }
    public void SetOrAddItem(String name, Boolean value){
        if(this.containsItem(name))
            this.setItem(name, value);
        else
            this.addItem(name, value);
    }
    public void SetOrAddItem(String name, Short value){
        if(this.containsItem(name))
            this.setItem(name, value);
        else
            this.addItem(name, value);
    }


    public void addItem(String name, String value){
        if(!this.containsItem(name))
            this.write("<" + name + ">" + value + "</" + name + ">\n" + readAll());
    }
    public void addItem(String name, Integer value){
        if(!this.containsItem(name))
            this.write("<" + name + ">" + value + "</" + name + ">\n" + readAll());
    }
    public void addItem(String name, Float value){
        if(!this.containsItem(name))
            this.write("<" + name + ">" + value + "</" + name + ">\n" + readAll());
    }
    public void addItem(String name, Double value){
        if(!this.containsItem(name))
            this.write("<" + name + ">" + value + "</" + name + ">\n" + readAll());
    }
    public void addItem(String name, Boolean value){
        if(!this.containsItem(name))
            this.write("<" + name + ">" + value + "</" + name + ">\n" + readAll());
    }
    public void addItem(String name, Byte value){
        if(!this.containsItem(name))
            this.write("<" + name + ">" + value + "</" + name + ">\n" + readAll());
    }
    public void addItem(String name, Short value){
        if(!this.containsItem(name))
            this.write("<" + name + ">" + value + "</" + name + ">\n" + readAll());
    }



    public void setItem(String name, String value){
        String value_ = String.valueOf(value);
        if(this.containsItem(name))
            this.write(this.readAll().split("<" + name + ">")[0] + "<" + name + ">" + value_ + "</" + name + ">" + this.readAll().split("</" + name + ">")[1]);
    }
    public void setItem(String name, int value){
        String value_ = String.valueOf(value);
        if(this.containsItem(name))
            this.write(this.readAll().split("<" + name + ">")[0] + "<" + name + ">" + value_ + "</" + name + ">" + this.readAll().split("</" + name + ">")[1]);
    }
    public void setItem(String name, float value){
        String value_ = String.valueOf(value);
        if(this.containsItem(name))
            this.write(this.readAll().split("<" + name + ">")[0] + "<" + name + ">" + value_ + "</" + name + ">" + this.readAll().split("</" + name + ">")[1]);
    }
    public void setItem(String name, double value){
        String value_ = String.valueOf(value);
        if(this.containsItem(name))
            this.write(this.readAll().split("<" + name + ">")[0] + "<" + name + ">" + value_ + "</" + name + ">" + this.readAll().split("</" + name + ">")[1]);
    }
    public void setItem(String name, short value){
        String value_ = String.valueOf(value);
        if(this.containsItem(name))
            this.write(this.readAll().split("<" + name + ">")[0] + "<" + name + ">" + value_ + "</" + name + ">" + this.readAll().split("</" + name + ">")[1]);
    }
    public void setItem(String name, boolean value){
        String value_ = String.valueOf(value);
        if(this.containsItem(name))
            this.write(this.readAll().split("<" + name + ">")[0] + "<" + name + ">" + value_ + "</" + name + ">" + this.readAll().split("</" + name + ">")[1]);
    }
    public void setItem(String name, byte value){
        String value_ = String.valueOf(value);
        if(this.containsItem(name))
            this.write(this.readAll().split("<" + name + ">")[0] + "<" + name + ">" + value_ + "</" + name + ">" + this.readAll().split("</" + name + ">")[1]);
    }

}
