import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class PlayersCSV {

    private final String path = "./files/players.csv";
    private HashMap<String, String> players = new HashMap<>();

    public void putIntoHashmap(){
        String line;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null){
                String[] values = line.split(";");
                players.put(values[0],values[1]);
                System.out.println("Naam: " + values[0] + ", Points: " + values[1]);
            }
            System.out.println(players);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void searchPlayer(String name, String points){
            players.put(name, points);
            System.out.println(players);
    }

    public void deletePlayer(String name){
        Iterator<String> it = players.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            if(Objects.equals(key, name)){
                players.remove(key);
            }
        }
    }

    public void writeToFile(){
        try {
            new FileWriter(path, false).close();
            File csvFile = new File(path);
            PrintWriter out = new PrintWriter(csvFile);
            Iterator<Map.Entry<String, String>> it = players.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<String, String> pair = it.next();
                out.printf("%s;%s\n", pair.getKey(), pair.getValue());
            }
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
