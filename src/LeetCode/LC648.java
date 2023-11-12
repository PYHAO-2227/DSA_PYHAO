package LeetCode;

import java.util.List;

public class LC648 {
    private class Node {
        boolean isEnd;
        Node[] tns = new Node[26];
    }

    Node root = new Node();

    private void add(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new Node();
            p = p.tns[u];
        }
        p.isEnd = true;
    }

    private String query(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) break;
            if (p.tns[u].isEnd) return s.substring(0, i + 1);
            p = p.tns[u];
        }
        return s;
    }

    public String replaceWords(List<String> ds, String s) {
        for (String str : ds) add(str);
        StringBuilder sb = new StringBuilder();
        for (String str : s.split(" ")) sb.append(query(str)).append(" ");
        return sb.substring(0, sb.length() - 1);
    }
}
