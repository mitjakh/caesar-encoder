package caesarencoder;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Cypher cypher = new Cypher();
        View view = new View();
        Controller controller = new Controller(cypher, view);

        controller.run();
    }
}
