import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {

    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();

 }

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack =  new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList)
    {
        for(int i=nestedList.size()-1;i>-1;i--)
            stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        while (!stack.isEmpty())
        {
            NestedInteger cur = stack.peek();
            if(cur.isInteger())
                return true;

            cur = stack.pop();
            for (int i=cur.getList().size()-1;i>-1;i--)
                stack.push(cur.getList().get(i));
        }

        return false;
    }

    public static void main(String args[])
    {

    }
}
