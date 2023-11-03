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
        for (char bracketsCharacter : bracketsCharacters) {
            if (openedBrackets.size() == 0 && bracketsCharacter == ')') {
                throw new IllegalArgumentException("not correct a balanced bracket sequences");
            }
            cluster.append(bracketsCharacter);
            if (bracketsCharacter == '(') {
                openedBrackets.push(bracketsCharacter);
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
