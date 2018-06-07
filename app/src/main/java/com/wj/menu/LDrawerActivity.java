package com.wj.menu;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;

/**
 * Created by Hannah on 2018/6/6.
 */

public class LDrawerActivity extends Activity {

  @InjectView(R.id.navdrawer)
  ListView     navdrawer;
  @InjectView(R.id.drawer_layout)
  DrawerLayout drawerLayout;
  private Context               context;
  private boolean               drawerArrowColor;
  private ActionBarDrawerToggle toggle;

  @Override
  protected void onCreate(
      @Nullable
          Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ldrawer);
    ButterKnife.inject(this);
    context = this;
    ActionBar ab = getActionBar();
    ab.setDisplayHomeAsUpEnabled(true);
    ab.setHomeButtonEnabled(true);

    initMenu();
  }

  private void initMenu() {
    final DrawerArrowDrawable arrowDrawable = new DrawerArrowDrawable(this) {
      @Override
      public boolean isLayoutRtl() {
        return false;
      }
    };
    toggle = new ActionBarDrawerToggle(this, drawerLayout, arrowDrawable, R.string.drawer_open,
        R.string.drawer_close) {
      @Override
      public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        invalidateOptionsMenu();
      }

      @Override
      public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
        invalidateOptionsMenu();
      }
    };
    drawerLayout.setDrawerListener(toggle);
    toggle.syncState();

    String[] values = new String[] {
        "Stop Animation (Back icon)", "Stop Animation (Home icon)", "Start Animation",
        "Change Color", "GitHub Page"
    };
    ArrayAdapter<String> adapter =
        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,
            values);
    navdrawer.setAdapter(adapter);
    navdrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
          case 0:
            toggle.setAnimateEnabled(false);
            arrowDrawable.setProgress(1f);
            break;
          case 1:
            toggle.setAnimateEnabled(false);
            arrowDrawable.setProgress(0f);
            break;
          case 2:
            toggle.setAnimateEnabled(true);
            toggle.syncState();
            break;
          case 3:
            if (drawerArrowColor) {
              drawerArrowColor = false;
              arrowDrawable.setColor(R.color.ldrawer_color);
            } else {
              drawerArrowColor = true;
              arrowDrawable.setColor(R.color.drawer_arrow_second_color);
            }
            toggle.syncState();
            break;
          case 4:
            Intent browserIntent =
                new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/IkiMuhendis/LDrawer"));
            startActivity(browserIntent);
            break;
        }
      }
    });
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      if (drawerLayout.isDrawerOpen(navdrawer)) {
        drawerLayout.closeDrawer(navdrawer);
      } else {
        drawerLayout.openDrawer(navdrawer);
      }
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onPostCreate(
      @Nullable
          Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    toggle.syncState();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    toggle.onConfigurationChanged(newConfig);
  }
}
