package sg.edu.rp.c346.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    ArrayList<Holiday> alHoliday;
    ArrayAdapter<Holiday> aaHoliday;
    ListView lvEvent;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvTitle = (TextView)findViewById(R.id.TextViewEvent);

        Intent intentReceived = getIntent();
        String strTitle = intentReceived.getStringExtra("Title");
        tvTitle.setText(strTitle);

        lvEvent = (ListView)findViewById(R.id.ListViewEvent);

        alHoliday = new ArrayList<Holiday>();
        alHoliday.add(new Holiday("Secular", "newyear", "New Year's Day", "01-01-2017"));
        alHoliday.add(new Holiday("Secular", "labourday", "Labour Day", "01-05-2017"));

        aaHoliday = new HolidayAdapter(this, R.layout.row, alHoliday);
        lvEvent.setAdapter(aaHoliday);

        lvEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedEvent = alHoliday.get(position);

                Toast.makeText(SecondActivity.this, selectedEvent.getEvent()
                                + " " + selectedEvent.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
