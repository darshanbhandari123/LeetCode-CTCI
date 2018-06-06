import java.util.SplittableRandom;

class TrieNode
{
    char c;
    boolean isWordPresent;
    TrieNode[] children = new TrieNode[26];
    public TrieNode()
    {

    }
    public TrieNode(char ch)
    {
        TrieNode node = new TrieNode();
        this.c = ch;
    }

}

public class PrefixTrie
{
    TrieNode root ;

    public PrefixTrie()
    {
        root = new TrieNode();
        root.c = ' ';
    }

    public void insert(String word)
    {
        TrieNode ws = root;
        for (int i=0;i<word.length();i++)
        {
            char val = word.charAt(i);
            if(ws.children[val-'a'] == null)
                ws.children[val-'a'] = new TrieNode(val);

            ws = ws.children[val-'a'];
        }

        ws.isWordPresent = true;
    }

    public boolean startsWith(String prefix)
    {
        TrieNode ws = root;
        for(int i=0;i<prefix.length();i++)
        {
            char val = prefix.charAt(i);
            if(ws.children[val-'a'] == null)
                return false;

            ws = ws.children[val-'a'];
        }

        return true;
    }

    public boolean search(String word)
    {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++)
        {
            char val = word.charAt(i);
            if(ws.children[val-'a'] == null)
                return false;

            ws = ws.children[val-'a'];
        }

        return ws.isWordPresent;
    }


    public static void main(String args[])
    {
        PrefixTrie trie = new PrefixTrie();
        trie.insert("apple");
        boolean flag1 = trie.search("apple");
        boolean flag2 = trie.search("aa");
        boolean flag3 = trie.startsWith("aa");
        boolean flag4 = trie.startsWith("app");

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
        System.out.println(flag4);

    }

}
