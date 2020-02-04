package com.example.rockpaperscissors;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        Weapon.determineWinner();

        return super.onOptionsItemSelected(item);
    }


    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");
        private String message;

        private Weapon(String msg) {
            message = msg;
        }

        public static void determineWinner() {
        }

        @Override
        public String toString() {
            return message;
        }

    }

    ;

    public static Weapon determineWinner(Weapon p1, Weapon p2) {
        boolean p1_winner = false;
        boolean p2_winner = false;

        switch (p1) {
            case ROCK:
                if (p2 == Weapon.SCISSORS)
                    p1_winner = true;
                break;
            case PAPER:
                if (p2 == Weapon.ROCK)
                    p1_winner = true;
                break;
            case SCISSORS:
                if (p2 == Weapon.PAPER)
                    p1_winner = true;
                break;

        }
    }
}
    
