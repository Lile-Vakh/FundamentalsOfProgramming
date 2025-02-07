public class IntDoubleList {
    private IntDoubleListElement head;
    private IntDoubleListElement tail;

    public IntDoubleList() {
        head = null;
        tail = null;
    }

    public IntDoubleListElement getFirstElement() {
        return head;
    }

    public IntDoubleListElement getLastElement() {
        return tail;
    }

    public void append(int info) {
        IntDoubleListElement newElement = new IntDoubleListElement(info);
        if (head == null) {
            head = newElement;
            tail = newElement;
        } else {
            tail.next = newElement;
            newElement.prev = tail;
            tail = newElement;
        }
    }

    public int size() {
        IntDoubleListElement temp = head;
        int counter = 0;
        while (head != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    public int get(int pos) {
        if (pos < 0 || pos >= this.size()) {
            System.out.println("Position exceeds list!");
            return 0;
        }
        IntDoubleListElement temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp.getInfo();
    }

    public void remove(int pos) {
        IntDoubleListElement temp = head;
        if (pos < 0 || pos >= this.size()) {
            System.out.println("Position exceeds list!");
        } else if (pos == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else {
            int j = 0;
            while (j < pos - 1) {
                temp = temp.next;
                j++;
            }
            temp.next = temp.next.next;
            if (temp.next != null) {
                temp.next.prev = temp;
            } else {
                tail = temp;
            }
        }
    }

    public String toString() {
        IntDoubleListElement temp = head;
        StringBuilder builder = new StringBuilder();
        while (temp != null) {
            builder.append(temp.getInfo());
            if (temp.next != null) {
                builder.append(", ");
            }
            temp = temp.next;
        }
        return builder.toString();
    }

    public boolean isEqual(IntDoubleList other) {
        IntDoubleListElement myTemp = head;
        IntDoubleListElement otherTemp = other.head;
        while (myTemp != null) {
            if (!myTemp.isEqual(otherTemp)) {
                return false;
            }
            myTemp = myTemp.next;
            otherTemp = otherTemp.next;
        }
        return otherTemp == null;
    }

    public int sum() {
        IntDoubleListElement temp = head;
        int sum = 0;
        while (temp != null) {
            sum += temp.getInfo();
            temp = temp.next;
        }
        return sum;
    }

    public IntDoubleList copy() {
        IntDoubleList ret = new IntDoubleList();
        IntDoubleListElement temp = head;
        while (head != null) {
            ret.append(temp.getInfo());
            temp = temp.next;
        }
        return ret;
    }

    public IntDoubleListElement[] search(int intValue) {
        IntDoubleListElement[] result = new IntDoubleListElement[this.size()];
        int j = 0;
        IntDoubleListElement temp = head;
        while (temp != null) {
            if (temp.getInfo() == intValue) {
                result[j] = temp;
                j++;
            }
            temp = temp.next;
        }
        IntDoubleListElement[] ret = new IntDoubleListElement[j];
        for (int i = 0; i < j; i++) {
            ret[i] = result[j];
        }
        return ret;
    }
}
