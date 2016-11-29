package StackAndQueue;

/**
 * resize array of stack
 * FILO
 * Created by qiangzeng on 16/11/29.
 */
public class ArrayCapitalStack<T> {
    private int N;
    private T arrays[];
    private int captical = 1;

    public boolean isEmpty() {
        return arrays.length == 0;
    }

    public ArrayCapitalStack() {
        arrays = (T[]) new Object[captical];
    }

    private void resize(int count) {
        T temp[] = (T[]) new Object[count];
        for (int i = 0; i < N; i++) {
            temp[i] = arrays[i];
        }
        arrays = temp;
    }


    public T pop() {
        T item = arrays[--N];
        if (N != 0 && N == arrays.length / 4) resize(arrays.length / 2);
        arrays[N] = null;
        return item;
    }

    public void push(T arg) {
        if (N != 0 && N == arrays.length) resize(2 * arrays.length);
        arrays[N++] = arg;
    }


    public static void main(String[] args) {
        ArrayCapitalStack<String> arrayCapitalStack = new ArrayCapitalStack<>();
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
