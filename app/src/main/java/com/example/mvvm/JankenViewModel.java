package com.example.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class JankenViewModel extends AndroidViewModel {

    Executor executor;

    Jenken jenken;

    MutableLiveData<String> resultadoLiveData = new MutableLiveData<>();
    MutableLiveData<Boolean> errorMano1LiveData = new MutableLiveData<>();
    MutableLiveData<Boolean> errorMano2LiveData = new MutableLiveData<>();

    public JankenViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        jenken = new Jenken();
    }

    public void comprobar(final String mano1, final String mano2) {

        executor.execute(new Runnable() {
            @Override
            public void run() {

                jenken.comprobarGanador(mano1, mano2, new Jenken.LlamameAqui() {


                    @Override
                    public void cuandoSepasElResultado(String resultado) {
                        resultadoLiveData.postValue(resultado);
                    }

                    @Override
                    public void cuandoLasManosSeanIncorrectas(int mano) {
                        if(mano == 1){
                            errorMano1LiveData.postValue(true);
                        }
                        else if (mano == 2){
                            errorMano2LiveData.postValue(true);
                        }
                    }
                });
            }
        });
    }
}
