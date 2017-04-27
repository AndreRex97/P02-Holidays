package sg.edu.rp.c346.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by 15017103 on 27/4/2017.
 */

public class HolidayAdapter extends ArrayAdapter<Holiday>{
    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvEvent, tvDate;
    private ImageView ivEvent;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvEvent = (TextView) rowView.findViewById(R.id.textViewEvent);
        tvDate = (TextView) rowView.findViewById(R.id.textViewDate);
        // Get the ImageView object
        ivEvent = (ImageView) rowView.findViewById(R.id.imageViewPublicHoliday);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHoliday = holiday.get(position);
        // Set the TextView to show the food

        tvEvent.setText(currentHoliday.getEvent());
        tvDate.setText(currentHoliday.getDate());
        ivEvent.setImageResource(R.drawable.labourday);

        // Set the image to star or nostar accordingly
        if(currentHoliday.getImage() == "labourday"){
            ivEvent.setImageResource(R.drawable.labourday);
        }
        else if (currentHoliday.getImage() == "chinesenewyear"){
            ivEvent.setImageResource(R.drawable.cny);
        }
        else if(currentHoliday.getImage() == "goodfriday"){
            ivEvent.setImageResource(R.drawable.goodfriday);
        }
        else {
            ivEvent.setImageResource(R.drawable.newyear);
        }
        // Return the nicely done up View to the ListView

        return rowView;
    }
}
