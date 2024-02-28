import TIKTOK.findMinProdSum;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        int[] testcase = {1, 3, 5, 7, 9};
//        int[] testcase = {2, 4, 10, 9, 3};
//        int[] testcase = {1, 5, 9, 4, 10};
        // 按 Shift+F9 开始调试代码。我们已为您设置了一个断点，
        // 但您始终可以通过按 Ctrl+F8 添加更多断点。
        findMinProdSum f = new findMinProdSum();
        System.out.println(f.findRes(testcase));
    }
}