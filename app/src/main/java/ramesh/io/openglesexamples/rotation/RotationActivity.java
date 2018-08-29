package ramesh.io.openglesexamples.rotation;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RotationActivity extends AppCompatActivity {


    private GLSurfaceView glSurfaceView;   // Use GLSurfaceView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);           // Allocate a GLSurfaceView
        glSurfaceView.setRenderer(new MyGLRotationRenderer(this)); // Use a custom renderer
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
