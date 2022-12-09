package util;

public class DinamicList<T> {

    private int length;

    private Object[] values;

    public DinamicList() {
        this.length = 0;
        this.values = new Object[length];
    }

    public T[] getValues() {
        return (T[]) values;
    }

    public int getLength() {
        return length;
    }

    public void preprend(T value) {
        T[] copy = (T[]) values;
        values = new Object[++length];
        System.arraycopy(copy, 0, values, 1, copy.length);

        values[0] = value;
    }

    public void append(T Value){
        T[] copy = (T[])values;
        values = new Object[++length];
        System.arraycopy(copy, 0, values, 0, copy.length);

        values[length-1] = Value;
    }

    public boolean removeFirst(T value){
        int pos = contains(value);

        if(pos == -1) return false;

        T[] copy = (T[]) values;
        values = new Object[--length];

        for (int i = 0, j = 0; i < copy.length; i++) {
            if(i == pos)
                continue;

            values[j++] = copy[i];
        }
        
        return true;
    }

    public int contains(T value) {
        int pos = -1;

        for (int i = 0; i < values.length; i++) {
            if(values[i] == value){
                pos = i;
                break;
            }
        }
        return pos;
    }


}
