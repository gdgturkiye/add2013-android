package org.gdgankara.app.activities;

import java.util.ArrayList;
import java.util.Locale;

import org.gdgankara.app.R;
import org.gdgankara.app.adapeters.TagListAdapter;
import org.gdgankara.app.io.TagHandler;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TagListActivity extends Activity{
	
	private TagHandler tag_handler;
	private ArrayList<String> tag_list;
	private ListView tag_listview;
	private ArrayAdapter<String> taglist_adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setActivityTheme(getDimensionsOfScreen());
		setContentView(R.layout.taglist);
		
		getTagList();
		setUpView();
		
		
	}
	
	private void getTagList(){
		tag_handler=new TagHandler(this);
		if(Locale.getDefault().getLanguage().equals("tr")){
			tag_list=tag_handler.getTagList("tr");
		}
		else{
			tag_list=tag_handler.getTagList("en");
		}
	}
	
	private void setUpView(){
		tag_listview=(ListView)findViewById(R.id.taglist);
		taglist_adapter=new TagListAdapter(this, tag_list);
		tag_listview.setAdapter(taglist_adapter);
	}
	
	private int getDimensionsOfScreen(){
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		return metrics.heightPixels;

	}
	
	private void setActivityTheme(int height){
		
		
		if(height<=320){
			setTheme(R.style.tagList_low);
		}
		else if(height<=480){
			setTheme(R.style.tagList_Medium);
		}
		else if(height<=800){
			setTheme(R.style.tagList_High);
		}
		else{
			setTheme(R.style.tagList_XHigh);
		}
		
	}

}
