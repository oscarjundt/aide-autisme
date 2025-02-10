package com.autisme.aide_autisme.ui.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.autisme.aide_autisme.R;
import com.autisme.aide_autisme.databinding.FragmentVideoBinding;

public class VideoFragment extends Fragment {

    private FragmentVideoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentVideoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        VideoApi videoApi = new VideoApi(getString(R.string.url)+"/api/videos",this);
        videoApi.execute();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}