package cheesecake.com.cheesecakelabs;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.cheesecake.adapter.ArticleArrayAdapter;
import com.cheesecake.pojo.ArticlePojo;
import com.cheesecake.task.RequestJSONTask;

import java.util.concurrent.ExecutionException;


public class MainListActivity extends ListActivity {

    public static final String JSON_URL = "http://www.ckl.io/challenge/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_list);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArticlePojo[] articles = null;
        try {

            RequestJSONTask task = new RequestJSONTask();
            articles = task.execute(JSON_URL).get();


        } catch (InterruptedException e) {
            Log.e("[MainListActivity]ERROR", e.getMessage());
        } catch (ExecutionException e) {
            Log.e("[MainListActivity]ERROR", e.getMessage());
        }

        setListAdapter(new ArticleArrayAdapter(this, articles));

    }


}
