package com.wj.menu;

/**
 * Created by Hannah on 2018/6/8.
 */

public class Bean {
  private String id;
  private String name;

  public Bean(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
