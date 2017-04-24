public class StringVisitor<E> implements Visitor<E>
{
    private String str;            // data member to collect the visited items

    public StringVisitor()
    {
        str = "";
    }

    public void visit(E item)      // required method from the Visitor interface
    {
        str += item + " ";         // append current item to overall string
    }

    public String getValue()       // use after the traversal to get the overall string
    {
        return "[" + str.trim() + "]";
    }
}