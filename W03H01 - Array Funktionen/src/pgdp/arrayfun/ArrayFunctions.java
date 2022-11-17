package pgdp.arrayfun;
import java.lang.Math;

import java.util.Arrays;

public class ArrayFunctions {

    protected ArrayFunctions() {
        throw new IllegalStateException("Don't create objects of type 'ArrayFunctions'!");
    }

    public static void main(String[] args) {
        //example call
        System.out.println(Arrays.toString(zip(new int[]{}, new int[]{})));
        int[][] array2d = new int[][]{{} , {}, {}};

        System.out.println(Arrays.toString(zipMany(array2d)));

        System.out.println(Arrays.toString(filter(new int[]{1, 2, 3, 4, 5, 6}, 7, 5)));

        rotate(new int[]{1}, 15);

        int []a = {30, 5};
        sumOfSquares(a);
    }

    /** Berechnet für das übergebene Array die Summe der Quadrate der Einträge.
     *  Gibt dabei einen Fehler aus und -1 zurück, wenn ein Overflow entsteht.
     *
     * @param array Ein beliebiges Integer-Array.
     * @return Die Summe der Quadrate, wenn diese in einen 'long' passt, -1 sonst.
     */
    public static long sumOfSquares(int[] array) {
        long summe = 0;
        long[] longArray = Arrays.stream(array).asLongStream().toArray();
        long max = 0;
        String message = "Overflow!";
        if(array.length==0){
            summe = 0;
        }
       if(array.length > 0){
         for(int i = 0; i < array.length; i++){
             summe = summe +longArray[i]*longArray[i];
             if (summe < max){
                 System.out.println(message);
                 summe = -1;
                 break;
             }
         }

           }
       System.out.println(summe);
       return summe;
       }




    /** Methode, die zwei Arrays zu einem verbindet, indem sie abwechselnd Einträge des ersten und des zweiten Input-
     *  Arrays verwendet.
     *
     * @param a Ein beliebiges Integer-Array.
     * @param b Ein beliebiges Integer-Array.
     * @return 'a' und 'b' zusammengezipped.
     */
    public static int[] zip(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while( j < a.length && k < b.length ) {
            result[i++] = a[j++];
            result[i++] = b[k++];
        }

        while( j < a.length )
            result[i++] = a[j++];

        while( k < b.length )
            result[i++] = b[k++];

        return result;
    }

    /** Methode, die eine beliebige Zahl an Arrays (dargestellt als Array von Arrays) zu einem einzigen Array verbindet,
     *  indem sie abwechselnd von jedem Array einen Eintrag nimmt, bis alle aufgebraucht sind.
     *
     * @param arrays Array von Integer-Arrays
     * @return Die Arrays in 'arrays' zusammengezipped
     */
    public static int[] zipMany(int[][] arrays) {
        int size = 0;

        for(int[] array : arrays) {
            size += array.length;
        }

        int[] result = new int[size];
        int r = 0, iterator = 0;
        boolean hasIteration;

        do {
            hasIteration = false;

            for (int[] array : arrays) {
                if (iterator >= array.length) continue;
                hasIteration = true;
                result[r++] = array[iterator];
            }

            iterator++;
        } while (hasIteration);

        return result;
    }

    /** Behält aus dem übergebenen Array nur die Einträge, die innerhalb der übergebenen Grenzen liegen.
     *  Gibt das Ergebnis als neues Array zurück.
     *
     * @param array Ein beliebiges Integer-Array
     * @param min Ein beliebiger Integer
     * @param max Ein beliebiger Integer
     * @return Das gefilterte Array
     */
    public static int[] filter(int[] array,int min,int max) {
        int size = 0;

        for(int element : array) {
            if(element >= min && element <= max) size++;
        }

        int r = 0;
        int[] result = new int[size];

        for(int element : array) {
            if(element >= min && element <= max) {
                result[r++] = element;
            }
        }

        return result;
    }

    /** Rotiert das übergebene Array um die übergebene Anzahl an Schritten nach rechts.
     *  Das Array wird In-Place rotiert. Es gibt keine Rückgabe.
     *
     * @param array Ein beliebiges Integer-Array
     * @param amount Ein beliebiger Integer
     */
    public static void rotate(int[] array, int amount) {
        int[] result = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            int pos = i + amount;

            while(pos < 0) {
                pos += array.length;
            }

            pos = pos % (array.length);

            result[pos] = array[i];
        }

        System.out.println(Arrays.toString(result));
    }

    /** Zählt die Anzahl an Vorkommen jeder Zahl im übergebenen Array, die in diesem mindestens einmal vorkommt.
     *  Die Rückgabe erfolgt über ein 2D-Array, bei dem jedes innere Array aus zwei Einträgen besteht: Einer Zahl,
     *  die im übergebenen Array vorkommt sowie der Anzahl an Vorkommen dieser.
     *  Für jede im übergebenen Array vorkommenden Zahl gibt es ein solches inneres Array.
     *  Diese tauchen im Rückgabewert in der gleichen Reihenfolge auf, in der die jeweils ersten Vorkommen der Zahlen
     *  im übergebenen Array auftauchen.
     *
     * @param array Ein beliebiges Integer-Array
     * @return Das Array mit den Vielfachheiten der einzelnen Zahlen, wiederum als Integer-Arrays mit zwei Einträgen dargestellt.
     */
    public static int[][] quantities(int[] array) {
        // TODO
        return null;
    }
}
