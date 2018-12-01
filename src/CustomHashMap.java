import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CustomHashMap implements Map {
    private static final int N = 16;
    private Node[] array;

    public CustomHashMap() {
        array = new Node[N];
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer action) {

    }

    @Override
    public void replaceAll(BiFunction function) {

    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(Object key, Object oldValue, Object newValue) {
        return false;
    }

    @Override
    public Object replace(Object key, Object value) {
        return null;
    }

    @Override
    public Object computeIfAbsent(Object key, Function mappingFunction) {
        return null;
    }

    @Override
    public Object computeIfPresent(Object key, BiFunction remappingFunction) {
        return null;
    }

    @Override
    public Object compute(Object key, BiFunction remappingFunction) {
        return null;
    }

    @Override
    public Object merge(Object key, Object value, BiFunction remappingFunction) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return getArrayValue(key) == null ? false : true;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        if (!containsKey(key)) {
           return  null;
        }

        return  getArrayValue(key).getByKey(key);
    }

    @Override
    public Object put(Object key, Object value) {
        Node newNode = new Node(key, value);
        if (!containsKey(key)) {
            array[(N - 1) & key.hashCode()] = newNode;
        } else {
            Node node = array[(N - 1) & key.hashCode()];
            if(node.getByKey(key) != null){
                node.replace(key, value);
            } else {
                node.addNext(newNode);
            }

        }
        return newNode;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    private Node getArrayValue(Object key) {
        return array[(N - 1) & key.hashCode()];
    }

    class Node {
        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public boolean replace(Object key, Object value) {
            if (this.key.equals(key)) {
                this.value = value;
                return true;
            }
            if(next == null){
                return false;
            }
            return replace(key, value);
        }

        public Object getByKey(Object key) {
            if (this.key.equals(key)) {
                return value;
            }
            if(next == null){
                return null;
            }
            return getByKey(key);
        }

        public void addNext(Node node){
            this.next = node;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
