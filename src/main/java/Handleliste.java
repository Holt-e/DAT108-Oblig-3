import java.util.ArrayList;
import java.util.List;

public class Handleliste {
    public String item;
    private ArrayList<String> liste;

    public Handleliste(){
        liste= new ArrayList<>();
    }
    public void add(String add){
        liste.add(item);
    }
    public void delete(String delete){
        liste.remove(item);
    }
    public ArrayList<String> getHandleliste(){
        return liste;
    }
}
