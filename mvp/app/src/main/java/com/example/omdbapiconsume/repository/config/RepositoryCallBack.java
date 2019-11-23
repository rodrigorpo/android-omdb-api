package com.example.omdbapiconsume.repository.config;

public interface RepositoryCallBack<T> {
    void onSuccess(T response);

    void onError(Throwable t);
}
