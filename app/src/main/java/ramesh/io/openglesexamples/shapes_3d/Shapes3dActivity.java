package ramesh.io.openglesexamples.shapes_3d;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ramesh.io.openglesexamples.rotation.MyGLRotationRenderer;

public class Shapes3dActivity extends AppCompatActivity {

    private GLSurfaceView glSurfaceView;   // Use GLSurfaceView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);           // Allocate a GLSurfaceView
        glSurfaceView.setRenderer(new My3DShapeGLRenderer(this)); // Use a custom renderer
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