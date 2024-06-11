package LeetCode.STR;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");

        for (String directory : components) {
            if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!directory.isEmpty() && !directory.equals(".")) {
                stack.push(directory);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()).insert(0, "/");
        }

        return sb.toString();
    }
}
