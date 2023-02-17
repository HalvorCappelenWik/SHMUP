package com.javajunkies.model;

/**
 * All currently visible {@link GameObject}s.
 */
public interface GameScene {
    /**
     * Adds the {@link GameObject} to the scene and initializes it.
     * @param gameObject New {@link GameObject}.
     */
    void spawn(GameObject gameObject);

    /**
     * Removes the {@link GameObject} from the scene and disposes it.
     * @param gameObject Old {@link GameObject}
     */
    void destroy(GameObject gameObject);

    /**
     * Returns an iterable over all {@link GameObject}s in the scene.
     */
    Iterable<GameObject> getGameObjects();
}
