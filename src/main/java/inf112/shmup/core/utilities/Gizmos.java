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

    public static void rectangle(Batch batch, Color color, Rectangle rectangle) {
        if (startShape(batch, color)) {
            _renderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            endShape(batch);
        }
    }

    public static void line(Batch batch, Color color, float x1, float y1, float x2, float y2) {
        if (startShape(batch, color)) {
            _renderer.line(x1, y1, x2, y2);
            endShape(batch);
        }
    }

    private static boolean startShape(Batch batch, Color color) {
        if (!ENABLED) return false;

        batch.end();
        
        _renderer.setProjectionMatrix(batch.getProjectionMatrix());
        _renderer.setTransformMatrix(batch.getTransformMatrix());

        _renderer.begin(ShapeType.Line);
        _renderer.setColor(color);

        return true;
    }

    private static void endShape(Batch batch) {
        _renderer.end();
        batch.begin();
    }
}
