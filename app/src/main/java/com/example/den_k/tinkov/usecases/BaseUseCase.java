package com.example.den_k.tinkov.usecases;

abstract class BaseUseCase<T> {

    static final String DEFAULT_ERROR_MSG = "Что-то пошло не так!";

    public abstract void execute();
    protected abstract void onError(String aErrMsg);
    protected abstract void onSuccess(T aObj);

}
