package caesarencoder;

import java.io.FileWriter;

public class Cypher
{
    private final int alphabetSize = 39;
    private int key;
    private String userInput;
    private String cypheredText;
    private final char[] defaultLowerAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z',
            '0','1','2','3','4','5','6','7','8','9',' ','.',','};
    private final char[] defaultUpperAlphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            '0','1','2','3','4','5','6','7','8','9',' ','.',','};

    public void setUserInput(String userInput)
    {
        this.userInput = userInput;
    }

    public void setKey(int key)
    {
        while (key < 0)
            key += alphabetSize;

        this.key = key;
    }

    public void setCypheredText(String cypheredText)
    {
        this.cypheredText = cypheredText;
    }

    public String getCypheredText()
    {
        return cypheredText;
    }

    public String cypherText()
    {
        char[] inputText = userInput.toCharArray();
        int inputSize = userInput.length();
        char[] cypheredText = new char[inputSize];
        int[] textArray = new int[inputSize];

        for (int i = 0; i < inputSize; i++)
        {
            if (Character.isUpperCase(inputText[i]))
            {
                for (int j = 0; j < alphabetSize; j++)
                {
                    if (inputText[i] == defaultUpperAlphabet[j])
                    {
                        textArray[i] = j;
                    }
                }

                if (textArray[i] + key > alphabetSize - 1)
                    textArray[i] = (textArray[i] + key) % alphabetSize;
                else
                    textArray[i] = textArray[i] + key;

                cypheredText[i] = defaultUpperAlphabet[textArray[i]];
            }
            else
            {
                for (int j = 0; j < alphabetSize; j++)
                {
                    if (inputText[i] == defaultLowerAlphabet[j])
                    {
                        textArray[i] = j;
                    }
                }

                if (textArray[i] + key > alphabetSize - 1)
                    textArray[i] = (textArray[i] + key) % alphabetSize;
                else
                    textArray[i] = textArray[i] + key;

                cypheredText[i] = defaultLowerAlphabet[textArray[i]];
            }
        }

        return new String(cypheredText);
    }

    public void writeToFile(String text) throws Exception
    {
        FileWriter fileWriter = new FileWriter("C:\\Studying\\uchebka 6\\OKZI\\labs\\laba1\\CAESAR\\encoded text.txt");
        fileWriter.write(text);
        fileWriter.close();
    }
}
// test comment