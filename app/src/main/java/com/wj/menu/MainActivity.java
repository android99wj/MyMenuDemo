package com.wj.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @InjectView(R.id.main_menu_AndroidResideMenu)
  Button mainMenuAndroidResideMenu;

  private Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
    context = this;
  }

  @OnClick(R.id.main_menu_AndroidResideMenu)
  public void onViewClicked() {
    Intent intent = new Intent(context, AndroidResideMenuActivity.class);
    startActivity(intent);
  }
}
