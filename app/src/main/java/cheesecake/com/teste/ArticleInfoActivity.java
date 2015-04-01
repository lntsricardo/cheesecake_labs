package cheesecake.com.teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheesecake.pojo.ArticlePojo;
import com.cheesecake.util.ImageUtil;

import cheesecake.com.com.cheesecake.activity.R;


public class ArticleInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_info);

        Intent intent = getIntent();
        ArticlePojo article = (ArticlePojo) intent.getSerializableExtra("article");
        String titleArticle = intent.getStringExtra("title");

        ImageView image = (ImageView) findViewById(R.id.image_website_info);
        TextView authors = (TextView) findViewById(R.id.authors_info);
        TextView date = (TextView) findViewById(R.id.date_info);
        TextView title = (TextView) findViewById(R.id.title_info);
        TextView text = (TextView) findViewById(R.id.text_info);

        image.setImageResource(ImageUtil.getImageResouce(getApplicationContext(), article.getWebsite()));
        authors.setText(article.getAuthors());
        date.setText(article.getDate());
        title.setText(article.getTitle());
        text.setText(article.getContent());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_article_info, menu);
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
}
