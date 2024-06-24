package LeetCode.BIT;

public class LC2802 {
    public String kthLuckyNumber(int k) {
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            sb.append(k % 2 ==  1 ? '4' : '7');
            k = (k - 1) / 2;
        }
        return sb.reverse().toString();
    }
    // 4 7 44 47 74 77 444 474
}
