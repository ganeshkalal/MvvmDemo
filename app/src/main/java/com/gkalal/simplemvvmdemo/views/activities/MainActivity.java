package com.gkalal.simplemvvmdemo.views.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.gkalal.simplemvvmdemo.MainActivityBinder;
import com.gkalal.simplemvvmdemo.R;
import com.gkalal.simplemvvmdemo.views.fragments.ListFragment;

public class MainActivity extends AppCompatActivity {

  private MainActivityBinder mBinder;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinder = DataBindingUtil.setContentView(this, R.layout.activity_main);

    getSupportFragmentManager().beginTransaction()
        .replace(R.id.layout_container, new ListFragment())
        .commit();
  }
}
