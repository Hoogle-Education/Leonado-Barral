package util;

public class DinamicList {

    private int length;

    private int[] values;

    public DinamicList() {
        this.length = 0;
        this.values = new int[length];
    }

    public int[] getValues() {
        return values;
    }

    public int getLength() {
        return length;
    }

    public void preprend(int value) {
        // TODO
    }

    public void append(int newValue){
        int[] copy = values;
        values = new int[++length];

//        for(int i = 0; i < copy.length; i++){
//            values[i] = copy[i];
//        }

        System.arraycopy(copy, 0, values, 0, copy.length);

        values[length-1] = newValue;
    }

    public boolean removeFirst(int value){
        int pos = contains(value);

        if(pos == -1) return false;

        int[] copy = values;
        values = new int[--length];

        for (int i = 0, j = 0; i < copy.length; i++) {
            if(i == pos)
                continue;

            values[j++] = copy[i];
        }
        
        return true;
    }

    public int contains(int value) {
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
