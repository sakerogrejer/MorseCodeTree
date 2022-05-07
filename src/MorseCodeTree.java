import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeTree<T>
{
    File file = new File("src/letter_code");
    Scanner read = new Scanner(file);
    BinaryTree<String> bt = new BinaryTree<>();

    public MorseCodeTree() throws FileNotFoundException
    {
        int i = 1;
        while(read.hasNextLine())
        {
            bt.add(i, read.nextLine());
            i++;
        }
    }

    public void print()
    {
        bt.preOrder(bt.getRoot());
    }

    public String translateFromMorseCode(String s) throws Exception {

        String translate = "";
        String[] arr = s.split(" ");
        for(String str : arr)
        {
            if(str.length() > 5)
            {
                throw new Exception("NO");
            }
            else
            {
                for(char c : str.toCharArray())
                {
                    if(c != '*' && c != '-')
                    {
                        throw new Exception("NO");
                    }
                }
            }
            translate += bt.preOrderFind(str, bt.getRoot()).substring(0,1);
        }

        return translate;
    }
}
