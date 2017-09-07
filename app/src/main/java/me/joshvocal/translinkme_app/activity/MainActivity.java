package me.joshvocal.translinkme_app.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.joshvocal.translinkme_app.R;
import me.joshvocal.translinkme_app.fragment.FavouritesFragment;
import me.joshvocal.translinkme_app.fragment.LocationFragment;
import me.joshvocal.translinkme_app.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    // Bind Bottom Navigation View
    @BindView(R.id.navigation)
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ButterKnife bind
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            switchToSearchFragment();
        }

        mBottomNavigationView.setSelectedItemId(R.id.navigation_search);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void switchToSearchFragment() {
        setTitle(R.string.fragment_search_title);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new SearchFragment())
                .commit();
    }

    private void switchToFavouritesFragment() {
        setTitle(R.string.fragment_favourites_title);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new FavouritesFragment())
                .commit();
    }

    private void switchToLocationFragment() {
        setTitle(R.string.fragment_location_title);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new LocationFragment())
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_location:
                switchToLocationFragment();
                return true;
            case R.id.navigation_search:
                switchToSearchFragment();
                return true;
            case R.id.navigation_favourite:
                switchToFavouritesFragment();
                return true;
        }

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.action_about:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle(getString(R.string.main_activity_alert_dialog_title,
                        getString(R.string.app_name), getString(R.string.app_version)))
                        .setMessage(getString(R.string.main_activity_alert_dialog_body))
                        .setNegativeButton(R.string.main_activity_alert_dialog_github_button,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent webIntent = new Intent(Intent.ACTION_VIEW);
                                        webIntent.setData(Uri.parse(
                                                getString(R.string.main_activity_alert_dialog_github_url)));
                                        startActivity(webIntent);
                                    }
                                })
                        .setPositiveButton(android.R.string.yes,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        // Do nothing.
                                    }
                                }).show();

                return true;
        }

        return true;
    }
}
