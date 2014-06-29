package com.danielme.tipsandroid.imeoptions;

import com.danieme.tipsandroid.imeoptions.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.OnEditorActionListener;

/**
 * 
 * @author danielme.com
 * 
 */
public class MainActivity extends Activity
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EditText sendEditText = (EditText) findViewById(R.id.editText1);
		
		//set focus and show keyboard
		sendEditText.requestFocus();
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
		
		sendEditText.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView textView, int actionId, KeyEvent event)
			{
				boolean action = false;
				if (actionId == EditorInfo.IME_ACTION_SEND)
				{
					// hide keyboard
					InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
					inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);

					Toast.makeText(MainActivity.this, R.string.send, Toast.LENGTH_SHORT).show();
					action = true;
				}
				return action; 
			}
		});
		
		EditText searchEditText = (EditText) findViewById(R.id.editText2);
		searchEditText.setOnEditorActionListener(new OnEditorActionListener()
		{
			@Override
			public boolean onEditorAction(TextView textView, int actionId, KeyEvent event)
			{
				boolean action = false;
				if (actionId == EditorInfo.IME_ACTION_SEARCH)
				{
					//hide keyboard
					InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
					inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);
					
					Toast.makeText(MainActivity.this, R.string.search, Toast.LENGTH_SHORT).show();
					action = true;
				}
				return action;
			}
		});		
		
		EditText customEditText = (EditText) findViewById(R.id.editText3);
		customEditText.setOnEditorActionListener(new OnEditorActionListener()
		{
			@Override
			public boolean onEditorAction(TextView textView, int actionId, KeyEvent event)
			{
				boolean action = false;
				if (actionId == R.id.action_custom || actionId == EditorInfo.IME_ACTION_UNSPECIFIED)
				{
					//hide keyboard
					InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
					inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);
					
					Toast.makeText(MainActivity.this, R.string.custom, Toast.LENGTH_SHORT).show();
					action = true;
				}
				return action;
			}
		});		

	}
}