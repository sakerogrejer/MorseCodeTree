import java.util.Scanner;

public class BinaryTree<T>
{

    public static BinaryTree<String> readBinaryTree(Scanner scanner)
    {
        scanner.next();
        return null;
    }

    public class TreeNode<T>
    {
        private T data;
        int value;
        private TreeNode l;
        private TreeNode r;


        public TreeNode(int value, T data)
        {
            this.data = data;
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", l=" + l +
                    ", r=" + r +
                    ", index=" + value +
                    '}';
        }
    }

    private TreeNode root = new TreeNode(0, null);

    public TreeNode getRoot()
    {
        return root;
    }

    public TreeNode addRecursive(TreeNode c, int value, T data)
    {
        if(c == null)
        {
            return new TreeNode(value, data);
        }

        if(value < c.value)
        {
            c.l = addRecursive(c.l, value, data);
        }else if(value > c.value)
        {
            c.r = addRecursive(c.r, value, data);
        }else
        {
            return c;
        }
        return c;
    }

    public void add(int v, T data)
    {
        root = addRecursive(root, v, data);
    }

    public void addLevels(int h)
    {
        int numberNodes = (int) (Math.pow(2, (h+1))-1);
        for(int i = 0; i < numberNodes; i++)
        {
            add(i, null);
        }
    }

    public void preOrder(TreeNode node)
    {
        if(node != null)
        {
            //System.out.println("#: " + node.value + " Data: " + node.data);
            preOrder(node.l);
            preOrder(node.r);
        }
    }

    String translateString = "";
    public String preOrderFind(String str, TreeNode node)
    {

        if(node != null)
        {
            if(node.data != null && node.data.toString().substring(2).equals(str))
            {
                translateString = node.data.toString();
            }
            preOrderFind(str, node.l);
            preOrderFind(str, node.r);
        }
        return translateString;
    }
}

