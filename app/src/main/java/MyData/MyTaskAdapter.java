package MyData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import neveen.samih.samihtasksmanager.R;

public class MyTaskAdapter extends ArrayAdapter<MyTask>
{

    public MyTaskAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      //  View v= android.view.View.inflate(getContext(), R.layout.task_item_layout,parent);
        //ناء واجهة لمعطى واحد
        View v= LayoutInflater.from(getContext()).inflate(R.layout.task_item_layout,parent,false);
        // تجهيز المعطى حسب رقمه
        MyTask item = getItem(position);
        // تجهيز مؤشر لكل كائن على الواجهة
        TextView title=v.findViewById(R.id.itmTaskTitle);
        TextView subject=v.findViewById(R.id.itmTaskSubject);
        ImageButton delete=v.findViewById(R.id.itmButtonDelete);
        ImageButton edit=v.findViewById(R.id.itmButtonEdit);
        RatingBar necessity=v.findViewById(R.id.itmRtNecessity);
        ImageView img=v.findViewById(R.id.itmImg);

        // وضع قيم المعطى المستخرج على كائنات الواجهة
        title.setText(item.getTitle());
        subject.setText(item.getSubject());
        necessity.setRating(5*(item.getNecessity()/(float)10.0));

        if (item.getImage()==null || item.getImage().length()==0)
        {
            img.setImageResource(R.mipmap.my_logo);

        }
            else
        {
            // todo deal with image
        }

        return v;
    }
}
