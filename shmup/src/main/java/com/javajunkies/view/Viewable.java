package com.javajunkies.view;

import java.util.List;

import com.javajunkies.model.GameObject;

public interface Viewable {
    void render(List<GameObject> gameObjects);
}
