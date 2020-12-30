package trie;

public class MyTrieMain {
    public static void main(String[] args) {
        String[] strings = new String[] {
          "Apple", "Apps", "Application", "Bat", "Balh", "Ap", "Appic", "Appy"
        };

        MyTrieImpl myTrie = new MyTrieImpl();

        for (String str: strings) {
            myTrie.insert(str);
        }

        System.out.println(myTrie.toString());

        int prefixCount = myTrie.countWordsWithGivenPrefix("Appl");
        System.out.println("words with Prefix " + prefixCount);
    }
}
