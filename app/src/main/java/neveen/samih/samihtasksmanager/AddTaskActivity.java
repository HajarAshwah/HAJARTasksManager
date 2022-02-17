package neveen.samih.samihtasksmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import MyData.MyTask;

public class AddTaskActivity extends AppCompatActivity {

    private TextInputEditText etTitle,etSubject;
    private TextView tvImportance;
    private Spinner spnrImprotance;
    private SeekBar skbNecessity;
    private ImageButton imgvTaskPic;
    private Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etTitle=findViewById(R.id.etTitle);
        etSubject=findViewById(R.id.etSubject);
        tvImportance=findViewById(R.id.tvImportance);
        spnrImprotance=findViewById(R.id.spnrImprotance);
        skbNecessity=findViewById(R.id.skbNecessity);
        imgvTaskPic=findViewById(R.id.imgvTaskPic);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

    }
    public void validate()
    {
        String title =etTitle.getText().toString();
        String subject =etSubject.getText().toString();
        int progress = skbNecessity.getProgress();
        //String importance = spnrImprotance.getSelectedItem().toString();
        boolean isOk=true;
        if (title.length()==0)
        {
            etTitle.setError("must inter subject");
            isOk=false;
        }
        if (isOk)
        {
            MyTask myTask=new MyTask();
            myTask.setTitle(title);
            myTask.setSubject(subject);
            myTask.setNecessity(progress);

            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            myTask.setOwner(uid);

            FirebaseDatabase db = FirebaseDatabase.getInstance();
            FirebaseDatabase.getInstance();
            DatabaseReference ref = db.getReference();
            String key = ref.child("mytasks").push().getKey();
            myTask.setKey(key);

            // add tasks to current user
            // just this user can see/read this tasks
            ref.child("mytasks").child(uid).child(key).setValue(myTask).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {//response
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(), "Add Successful", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Add Not Successful", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
