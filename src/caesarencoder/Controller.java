package caesarencoder;

public class Controller
{
    private Cypher cypher;
    private View view;

    Controller(Cypher cypher, View view)
    {
        this.cypher = cypher;
        this.view = view;
    }

    public void run() throws Exception
    {
        cypher.setUserInput(view.initializeText());
        cypher.setKey(view.initializeKey());
        cypher.setCypheredText(cypher.cypherText());
        view.displayResult(cypher.getCypheredText());
        cypher.writeToFile(cypher.getCypheredText());
    }
}
