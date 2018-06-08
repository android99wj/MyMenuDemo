package com.wj.menu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

/**
 * Created by Hannah on 2018/6/6.
 */

/**
 * 项目地址：https://github.com/SpecialCyCi/AndroidResideMenu
 */
public class AndroidResideMenuActivity extends Activity implements View.OnClickListener {

  @InjectView(R.id.main_titlebar_left_tv)
  TextView mainTitlebarLeftTv;

  private Context    context;
  private ResideMenu menu;

  @Override
  protected void onCreate(
      @Nullable
          Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_arm);
    ButterKnife.inject(this);
    context = this;
    initMenu();
  }

  private void initMenu() {
    //创建侧滑菜单
    menu = new ResideMenu(context);
    menu.setBackground(R.color.colorPrimary);
    menu.attachToActivity(this);
    menu.setScaleValue(0.7f);

    String[] titles = { "Home", "Records", "Settings" };
    int[] icons = { R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher };
    //添加条目
    for (int i = 0; i < titles.length; i++) {
      ResideMenuItem item = new ResideMenuItem(context, icons[i], titles[i]);
      item.setTag(i);
      item.setOnClickListener(this);
      menu.addMenuItem(item);
    }

    //设置菜单的点击
    menu.setMenuListener(new ResideMenu.OnMenuListener() {
      @Override
      public void openMenu() {

      }

      @Override
      public void closeMenu() {

      }
    });
    mainTitlebarLeftTv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        menu.openMenu(ResideMenu.DIRECTION_LEFT);
      }
    });
  }

  //处理侧滑菜单的点击事件
  @Override
  public void onClick(View view) {
    switch ((int) view.getTag()) {
      case 0:
        Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show();
        break;
      case 1:
        Toast.makeText(context, "Records", Toast.LENGTH_SHORT).show();
        break;
      case 2:
        Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show();
        break;
    }
    menu.closeMenu();
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    return menu.dispatchTouchEvent(ev);
  }
}
