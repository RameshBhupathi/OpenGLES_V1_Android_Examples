package ramesh.io.openglesexamples.texture_cube;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TextureCubeActivity extends AppCompatActivity {

    private GLSurfaceView glSurfaceView;   // Use GLSurfaceView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);           // Allocate a GLSurfaceView
        glSurfaceView.setRenderer(new MyGLTextureRenderer(this)); // Use a custom renderer
        this.setContentView(glSurfaceView);
        setContentView(glSurfaceView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }
}