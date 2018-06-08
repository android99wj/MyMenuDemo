package com.wj.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannah on 2018/6/8.
 */

public class TestListViewActivity extends Activity {
  @InjectView(R.id.test_lv)
  ListView testLv;

  private Context context;
  private List<Bean> list = new ArrayList<>();
  private MyAdapter adapter;

  private Handler handler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
      super.handleMessage(msg);
      switch (msg.what) {
        case 0:
          list.add(new Bean("1", "小花"));
          list.add(new Bean("2", "小草"));
          list.add(new Bean("3", "小雨"));
          list.add(new Bean("4", "小雪"));
          adapter.notifyDataSetChanged();
          Message msg1 = new Message();
          msg1.what = 1;
          handler.sendMessageDelayed(msg1, 3000);
          break;
        case 1:
          list.clear();
          adapter.notifyDataSetChanged();
          Toast.makeText(context,getResources().getText(R.string.app_name),Toast.LENGTH_SHORT).show();
          break;
      }
    }
  };

  @Override
  protected void onCreate(
      @Nullable
          Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);
    ButterKnife.inject(this);
    context = this;
    adapter = new MyAdapter(context, list);
    testLv.setAdapter(adapter);
    Message msg = new Message();
    msg.what = 0;
    handler.sendMessageDelayed(msg, 3000);
  }

  public class MyAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context        context;
    private List<Bean>     list;

    public MyAdapter(Context context, List<Bean> list) {
      this.context = context;
      this.list = list;
      inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
      return list.size();
    }

    @Override
    public Object getItem(int i) {
      return list.get(i);
    }

    @Override
    public long getItemId(int i) {
      return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      ViewHolder holder;
      if (view == null) {
        view = inflater.inflate(R.layout.item_test, null);
        holder = new ViewHolder(view);
        view.setTag(holder);
      } else {
        holder = (ViewHolder) view.getTag();
      }
      holder.itemTestTv.setText(list.get(i).getName());
      return view;
    }

    public class ViewHolder {
      @InjectView(R.id.item_test_tv)
      TextView itemTestTv;

      ViewHolder(View view) {
        ButterKnife.inject(this, view);
      }
    }
  }
}
