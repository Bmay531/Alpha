package app.mysqlapp;

/**
 * Created by parallelcodes on 17-Jun-15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import com.example.alpha.R;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NotePad extends Activity {
    EditText ed;
    Button btn;
    TextView result;
    String h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepad);
        ed = (EditText) findViewById(R.id.contenttxt);
        result = (TextView) findViewById(R.id.resulttxt);
        btn = (Button) findViewById(R.id.exportbtn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    //h = DateFormat.format("MM-dd-yyyyy-h-mmssaa", System.currentTimeMillis()).toString();
                    h = ("testnotes");
                    // this will create a new name every time and unique
                    File root = new File(Environment.getExternalStorageDirectory(), "Notes");
                    // if external memory exists and folder with name Notes
                    //if (!root.exists())
                    {
                        root.mkdirs(); // this will create folder.
                    }
                    //File filepath = new File(root, h + ".txt");  // file path to save
                    File filepath = new File("../../Internal storage/Download/"+ h + ".txt");  // file path to save
                    FileWriter writer = new FileWriter(filepath);
                    writer.append(ed.getText().toString());
                    writer.flush();
                    writer.close();
                    String m = "File generated with name " + h + ".txt";
                    result.setText(m);

                } catch (IOException e) {
                    e.printStackTrace();
                    result.setText(e.getMessage().toString());
                }

            }
        });

    }
}

