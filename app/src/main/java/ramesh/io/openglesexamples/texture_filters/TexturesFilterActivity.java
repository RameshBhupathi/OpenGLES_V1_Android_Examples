package ramesh.io.openglesexamples.texture_filters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TexturesFilterActivity extends AppCompatActivity {

    private MyGLSurfaceView glSurfaceView;   // Use GLSurfaceView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new MyGLSurfaceView(this);           // Allocate a GLSurfaceView
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
