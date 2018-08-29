package ramesh.io.openglesexamples.shapes_3d.shapes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Ramesh Bhupathi on 29/08/18.
 */

/*
 * Define the vertices for only one face (the front face).
 * Render the cube by translating and rotating the face.
 */
public class Cube1 {
    private FloatBuffer vertexBuffer;  // Buffer for vertex-array

    private float[][] colors = {  // Colors of the 6 faces
            {1.0f, 0.5f, 0.0f, 1.0f},  // 0. orange
            {1.0f, 0.0f, 1.0f, 1.0f},  // 1. violet
            {0.0f, 1.0f, 0.0f, 1.0f},  // 2. green
            {0.0f, 0.0f, 1.0f, 1.0f},  // 3. blue
            {1.0f, 0.0f, 0.0f, 1.0f},  // 4. red
            {1.0f, 1.0f, 0.0f, 1.0f}   // 5. yellow
    };

    private float[] vertices = {  // Vertices for the front face
            -1.0f, -1.0f, 1.0f,  // 0. left-bottom-front
            1.0f, -1.0f, 1.0f,  // 1. right-bottom-front
            -1.0f,  1.0f, 1.0f,  // 2. left-top-front
            1.0f,  1.0f, 1.0f   // 3. right-top-front
    };

    // Constructor - Set up the buffers
    public Cube1() {
        // Setup vertex-array buffer. Vertices in float. An float has 4 bytes
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder()); // Use native byte order
        vertexBuffer = vbb.asFloatBuffer(); // Convert from byte to float
        vertexBuffer.put(vertices);         // Copy data into buffer
        vertexBuffer.position(0);           // Rewind
    }

    // Draw the color cube
    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CCW);    // Front face in counter-clockwise orientation
        gl.glEnable(GL10.GL_CULL_FACE); // Enable cull face
        gl.glCullFace(GL10.GL_BACK);    // Cull the back face (don't display)

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

        // Front
        gl.glColor4f(colors[0][0], colors[0][1], colors[0][2], colors[0][3]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // Right - Rotate 90 degree about y-axis
        gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        gl.glColor4f(colors[1][0], colors[1][1], colors[1][2], colors[1][3]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // Back - Rotate another 90 degree about y-axis
        gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        gl.glColor4f(colors[2][0], colors[2][1], colors[2][2], colors[2][3]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // Left - Rotate another 90 degree about y-axis
        gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        gl.glColor4f(colors[3][0], colors[3][1], colors[3][2], colors[3][3]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // Bottom - Rotate 90 degree about x-axis
        gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        gl.glColor4f(colors[4][0], colors[4][1], colors[4][2], colors[4][3]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // Top - Rotate another 180 degree about x-axis
        gl.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        gl.glColor4f(colors[5][0], colors[5][1], colors[5][2], colors[5][3]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }
}

