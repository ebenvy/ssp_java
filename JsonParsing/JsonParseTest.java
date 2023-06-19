package JsonParsing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.*;
public class JsonParseTest {
    private Gson gson;
    private TextFileReader reader;
    public JsonParseTest(){
        gson = new Gson();
        reader = new TextFileReader();
    }
    public void writeJson(String fileName){
        HashMap<Object, Object> map = new HashMap<Object, Object>();
        //number
        map.put("number",1);
        //string
        map.put("string","hello");
        //list
        List<Object> array = new ArrayList<Object>();
        HashMap<Object, Object> subMap = new  HashMap<Object, Object>();
        subMap.put("number",2);
        subMap.put("string","bye");
        array.add(subMap);
        map.put("array",array);

        FileWriter writer;
        try {
            writer = new FileWriter(fileName);
            writer.append(gson.toJson(map));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  

    }
    public void readJson(String fileName){
        String contents=this.reader.readFile(fileName);
        HashMap<Object, Object> map = this.gson.fromJson(contents,HashMap.class);
        printMap(map,0);

    }
    public void printMap(Map<Object,Object> map, int level){
        String padd ="";
        for(int i =0 ; i<level; i++){
            padd+="\t";
        }
        for(Entry<Object,Object> o: map.entrySet()){
            if(o.getKey().toString().equals("array")){
                List<Object> array =(List<Object>) o.getValue();
                System.out.println(padd+o.getKey()+" : ");
                for(Object obj: array){
                    printMap((Map<Object, Object>) obj,level+1);
                }

            }
            else
            {
              
                    
                System.out.println(padd+o.getKey()+" : "+o.getValue());
       
            }
               

        }
    }

    public static void main(String[] args){
        JsonParseTest tester = new  JsonParseTest();
        tester.writeJson("test.json");
        tester.readJson("test.json");

    }
}
