package com.dorizu.ms3;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SettingFragment extends Fragment {

    private CardView gantiBahasa;
    public SettingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view_fragment_setting = inflater.inflate(R.layout.activity_setting_fragment, container, false);
        gantiBahasa = view_fragment_setting.findViewById(R.id.ganti_bahasa);
        gantiBahasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingBahasa = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(settingBahasa);
            }
        });
        return view_fragment_setting;
    }
}
