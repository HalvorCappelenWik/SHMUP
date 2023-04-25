package inf112.shmup.core.utilities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

/**
 * Class that can render shapes if enabled.  
 * Use for debugging only.
 */
public class Gizmos {
    private static final ShapeRenderer _renderer = new ShapeRenderer();

    public static final boolean ENABLED = true;

    public static void rectangle(Batch batch, Rectangle rectangle, Color color) {
        if (!ENABLED) return;

        batch.end();
        
        _renderer.setProjectionMatrix(batch.getProjectionMatrix());
        _renderer.setTransformMatrix(batch.getTransformMatrix());

        _renderer.begin(ShapeType.Line);
        _renderer.setColor(color);
        _renderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        _renderer.end();

        batch.begin();
    }
}
