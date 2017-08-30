package com.example.usinguicontrols;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PButton extends Button {

	public PButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		initProperties();
	}

	public PButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		initProperties();
	}

	public PButton(Context context) {
		super(context);

		initProperties();
	}


	private void initProperties(){
		setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ViewGroup vg = (ViewGroup) getParent();
				vg.removeView(PButton.this);
			}
		});
	}

}
