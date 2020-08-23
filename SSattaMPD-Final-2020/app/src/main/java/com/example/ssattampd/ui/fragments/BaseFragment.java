package com.example.ssattampd.ui.fragments;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.ssattampd.ui.activities.MainActivity;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onStart() {
        super.onStart();

        setUpToolbar();
    }

    protected MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }

    private void setUpToolbar() {
        if (getToolbarTitle() != null) {
            getMainActivity().setUpTitle(getToolbarTitle());
        }
        getMainActivity().showBackButton(canShowBack());
    }

    protected boolean canShowBack() {
        return true;
    }

    protected void showErrorMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public abstract String getToolbarTitle();
}
