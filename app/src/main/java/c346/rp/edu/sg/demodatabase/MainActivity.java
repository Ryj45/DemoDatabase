package c346.rp.edu.sg.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn, btnGetTasks;
    TextView tvResults;
    ListView lv;

    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        btnGetTasks = (Button)findViewById(R.id.btnGetTasks);
        tvResults = (TextView)findViewById(R.id.tvResults);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                db.insertTask("Submit RJ", "25 Apr 2020");
                db.close();
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<String> data = db.getTaskContent();
                ArrayList<Task> tasks = db.getTasks();
                db.close();

                String txt = "";
                for(int i = 0; i < data.size(); i++){
                    Log.d("Database Content", i+". " + data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);

                lv = (ListView)findViewById(R.id.lv);
                aa = new TaskAdapter(MainActivity.this, R.layout.row, tasks);
                lv.setAdapter(aa);


            }
        });
    }
}
