import CITS2200.*;

public class StackBlock implements Stack{


    private Object[] items;

    private int first;
    private int last;
    /**
     * StackBlock Constructor
     */
    public StackBlock(int size) {
        items = new Object[size];
        first = 0;
        last = -1;
    }
    /**
     * Empty Checker
     */
    public boolean isEmpty() {
        return (first == last+1);
    }
    /**
     * Full Checker
     */
    public boolean isFull(){
        return (last == items.length -1);
    }
    /**
     * Queuing manipulator
     */
    public void push(Object o) throws Overflow {
        if (!isFull()){
            last++;
            items[last] = o;
        }
        else{
            throw new Overflow("Stack is Full");
        }
    }

    /**
     * Examine manipulator
     */
    public Object examine() throws Underflow {
        if (!isEmpty()){
            return items[last];
        }
        else{
            throw new Underflow("Stack is empty");
        }
    }

    /**
     * Dequeuing manipulator
     * note sudo code from lecture states that it should read
     * char a = items[first];
     * first++;
     * but method is object and first is never incremented and through error in quiz testing
     * stating it should be 3, 2, 1, 0 instead of 0, 1, 2, 3,
     */
    public Object pop() throws Underflow {
        if (!isEmpty()){
            Object a = items[last];
            last--;
            return a;
        }
        else{
            throw new Underflow("Stack is empty");
        }
    }
}
