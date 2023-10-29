package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BracketsClustering {
    public List<String> clusterize(String brackets) {
        Stack<Character> openedBrackets = new Stack<>();
        List<String> result = new ArrayList<>();
        StringBuilder cluster = new StringBuilder();
        char[] bracketsCharacters = brackets.toCharArray();
        for (int i = 0; i < bracketsCharacters.length; i++) {
            if (openedBrackets.size() == 0 && bracketsCharacters[i] == ')') {
                return null;
            }
            cluster.append(bracketsCharacters[i]);
            if (bracketsCharacters[i] == '(') {
                openedBrackets.push(bracketsCharacters[i]);
            } else {
                if (openedBrackets.size() == 1) {
                    result.add(new String(cluster));
                    cluster = new StringBuilder();
                }
                openedBrackets.pop();
            }
        }
        return result;
    }
}
