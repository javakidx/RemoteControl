package com.bignerdranch.android.remotecontrol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by bioyang on 15/8/9.
 */
public class RemoteControlFragment extends Fragment
{
    private TextView mSelectedTextView;
    private TextView mWorkingTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_remote_control, container, false);

        mSelectedTextView = (TextView)v.findViewById(R.id.fragment_remote_control_selectedTextView);
        mWorkingTextView = (TextView)v.findViewById(R.id.fragment_remote_control_workingTextView);

        View.OnClickListener numberButtonListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView textView = (TextView)v; //因為Button是TextView的子類別
                String working = mWorkingTextView.getText().toString();
                String text = textView.getText().toString();

                if("0".equals(working))
                {
                    mWorkingTextView.setText(text);
                }
                else
                {
                    mWorkingTextView.setText(working + text);
                }
            }
        };

        Button zeroButton = (Button)v.findViewById(R.id.fragment_remote_control_zeroButton);
        zeroButton.setOnClickListener(numberButtonListener);

        Button oneButton = (Button)v.findViewById(R.id.fragment_remote_control_oneButton);
        oneButton.setOnClickListener(numberButtonListener);

        Button enterButton = (Button)v.findViewById(R.id.fragment_remote_control_enterButton);
        enterButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CharSequence working = mWorkingTextView.getText();
                if(working.length() > 0)
                {
                    mSelectedTextView.setText(working);
                }
                mWorkingTextView.setText("0");
            }
        });

        return v;
    }
}
