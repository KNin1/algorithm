package top.knin1.algo.linkedlist;

/**
 * 基于 Stack 实现浏览器前进、后退功能
 * @author KNin1
 * @date 2021-03-24
 */
public class BrowserSample {
    private String curUrl;
    private final StackBasedOnLinkedList<String> backwardStack;
    private final StackBasedOnLinkedList<String> forwardStack;

    public BrowserSample() {
        this.curUrl = null;
        backwardStack = new StackBasedOnLinkedList<>();
        forwardStack = new StackBasedOnLinkedList<>();
    }

    public String open(String url) {
        if (curUrl != null) {
            backwardStack.push(curUrl);
            forwardStack.clear();
        }
        curUrl = url;
        return requestUrl();
    }

    public String forward() {
        if (!canForward()) {
            return null;
        }
        backwardStack.push(curUrl);
        curUrl = forwardStack.pop();
        return requestUrl();
    }

    public String backward() {
        if (!canBackward()) {
            return null;
        }
        forwardStack.push(curUrl);
        curUrl = backwardStack.pop();
        return requestUrl();
    }

    private boolean canForward() {
        return forwardStack.size() > 0;
    }

    private boolean canBackward() {
        return backwardStack.size() > 0;
    }

    private String requestUrl() {
        return curUrl;
    }
}
