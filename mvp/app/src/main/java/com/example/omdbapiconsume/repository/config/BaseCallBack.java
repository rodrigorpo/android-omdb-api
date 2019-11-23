package com.example.omdbapiconsume.repository.config;

import retrofit2.Call;
import retrofit2.Response;

public abstract class BaseCallBack<T> implements retrofit2.Callback<T>, RepositoryCallBack<T> {


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
            return;
        }

        Throwable throwable = new Throwable();

//        ResponseError responseError = ResponseError.getExceptionError();
//        if (response.code() == 401) {
//            responseError = ResponseError.getResponseError(response.errorBody(), response.code());
//
//            if (responseError == null || responseError.getCode() == null) {
//            }
//
//        } else if (response.code() == 403) {
//            return;
//
//        } else if (response.code() == 422) {
//            responseError = ResponseError.getResponseError(response.errorBody(), response.code());
//
//            if (responseError.getCode() != null && responseError.getCode().equals(ResponseError.SYSTEM_MAINTENANCE)) {
//                return;
//            }
//        }

        onError(throwable);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(t);
    }
}