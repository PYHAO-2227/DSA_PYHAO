package LeetCode.STR;

public class LC2129 {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        String[] sArr = title.split(" ");
        for (String s : sArr) {
            if (s.length() <= 2) {
                sb.append(s.toLowerCase()).append(" ");
            } else {
                sb.append(s.substring(0, 1).toUpperCase());
                sb.append(s.substring(1).toLowerCase()).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
