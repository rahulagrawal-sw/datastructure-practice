package trie;

public class MyTrieImpl {

    MyTrieNode root = new MyTrieNode(null, false);

    public void insert(String str) {
        MyTrieNode pCrawl = root;

        for(int i=0; i< str.length(); i++) {
            char ch = str.charAt(i);
            int index = Character.toLowerCase(ch) - 'a';

            if(pCrawl.alphabets[index] == null) {
                pCrawl.alphabets[index] = new MyTrieNode(ch, false);
            }
            pCrawl = pCrawl.alphabets[index];
            pCrawl.visitCount++;
        }

        pCrawl.isEndOfWord = true;
    }

    public int countWordsWithGivenPrefix(String str) {
        int count = 0;
        MyTrieNode pCrawl = root;

        boolean flag = true;
        for(int i=0; i< str.length(); i++) {
            char ch = str.charAt(i);
            int index = Character.toLowerCase(ch) - 'a';
            if(pCrawl.alphabets[index] != null) {
                pCrawl = pCrawl.alphabets[index];
            } else {
                flag = false;
                break;
            }
        }

        if(flag)
            return pCrawl.visitCount;

        return 0;
    }
}
