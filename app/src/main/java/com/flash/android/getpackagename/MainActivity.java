package com.flash.android.getpackagename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textViewStatus;
    private ListView listViewAppsInstalled;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewStatus = findViewById(R.id.textViewStatus);
        listViewAppsInstalled = findViewById(R.id.listViewInstalledApps);
    }
    public void ButtonGetInstalledAppList(View view){
        List<ApplicationInfo> listApplicationInfo = getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
        String[] stringList = new String[listApplicationInfo.size()];
        int i = 0;
        for (ApplicationInfo applicationInfo: listApplicationInfo){
            stringList[i] =applicationInfo.packageName;
            i++;
        }
        listViewAppsInstalled.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, stringList));
        textViewStatus.setText(listApplicationInfo.size() + " List of Apps Installed");
    }
}