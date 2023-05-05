package inf112.shmup.core.utilities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

/**
 * Simplifies rendering shapes correctly.
 */
public class DrawShape {

    private static final ShapeRenderer _renderer = new ShapeRenderer();

    public static void rectangle(Batch batch, Color color, Rectangle rectangle) {
        startShape(batch, color);
        _renderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        endShape(batch);
    }

    public static void line(Batch batch, Color color, float x1, float y1, float x2, float y2) {
        startShape(batch, color);
        _renderer.line(x1, y1, x2, y2);
        endShape(batch);
    }

    public static void circle(Batch batch, Color color, float x, float y, float radius) {
        startShape(batch, color);
        _renderer.circle(x, y, radius);
        endShape(batch);
    }

    private static void startShape(Batch batch, Color color) {
        batch.end();
        
        _renderer.setProjectionMatrix(batch.getProjectionMatrix());
        _renderer.setTransformMatrix(batch.getTransformMatrix());

        _renderer.begin(ShapeType.Line);
        _renderer.setColor(color);
    }

    private static void endShape(Batch batch) {
        _renderer.end();
        batch.begin();
    }
}
