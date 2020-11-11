package com.example.mvvm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.databinding.FragmentJankenBinding;

public class JankenFragment extends Fragment {
    private FragmentJankenBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentJankenBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final JankenViewModel jankenViewModel = new ViewModelProvider(this).get(JankenViewModel.class);

        binding.comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    jankenViewModel.comprobar(binding.mano1.getText().toString(), binding.mano2.getText().toString());
            }
        });

        jankenViewModel.resultadoLiveData.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.resultado.setText(s);
            }
        });

        jankenViewModel.errorMano1LiveData.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean comprobar) {
                binding.mano1.setError("Error. La mano de ser Piedra, Papel o Tijeras");
            }

        });

        jankenViewModel.errorMano2LiveData.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean s) {
                binding.mano2.setError("Error. La mano de ser Piedra, Papel o Tijeras");
            }
        });

    }


}

