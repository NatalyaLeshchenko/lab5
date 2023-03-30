import java.io.*;
import java.util.*;
/** This class implements working with a file: reading, writing, executing commands from a file*/
public class File {
    /**
     * This method reads from a file
     */
    public void fileReader(String file_name, Map<Long, Flat> map) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file_name));
        String line;
        while ((line = reader.readLine()) != null) {
            Flat flat =new Flat();
            if (flat.stringToFlat(line)==0)
                return;
            map.put(flat.getID(), flat);
        }

        reader.close();
    }
    /** This method writes to a file*/
    public void fileWriter(String file_name, Map<Long, Flat> map) throws IOException {
        BufferedWriter out
                = new BufferedWriter(new FileWriter(file_name));//"C:\\Users\\user\\Desktop\\fur.csv"
        for(Map.Entry <Long, Flat> entry: map.entrySet()) {
            out.write(entry.getValue().flatToString()+'\n');

        }
        out.close();

    }
    /**
     * This method executes commands from a file
     */
    public static void executeScript(String file_name, Map<Long,Flat> map) {
        String filename;
        System.out.println("Enter filename");
        filename=Parser.readString();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                line+=' ';
                int length=line.length();
                char[] tempLine = line.toCharArray();
                StringBuilder command= new StringBuilder();
                for(int i=0;i<length;i++)
                {
                    if(tempLine[i]!=' '&&tempLine[i]!='\n')
                        command.append(tempLine[i]);
                    else if(!command.toString().equals(""))
                    {
                        if((Switch.choice(command.toString(),file_name,map))==0)
                            return;
                        command = new StringBuilder();
                    }
                }
            }

            reader.close();
        }
        catch (Exception e){
            System.out.println("File has not been founded");
        }
    }
}

