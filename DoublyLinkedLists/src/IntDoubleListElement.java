public class IntDoubleListElement {
    private int info;
    public IntDoubleListElement prev;
    public IntDoubleListElement next;
    public IntDoubleListElement(int info) {
        this.info = info;
        this.prev = null;
        this.next = null;
    }
    public void setInfo(int info) {
        this.info = info;
    }
    public int getInfo() {
        return info;
    }
    public boolean isEqual(IntDoubleListElement other) {
        return info == other.info;
    }
}
