package com.manage_it.Fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.manage_it.R;

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.app_prefs);
    }
}