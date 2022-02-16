package neveen.samih.samihtasksmanager;
//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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import MyData.MyTaskAdapter;

// listener 1.
public class MainTasksActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
///lkjhhkhjk
    FloatingActionButton fabAdd;
    // read data 1
    private ListView lstv;
    private MyTaskAdapter taskAdapter;
     // تحديد الواجهة وبناء الكائنات المعروضة على الشاشة - وظيفة الدالة
    // تجهيز الكائنات ومؤشراتها قبل العرض على الشاشة
    // تعمل مرة واحدة فقط عند بناء الشاشة
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // هون بتبلش
        setContentView(R.layout.activity_main);
        // read data 2
        // وظيفة فايندفيو باي اي دي تعيد مؤشر لكائن تم بناؤه على واجهة المستعمل التي ستعرض
        lstv=findViewById(R.id.lstvAllTasks);
        taskAdapter=new MyTaskAdapter(this,R.layout.task_item_layout);
        // read data 3 : set adapter to list view (connect the data to list view)
        lstv.setAdapter(taskAdapter);



        fabAdd=findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddTaskActivity.class));
            }
        });
    }

    //1. build menu xml
    //2. to add menu (3 point right-top corner) to the current activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
                                 //the xml menu file
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    //3. select item event handler
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnitmSettings)
        {
            Intent i=new Intent(getApplicationContext(),SettingsActivity.class);
            startActivity(i);
        }
        if(item.getItemId()==R.id.mnitemHistory)
        {

        }
        if(item.getItemId()==R.id.mnitmSignOut)
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Are you sure?");
            builder.setCancelable(true);//
                                             //listener 3.  add listener to the buttons
            builder.setPositiveButton("Yes",this);
            builder.setNegativeButton("No",this);
            AlertDialog dialog = builder.create();//
            dialog.show();

        }
        return true;
    }

    //listener 2. implemnet method

     /**
      * event handler
      * @param dialogInterface the active dialog
      * @param which the button id which cause the event
      */
    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        ////listener 4. react for each action
        if(which==dialogInterface.BUTTON_POSITIVE)
        {

            Toast.makeText(getApplicationContext(), "loging out", Toast.LENGTH_SHORT).show();
            dialogInterface.cancel();
            //لتسجيل الخروج
            FirebaseAuth auth=FirebaseAuth.getInstance();
            auth.signOut();

            finish();//to close current activity
        }
        if(which==dialogInterface.BUTTON_NEGATIVE)
        {
            Toast.makeText(getApplicationContext(), "loging out canceled", Toast.LENGTH_SHORT).show();
            dialogInterface.cancel();
        }
    }
}