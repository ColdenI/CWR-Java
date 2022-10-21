package CWRlibrary;

import java.io.*;

public class CWRFile extends CWRBase {

    public CWRFile(String path){
        super(path);
    }

    public void createFile(){
        try {
            File file = new File(this.path);

            if(!file.exists())
                file.createNewFile();

        }catch (IOException exception){
            System.out.println("Error!" + exception);
        }
    }

    public void write(String text){
        try {
            File file = new File(this.path);
            this.createFile();

            PrintWriter pw = new PrintWriter(file);

            pw.print(text);
            pw.close();
        }catch (IOException exception){
            System.out.println("Error!" + exception);
        }
    }

    public String readLine(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.path));
            String line, lines = "";

            if ((line = br.readLine()) != null){
                bufferText = line;
                return line;
            }else
                return "";
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

    public String readAll(){
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

}
