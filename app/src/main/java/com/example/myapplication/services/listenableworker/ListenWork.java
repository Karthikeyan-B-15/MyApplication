package com.example.myapplication.services.listenableworker;

import android.content.Context;
import android.telecom.Call;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

import com.android.volley.Response;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.IOException;



public class ListenWork extends ListenableWorker {
    /**
     * @param appContext   The application {@link Context}
     * @param workerParams Parameters to setup the internal state of this worker
     */
    public ListenWork(@NonNull Context appContext, @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
    }

    @NonNull
    @Override
    public ListenableFuture<Result> startWork() {
//        return CallbackToFutureAdapter.getFuture(completer -> {
//            Callback callback = new Callback() {
//                int successes = 0;
//
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    completer.setException(e);
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) {
//                    successes++;
//                    if (successes == 100) {
//                        completer.set(Result.success());
//                    }
//                }
//            };
//
//            for (int i = 0; i < 100; i++) {
//
//            }
//            return callback;
//        });
        return null;
    }
}
