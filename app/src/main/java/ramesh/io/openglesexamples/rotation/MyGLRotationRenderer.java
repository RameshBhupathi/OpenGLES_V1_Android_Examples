package ramesh.io.openglesexamples.rotation;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import ramesh.io.openglesexamples.color.shapes.ColoredSquare;
import ramesh.io.openglesexamples.color.shapes.ColoredTriangle;

/**
 * Created by Ramesh Bhupathi on 29/08/18.
 */
public class MyGLRotationRenderer implements GLSurfaceView.Renderer {

    Context context;   // Application's context
    ColoredTriangle triangle;
    ColoredSquare square;

    // Rotational angle and speed
    private float angleTriangle = 0.0f; //
    private float angleQuad = 0.0f;     //
    private float speedTriangle = 0.5f; //
    private float speedQuad = -0.4f;    //


    //Constructor with global application context
    public MyGLRotationRenderer(Context context) {
        this.context = context;
        triangle = new ColoredTriangle();   // ( NEW )
        square = new ColoredSquare();
    }

    // Call back when the surface is first created or re-created
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        gl10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);  // Set color's clear-value to black
        gl10.glClearDepthf(1.0f);            // Set depth's clear-value to farthest
        gl10.glEnable(GL10.GL_DEPTH_TEST);   // Enables depth-buffer for hidden surface removal
        gl10.glDepthFunc(GL10.GL_LEQUAL);    // The type of depth testing to do
        gl10.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  // nice perspective view
        gl10.glShadeModel(GL10.GL_SMOOTH);   // Enable smooth shading of color
        gl10.glDisable(GL10.GL_DITHER);      // Disable dithering for better performance

    }

    // Call back after onSurfaceCreated() or whenever the window's size changes
    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        if (height == 0) height = 1;   // To prevent divide by zero
        float aspect = (float)width / height;

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

    // Call back to draw the current frame.
    @Override
    public void onDrawFrame(GL10 gl10) {
        // Clear color and depth buffers using clear-value set earlier
        gl10.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl10.glLoadIdentity();                 // Reset model-view matrix ( NEW )
        gl10.glTranslatef(-1.5f, 0.0f, -6.0f); // Translate left and into the screen
        gl10.glRotatef(angleTriangle, 0.0f, 1.0f, 0.0f); // Rotate the triangle about the y-axis

        triangle.draw(gl10);                   // Draw triangle ( NEW )

        // Translate right, relative to the previous translation ( NEW )
        gl10.glTranslatef(3.0f, 0.0f, 0.0f);
        gl10.glRotatef(angleQuad, 1.0f, 0.0f, 0.0f); // Rotate the square about the x-axis

        square.draw(gl10);

        // Update the rotational angle after each refresh
        angleTriangle += speedTriangle;
        angleQuad += speedQuad;
    }
}
