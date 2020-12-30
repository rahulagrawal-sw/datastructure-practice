package trie;

public class MyTrieNode {
    int TOTAL_ALPHABETS = 26;

    Character ch;
    MyTrieNode[] alphabets = new MyTrieNode[TOTAL_ALPHABETS];
    boolean isEndOfWord;
    int visitCount = 0;

    public MyTrieNode(Character ch, boolean isEndOfWord) {
        this.ch = ch;
        this.isEndOfWord = isEndOfWord;
    }
}
