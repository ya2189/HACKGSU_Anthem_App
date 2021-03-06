package com.example.philipphiri.hackgsuanthemapp;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.text.Html;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.philipphiri.hackgsuanthemapp.MainActivity.butFive;
import static com.example.philipphiri.hackgsuanthemapp.MainActivity.butFour;
import static com.example.philipphiri.hackgsuanthemapp.MainActivity.butOne;
import static com.example.philipphiri.hackgsuanthemapp.MainActivity.butThree;
import static com.example.philipphiri.hackgsuanthemapp.MainActivity.butTwo;

public class emoji_response extends AppCompatActivity {

    ImageView emoji;
    TextView emoji_emotion;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button submit;
    boolean buttonNewResponse = false;
    Dialog myDialog;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mTog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji_response);
        myDialog = new Dialog(this);
        initInstances();
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
//        mTog = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
//        mDrawerLayout.addDrawerListener(mTog);
//        mTog.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        emoji = (ImageView) findViewById(R.id.emoji_imageView);
        emoji_emotion = (TextView) findViewById(R.id.emoji_emotion);
        button1 = (Button) findViewById(R.id.response1);
        button2 = (Button) findViewById(R.id.response2);
        button3 = (Button) findViewById(R.id.response3);
        button4 = (Button) findViewById(R.id.response4);
        button4.setText("Another Reason?");

        if (butOne == false) {
            emoji.setImageResource(R.drawable.emoji1);

            emoji_emotion.setText("Exhausted");

            button1.setText("The system is continuously having errors.");
            button2.setText("I do not feel respected at my workplace.");
            button3.setText("Conflicts within the team are not getting fixed.");

        } else if (butTwo == false) {
            emoji.setImageResource(R.drawable.emoji2);

            emoji_emotion.setText("Anxious");

            button1.setText("The system has an error.");
            button2.setText("I feel as though my work is not being used efficiently.");
            button3.setText("I had a unresolved conflict with my manager or coworker.");
        } else if (butThree == false) {
            emoji.setImageResource(R.drawable.emoji3);

            emoji_emotion.setText("Content");

            button1.setText("I have not run into any issues with the app.");
            button2.setText("I am contributing to my team and my company.");
            button3.setText("My relationships with my coworkers and manager are healthy.");
        } else if (butFour == false) {
            emoji.setImageResource(R.drawable.emoji4);

            emoji_emotion.setText("Happy");

            button1.setText("The app is useful and I want to use it again.");
            button2.setText("I enjoy working with my team.");
            button3.setText("My company is a great fit for me.");
        } else if (butFive == false) {
            emoji.setImageResource(R.drawable.emoji5);

            emoji_emotion.setText("Excited");

            button1.setText("The app is great and very helpful!");
            button2.setText("I couldn't ask for a better team!");
            button3.setText("I am excited for the opportunities at my company.");
        }

        submit = (Button)findViewById(R.id.submit_button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonNewResponse = true;
                button1.setBackgroundResource(R.drawable.selected_button);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonNewResponse = true;
                button2.setBackgroundResource(R.drawable.selected_button);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonNewResponse = true;
                button3.setBackgroundResource(R.drawable.selected_button);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button4.setBackgroundResource(R.drawable.selected_button);
                showElaboratePopUp(view);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (buttonNewResponse) {
                    startActivity(new Intent(emoji_response.this, elaborate_activity.class));
                } else {
                    //startActivity(new Intent(emoji_response.this, Feed_Activity.class));

                }
            }
        });
    }
    private void initInstances() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mTog = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mTog);
        mTog.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigation;

        navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.myVitals:
                        startActivity(new Intent(emoji_response.this, Vitals_Activity.class));
                        break;
                    case R.id.teamVitals:
                        startActivity(new Intent(emoji_response.this, TeamVitals_Activity.class));
                        break;
                    case R.id.companyVitals:
                        startActivity(new Intent(emoji_response.this, CompanyVitals_Activity.class));
                        break;
                    case R.id.about:
                        startActivity(new Intent(emoji_response.this, aboutPage.class));
                        // add navigation drawer item onclick method here
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mTog.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showElaboratePopUp(View v) {
        TextView xclose;
        Button submit;
        myDialog.setContentView(R.layout.elaborate_pop_up);
        xclose = myDialog.findViewById(R.id.xclose);
        submit = myDialog.findViewById(R.id.submit_btn);
        TextView msg;
        msg = myDialog.findViewById(R.id.contentmsg);
        if (butOne == false) {
            String first = "I am feeling ";
            String next = "<font color='#E4A130'>exhausted</font>";
            String last = " because";
            msg.setText(Html.fromHtml(first + next + last));

        } else if (butTwo == false) {
            String first = "I am feeling ";
            String next = "<font color='#E4A130'>anxious</font> ";
            String last = " because";
            msg.setText(Html.fromHtml(first + next + last));
            //msg.setText("I am feeling anxious because");
        } else if (butThree == false) {
            String first = "I am feeling ";
            String next = "<font color='#E4A130'>content</font> ";
            String last = " because";
            msg.setText(Html.fromHtml(first + next + last));
            //msg.setText("I am feeling content because");
        } else if (butFour == false) {
            String first = "I am feeling ";
            String next = "<font color='#E4A130'>happy</font> ";
            String last = " because";
            msg.setText(Html.fromHtml(first + next + last));
            //msg.setText("I am feeling happy because");
        } else if (butFive == false) {
            String first = "I am feeling ";
            String next = "<font color='#E4A130'>excited</font> ";
            String last = " because";
            msg.setText(Html.fromHtml(first + next + last));
            //msg.setText("I am feeling excited because");
        }
        xclose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(emoji_response.this, Feed_Activity.class));
            }
        });
    }
}
