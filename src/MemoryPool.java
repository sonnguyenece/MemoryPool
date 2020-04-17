import java.util.ArrayList;
import java.util.LinkedList;

public abstract class MemoryPool<T> {

    private ArrayList<T> free_items = new ArrayList<>();

    public void freeItem(T item) {
        free_items.add(item);
    }

    protected abstract T allocate();

    public T newItem() {
        T out = null;
        if (free_items.size() == 0) {
            out = allocate();
        } else {
            out = free_items.get(0);
            free_items.remove(0);
        }
        return out;
    }
}
