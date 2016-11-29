package StackAndQueue;

/**
 * Created by qiangzeng on 16/11/29.
 */
public interface IStack<T> {
    boolean isEmpty();

    T pop();

    void push(T t);
    
}
