package com.example.fyp.Company;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fyp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanySettings extends Fragment {


    public CompanySettings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company_settings, container, false);
    }

}
