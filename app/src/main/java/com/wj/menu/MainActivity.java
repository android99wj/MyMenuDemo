package com.wj.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @InjectView(R.id.main_menu_AndroidResideMenu)
  Button mainMenuAndroidResideMenu;
  @InjectView(R.id.main_menu_LDrawer)
  Button mainMenuLDrawer;

  private Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
    context = this;
  }

  @OnClick({ R.id.main_menu_AndroidResideMenu, R.id.main_menu_LDrawer })
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.main_menu_AndroidResideMenu:
        Intent intent = new Intent(context, AndroidResideMenuActivity.class);
        startActivity(intent);
        break;
      case R.id.main_menu_LDrawer:
        Intent intent2 = new Intent(context, LDrawerActivity.class);
        startActivity(intent2);
        break;
    }
  }
}
