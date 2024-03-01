import TIKTOK.MinInversion;
import TIKTOK.findMinProdSum;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
//        int[] testcase = {0, 8, 2, 4};
        int[] testcase = {17, 12, 5, 10, 22};
//        int[] testcase = {1, 5, 9, 4, 10};
        // 按 Shift+F9 开始调试代码。我们已为您设置了一个断点，
        // 但您始终可以通过按 Ctrl+F8 添加更多断点。
        MinInversion f = new MinInversion();
        System.out.println(f.findMinCost(testcase));
    }
}