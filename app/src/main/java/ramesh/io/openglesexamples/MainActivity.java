package ramesh.io.openglesexamples;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ramesh.io.openglesexamples.color.ColorsForShapesActivity;
import ramesh.io.openglesexamples.drawing_2d_shapes.Drawing2dShapes;
import ramesh.io.openglesexamples.rotation.RotationActivity;
import ramesh.io.openglesexamples.shapes_3d.Shapes3dActivity;
import ramesh.io.openglesexamples.texture_cube.TextureCubeActivity;

public class MainActivity extends ListActivity {

    private String[] items = {"Drawing 2d Shapes", "Color", "Rotation", "3D Shapes", "Texture",
            "PhotoCube", "User Inputs", "Texture Filters", "Lighting", "Blending", "Bouncing Ball in Cube"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);

        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, Drawing2dShapes.class);
                break;
            case 1:
                intent = new Intent(this, ColorsForShapesActivity.class);
                break;
            case 2:
                intent = new Intent(this, RotationActivity.class);
                break;
            case 3:
                intent = new Intent(this, Shapes3dActivity.class);
                break;
            case 4:
                intent = new Intent(this, TextureCubeActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
