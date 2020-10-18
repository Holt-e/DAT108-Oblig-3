import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Handleliste {
    public List<HandlelisteItem> items = Collections.synchronizedList(new ArrayList<>());

    public void addItem(HandlelisteItem item) {
        items.add(item);
    }

    public void removeItem(HandlelisteItem item) {
        items.remove(item);
    }

    public List<HandlelisteItem> getItems() {
        return items;
    }
}
