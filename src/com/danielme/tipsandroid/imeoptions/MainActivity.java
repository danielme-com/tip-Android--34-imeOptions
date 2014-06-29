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

		// set focus and show keyboard
		sendEditText.requestFocus();
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
 
		sendEditText.setOnEditorActionListener(new MainActivityOnEditorActionListener());			
		EditText searchEditText = (EditText) findViewById(R.id.editText2);
		searchEditText.setOnEditorActionListener(new MainActivityOnEditorActionListener());
		EditText customEditText = (EditText) findViewById(R.id.editText3);
		customEditText.setOnEditorActionListener(new MainActivityOnEditorActionListener());		

	}

	class MainActivityOnEditorActionListener implements OnEditorActionListener
	{
		@Override
		public boolean onEditorAction(TextView textView, int actionId, KeyEvent event)
		{
			boolean action = false;
			int stringId = -1;
			switch (actionId)
			{
				case EditorInfo.IME_ACTION_SEND:
					stringId = R.string.send;
					break;
				case EditorInfo.IME_ACTION_SEARCH:
					stringId = R.string.search;
					break;
				case R.id.action_custom:
				case EditorInfo.IME_ACTION_UNSPECIFIED:
					stringId = R.string.custom;
					break;
				default:
					break;
			}
			if (stringId != -1)
			{
				// hide keyboard
				InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);

				Toast.makeText(MainActivity.this, stringId, Toast.LENGTH_SHORT).show();
				action = true;
			}
			return action;
		}

	}
}