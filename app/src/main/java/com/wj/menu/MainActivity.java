package com.wj.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends Activity {

  @InjectView(R.id.main_menu_AndroidResideMenu)
  Button mainMenuAndroidResideMenu;
  @InjectView(R.id.main_menu_LDrawer)
  Button mainMenuLDrawer;
  @InjectView(R.id.main_menu_FloatingActionButton)
  Button mainMenuFloatingActionButton;
  @InjectView(R.id.main_menu_test)
  Button mainMenuTest;

  private Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
    context = this;
  }

  @OnClick({
      R.id.main_menu_AndroidResideMenu, R.id.main_menu_LDrawer, R.id.main_menu_FloatingActionButton,
      R.id.main_menu_test
  })
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
      case R.id.main_menu_FloatingActionButton:
        Intent intent3 = new Intent(context, FloatingActionButtonActivity.class);
        startActivity(intent3);
        break;
      case R.id.main_menu_test:
        Intent intent4 = new Intent(context, TestListViewActivity.class);
        startActivity(intent4);
        break;
    }
  }
}
