package com.example.aide_autisme.ui.contact;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aide_autisme.R;
import com.example.aide_autisme.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {

    private FragmentBlankBinding binding;


    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        ContactApi infoApi = new ContactApi(getString(R.string.url)+"/api/liens",this);
        infoApi.execute();
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}