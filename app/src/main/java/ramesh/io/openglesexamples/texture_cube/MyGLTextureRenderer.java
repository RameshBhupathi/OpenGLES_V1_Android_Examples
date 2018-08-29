package ramesh.io.openglesexamples.texture_cube;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Ramesh Bhupathi on 29/08/18.
 */
public class MyGLTextureRenderer implements GLSurfaceView.Renderer {
    private Context context;   // Application context needed to read image (NEW)
    private TextureCube cube;
    private static float angleCube = 0;     // rotational angle in degree for cube
    private static float speedCube = -1.5f; // rotational speed for cube

    public MyGLTextureRenderer(Context context){
        this.context = context;   // Get the application context (NEW)
        cube = new TextureCube();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);  // Set color's clear-value to black
        gl.glClearDepthf(1.0f);            // Set depth's clear-value to farthest
        gl.glEnable(GL10.GL_DEPTH_TEST);   // Enables depth-buffer for hidden surface removal
        gl.glDepthFunc(GL10.GL_LEQUAL);    // The type of depth testing to do
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  // nice perspective view
        gl.glShadeModel(GL10.GL_SMOOTH);   // Enable smooth shading of color
        gl.glDisable(GL10.GL_DITHER);      // Disable dithering for better performance

        // Setup Texture, each time the surface is created (NEW)
        cube.loadTexture(gl, context);    // Load image into Texture (NEW)
        gl.glEnable(GL10.GL_TEXTURE_2D);  // Enable texture (NEW)
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {

        if (height == 0) height = 1;   // To prevent divide by zero
        float aspect = (float) width / height;

        // Set the viewport (display area) to cover the entire window
        gl10.glViewport(0, 0, width, height);

        // Setup perspective projection, with aspect ratio matches viewport
        gl10.glMatrixMode(GL10.GL_PROJECTION); // Select projection matrix
        gl10.glLoadIdentity();                 // Reset projection matrix
        // Use perspective projection
        GLU.gluPerspective(gl10, 45, aspect, 0.1f, 100.f);

        gl10.glMatrixMode(GL10.GL_MODELVIEW);  // Select model-view matrix
        gl10.glLoadIdentity();                 // Reset
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // Clear color and depth buffers
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        // ----- Render the Cube -----
        gl.glLoadIdentity();                  // Reset the current model-view matrix
        gl.glTranslatef(0.0f, 0.0f, -6.0f);   // Translate into the screen
        gl.glRotatef(angleCube, 0.1f, 1.0f, 0.2f); // Rotate
        cube.draw(gl);

        // Update the rotational angle after each refresh.
        angleCube += speedCube;
    }
}
