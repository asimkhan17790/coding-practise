package com.datastructures.tries;

public class Trie {

    private TrieNode root;
    public Trie(){
        root = new TrieNode(); 
    }

    // insert
    public void insert(String word){
        TrieNode current = root;
        for (char l: word.toCharArray()){
            //current = current.children.computeIfAbsent(l, c->new TrieNode());

            if (current.children.get(l) == null){
                current.children.put(l, new TrieNode());
            }
            current = current.children.get(l);
        }
        current.isWord = true;
    }

    //Search
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.children.get(ch);
                if (node == null) {
                    return false;
            }
            current = node;
        }
        return current.isWord;
    }
    
    public boolean isEmpty(TrieNode root){    
        return root.children.isEmpty(); 
    }

    // delete
    public TrieNode remove(TrieNode root, String key, int depth){
        if (root == null){
            return null;
        }

        // if last character of the key is being processed
        if (depth == key.length()){
            if (root.isWord){
                root.isWord = false;
            }
            if (isEmpty(root)){
                root = null;
            }
            return root;
        }

        // if not the last char, recur for child
        char c = key.charAt(depth);
        TrieNode n = remove(root.children.get(c), key, depth + 1);
        root.children.put(c, n);

        // if root does not have any child left(its only child has been deleted) and is also not the end of another word

        if (isEmpty(root) && root.isWord == false){
            root = null;
        }
        return root;
    }


    private static Trie createTrie() {
        Trie trie = new Trie();
        System.out.println("Empty in start?  ->" + trie.isEmpty(trie.root));
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");   
        trie.insert("Program");  
        System.out.println("Empty in End ?  ->" + trie.isEmpty(trie.root));
        return trie;
    }
    public static void main(String[] args){
        Trie t = createTrie();
        System.out.println("t: " + t);
        System.out.println("Program exists? -> " + t.search("Program"));

        t.remove(t.root, "Program",0);
        System.out.println("Program exists? -> " + t.search("Program"));
    }
}
