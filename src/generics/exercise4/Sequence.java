package generics.exercise4;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratik_s on 21/8/16.
 */
@Data
public class Sequence<T> {
    private List<T> items;

    public Sequence(Integer size) {
        // specifying capacity not size
        items = new ArrayList<T>(size);
    }

    public void add(T item){
        items.add(item);
    }

    public Selector getSequenceSelectorInstance() {
        return new SequenceSelector();
    }

    // inner class
    private class SequenceSelector implements Selector<Integer> {
        private Integer count = 0;

        @Override
        public Integer current() {
            return (Integer)items.get(count);
        }

        @Override
        public void next() {
            if(count < items.size()){
                count++;
            }
        }

        @Override
        public boolean end() {
            return count == items.size();
        }
    }

    public static void main(String[] args) {
        Sequence<Integer> sequence = new Sequence<Integer>(5);
        for (Integer i = 1; i <=5; ++i){
            sequence.add(i);
        }
        Selector sequenceSelector = sequence.getSequenceSelectorInstance();
        while(!sequenceSelector.end()){
            System.out.println(sequenceSelector.current());
            sequenceSelector.next();
        }
    }
}
