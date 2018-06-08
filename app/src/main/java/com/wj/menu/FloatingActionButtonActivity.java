package com.wj.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by Hannah on 2018/6/7.
 */

public class FloatingActionButtonActivity extends Activity {
  @InjectView(R.id.fab_button_1)
  FloatingActionButton fabButton1;
  @InjectView(R.id.fab_button_2)
  FloatingActionButton fabButton2;
  @InjectView(R.id.fab_menu_1)
  FloatingActionsMenu  fabMenu1;

  private Context context;

  @Override
  protected void onCreate(
      @Nullable
          Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fab);
    ButterKnife.inject(this);
    context = this;
  }

  @OnClick({ R.id.fab_button_1, R.id.fab_button_2, R.id.fab_menu_1 })
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.fab_button_1:
        Toast.makeText(context, ((FloatingActionButton) view).getTitle(), Toast.LENGTH_SHORT)
            .show();
        break;
      case R.id.fab_button_2:
        Toast.makeText(context, ((FloatingActionButton) view).getTitle(), Toast.LENGTH_SHORT)
            .show();
        break;
      case R.id.fab_menu_1:
        Toast.makeText(context, "menu", Toast.LENGTH_SHORT).show();
        break;
    }
  }
}
