public class Quick
{
    public static void sort(int[] array)
    {
        sort(array, 0, array.length - 1);
    }
    private static void sort(int[] array, int low, int high)
    { 
        if (high <= low) return;
        int j = partition(array, low, high);
        sort(array, low, j-1);
        sort(array, j+1, high);
    }
    private static int partition(int[] array, int low, int high)
    {
        int i = low;
        int j = high + 1;
        int v = array[low];
        while (true)
        { 
            while (less(array[++i], v))
            {
                if (i == high) break;
            }
            while (less(v, array[--j])) 
            {
                if (j == low) break;      
            }
            if (i >= j) break;

            exch(array, i, j);
        }
        exch(array, low, j);

        return j;   
    }
    private static boolean less(Comparable v, Comparable w)
    {
        if (v == w) return false;  
        return v.compareTo(w) < 0;
    }
    private static void exch(int[] array, int i, int j)
    {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;  
    }
    private static boolean isSorted(int[] array)
    {
        return isSorted(array, 0, array.length - 1);   
    }
    private static boolean isSorted(int[] array, int low, int high)
    {
        for (int i = low + 1; i <= high; i++)
            if (less(array[i], array[i-1])) return false;
        return true;  
    }
    private static void show(int[] array)
    {
        for (int i=0; i<array.length ;i++ )
        {
            System.out.print(array[i]);  
        }
    }
    public static void main(String[] args)
    {
        int[] array = {3,9,4,2,5,6};
        System.out.println("Before Quick Sort");

        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
        } 
        Quick.sort(array);
        System.out.println("");
        System.out.println("After Quick Sort ");
        show(array);
        System.out.println("");
        assert isSorted(array);

    }

}