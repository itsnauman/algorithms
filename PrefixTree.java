package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class PrefixTree {
    private final Node root;
    private int numOfWords;

    PrefixTree() {
        root = new Node();
    }

    /**
     * Search the trie for a prefix
     * @param query
     * @return null, if prefix doesn't exist
     */
    private Node searchPrefix(String query) {
        Node current = root;

        for (int i = 0; i < query.length(); i++) {
            Character ch = query.charAt(i);
            Node node = current.children.get(ch);

            if (node == null)
                return null;

            current = node;
        }

        return current;
    }

    public int numOfWords() {
        return numOfWords;
    }

    public boolean containsPrefix(String prefix) {
        return searchPrefix(prefix) != null;
    }

    /**
     * Check if a prefix exists in the tree
     */
    public boolean containsWord(String query) {
        Node node = searchPrefix(query);
        return node != null && node.endOfWord;
    }

    /**
     * Search for all words starting with a prefix
     * @param query
     * @return List of words
     */
    public ArrayList<String> startsWith(String query) {
        ArrayList<String> list = new ArrayList<>();

        Node node = searchPrefix(query);
        if (node == null)
            return list;

        buildList(node, list);
        return list;
    }

    /**
     * Get the list of all words in the tree
     */
    public ArrayList<String> wordList() {
        ArrayList<String> list = new ArrayList<>();
        buildList(root, list);

        return list;
    }

    private void buildList(Node node, ArrayList<String> list) {
        if (node.endOfWord)
            list.add(node.word);

        Set<Character> characterSet = node.children.keySet();
        if (!characterSet.isEmpty()) {
            for (Character ch: characterSet) {
                Node n = node.children.get(ch);
                buildList(n, list);
            }
        }
    }

    /**
     * Add a word to the prefix tree
     * @param word
     */
    public void add(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            Node node;

            if (current.children.containsKey(ch)) {
                node = current.children.get(ch);
            } else {
                node = new Node();
                current.children.put(ch, node);
            }

            current = node;
        }

        current.endOfWord = true;
        current.word = word;
        numOfWords++;
    }

    private class Node {
        Map<Character, Node> children;
        boolean endOfWord;
        String word; // Store entire word at the leaf node

        Node() {
            children = new HashMap<>();
            endOfWord = false;
            word = null;
        }
    }
}