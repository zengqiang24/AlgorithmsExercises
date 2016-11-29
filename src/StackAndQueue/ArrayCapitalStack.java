package StackAndQueue;

/**
 * resize array of stack
 * FILO
 * Created by qiangzeng on 16/11/29.
 */
public class ArrayCapitalStack {
    private int N;
    private String arrays[];
    private int captical = 1;

    public boolean isEmpty() {
        return arrays.length == 0;
    }

    public ArrayCapitalStack() {
        arrays = new String[captical];
    }

    private void resize(int count) {
        String temp[] = new String[count];
        for (int i = 0; i < N; i++) {
            temp[i] = arrays[i];
        }
        arrays = temp;
    }


    public String pop() {
        String item = arrays[--N];
        if (N != 0 && N == arrays.length / 4) resize(arrays.length / 2);
        arrays[N] = null;
        return item;
    }

    public void push(String arg) {
        if (N != 0 && N == arrays.length) resize(2 * arrays.length);
        arrays[N++] = arg;
    }


    public static void main(String[] args) {
        ArrayCapitalStack arrayCapitalStack = new ArrayCapitalStack();
        String orignal[] = {"h", "l", "l", "o", "e"};

        for (String s : orignal) {
            arrayCapitalStack.push(s);
        }
        System.out.println(arrayCapitalStack.pop());
        System.out.println(arrayCapitalStack.pop());
        System.out.println(arrayCapitalStack.pop());
        System.out.println(arrayCapitalStack.pop());
        System.out.println(arrayCapitalStack.pop());

    }
}
