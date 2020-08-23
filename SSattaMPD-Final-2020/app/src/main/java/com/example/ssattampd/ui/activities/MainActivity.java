package com.example.ssattampd.ui.activities;

/*  Starter project for Mobile Platform Development in Semester B Session 2019/2020
    You should use this project as the starting point for your assignment.
    This project simply reads the data from the required URL and displays the
    raw data in a TextField
*/

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
// Programme of Study   Computer Games Software Development
////////////////////////////////////////////////////////////////////////////////

// Update the package name to include your Student Identifier

//Data - Models - Responses
//Date - Repos
//Data - Sources - Location (Locale?)/Remote
//UI - Activities - MA
//Ui - Fragments - Weather Loc/Locations/Settings

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.example.ssattampd.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //@Override
    //protected void onResume() {
    //    super.onResume();
    //    new UpdateData().execute();
//
    //}

    public void setUpTitle(String title) {
        if (title != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void replaceFragment(int actionId, @Nullable Bundle args) {
        Navigation.findNavController(this, R.id.main_nav_fragment).navigate(actionId, args);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showBackButton(boolean canShowBack) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(canShowBack);
    }

    //@Override
    //protected void onStart() {
    //    super.onStart();
    //}

    //Doesnt work
    //D

    //public void resViewSetup(List<XMLParser.Item> thisList) {
    //   recyclerView = findViewById(R.id.rView);
    //
    //   // use this setting to improve performance if you know that changes
    //   // in content do not change the layout size of the RecyclerView
    //   recyclerView.setHasFixedSize(true);
    //
    // use a linear layout manager
    //
    //    layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    //    recyclerView.setLayoutManager(layoutManager);
    //
    //
    //   // specify an adapter (see also next example)
    //  XMLParser.Item[] items = new XMLParser.Item[thisList.size()];
    //   int i = 0;
    //   for (XMLParser.Item Item : thisList) {
    //       items[i] = Item;
    //       i++;
    //   }
    //
    //  //Update Recycler view list
    // mAdapter = new MyAdapter(items);
    //recyclerView.setAdapter(mAdapter);
    //}


}