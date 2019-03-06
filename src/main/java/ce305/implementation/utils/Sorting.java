package ce305.implementation.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static <T> ArrayList<T> selectionSort(Collection<T> source, Comparator<T> comparator) {
        ArrayList<T> array = new ArrayList<T>(source);
        for (int i = 0; i < array.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.size(); j++)
                if (comparator.compare(array.get(j), array.get(index)) < 0) 
                {
                    index = j;
                }
      
            T smallerItem = array.get(index);  
            array.set(index, array.get(i));
            array.set(i, smallerItem);
        }

        return array;
    }
}