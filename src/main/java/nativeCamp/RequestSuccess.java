package nativeCamp;

import rx.functions.Action1;

public class RequestSuccess<T> implements Action1<T> {

    private T t;

    public T get(){
        return t;
    }

    @Override
    public void call(T t) {
        this.t = t;
    }

}