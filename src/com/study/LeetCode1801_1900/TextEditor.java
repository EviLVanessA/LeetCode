package com.study.LeetCode1801_1900;

/**
 * @author jianghui
 * @date 2022-06-05 10:55
 */
public class TextEditor {

    StringBuilder sb;
    int cur;

    public TextEditor() {
        this.sb = new StringBuilder();
        this.cur = -1;
    }

    public void addText(String text) {
        if (cur == sb.length() - 1) {
            sb.append(text);
        } else {
            sb.insert(cur + 1, text);
        }
        cur += text.length();
    }

    public int deleteText(int k) {
        if (cur >= k) {
            sb.delete(cur - k + 1, cur + 1);
            cur = cur - k;
            return k;
        } else {
            sb.delete(0, cur + 1);
            int ans = cur + 1;
            cur = -1;
            return ans;
        }
    }

    public String cursorLeft(int k) {
        if (cur >= k) {
            cur = cur - k;
        } else {
            cur = -1;
        }
        return sb.substring(Math.max(cur - 10, -1) + 1, cur + 1);
    }

    public String cursorRight(int k) {
        cur = cur + k >= sb.length() ? cur = sb.length() - 1 : cur + k;
        return sb.substring(Math.max(cur - 10, -1) + 1, cur + 1);
    }


    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addText("leetcode");
        System.out.println(textEditor.deleteText(4));
        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));
        System.out.println(textEditor.cursorLeft(8));
        System.out.println(textEditor.deleteText(10));
        System.out.println(textEditor.cursorLeft(2));
        System.out.println(textEditor.cursorRight(6));
    }
}
