package org.example.bookshelf.activity;

import org.example.bookshelf.R;
import org.example.bookshelf.view.BookshelfView;
import org.example.bookshelf.xml.DownloadBooksTask;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;

public class BookshelfActivity extends Activity {

	private BookshelfView bsView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookshelf);
        
        bsView = (BookshelfView) findViewById(R.id.gridView1);
        initGrid(getResources().getConfiguration());
        
    	(new DownloadBooksTask(this, bsView)).execute("https://raw.github.com/filip26/android-bookshelf-example/master/test/feed.xml");
    }
    
    protected void initGrid(Configuration config) {
    	// Checks the orientation of the screen
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        	bsView.setNumColumns(3);
        } else if (config.orientation == Configuration.ORIENTATION_PORTRAIT){
        	bsView.setNumColumns(2);
        }    	
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    	initGrid(newConfig);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
