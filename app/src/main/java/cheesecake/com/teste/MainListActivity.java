package cheesecake.com.teste;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.cheesecake.adapter.ArticleArrayAdapter;
import com.cheesecake.pojo.ArticlePojo;
import com.cheesecake.task.RequestJSONTask;

import java.util.concurrent.ExecutionException;

import cheesecake.com.com.cheesecake.activity.R;


public class MainListActivity extends ListActivity {

    public static final String JSON_URL = "http://www.ckl.io/challenge/";
    private static final String ARTICLE = "article";

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

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent articleInfoIntent = new Intent(MainListActivity.this, ArticleInfoActivity.class);
        ArticlePojo article = (ArticlePojo) l.getItemAtPosition(position);
        articleInfoIntent.putExtra(ARTICLE, article);
        startActivity(articleInfoIntent);
    }
}
