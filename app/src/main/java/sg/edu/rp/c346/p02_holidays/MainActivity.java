package sg.edu.rp.c346.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvCategory;
    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCategory = (ListView)findViewById(R.id.ListViewCategory);

        alCategory = new ArrayList<String>();
        alCategory.add("Secular");
        alCategory.add("Ethnic & Religion");

        aaCategory = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alCategory);
        lvCategory.setAdapter(aaCategory);

        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                intent.putExtra("Title", alCategory.get(position));
                startActivity(intent);
//                Toast.makeText(getApplicationContext(),al.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
