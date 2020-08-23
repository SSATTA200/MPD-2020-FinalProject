package com.example.ssattampd.ui.fragments.settings;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.example.ssattampd.R;
import com.example.ssattampd.data.models.UserUpdateRange;
import com.example.ssattampd.databinding.FragmentSettingsBinding;
import com.example.ssattampd.ui.fragments.BaseFragment;

public class SettingsFragment extends BaseFragment {

    //Settings

    private FragmentSettingsBinding binding;
    private SettingsViewModel settingsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        initView();

        return binding.getRoot();
    }

    private void initView() {

        binding.seekBarRanges.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                binding.tvMin.setText(String.valueOf(minValue));
                binding.tvMax.setText(String.valueOf(maxValue));
            }
        });
        binding.btnCancel.setOnClickListener(view -> getMainActivity().onBackPressed());
        binding.btnSave.setOnClickListener(view -> {

            settingsViewModel.setUserRange(
                    binding.seekBarRanges.getSelectedMinValue().intValue(),
                    binding.seekBarRanges.getSelectedMaxValue().intValue());
            showErrorMessage("saved");
            getMainActivity().onBackPressed();
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        UserUpdateRange userUpdateRange = settingsViewModel.getUserUpdateRange();

        binding.seekBarRanges
                .setMaxStartValue(userUpdateRange.getMax())
                .setMinStartValue(userUpdateRange.getMin())
                .apply();

        Log.d("com.test", "min value> " + userUpdateRange.getMin() +
                " maxValue= " + userUpdateRange.getMax());
    }

    @Override
    public String getToolbarTitle() {
        return getString(R.string.settings);
    }
}
