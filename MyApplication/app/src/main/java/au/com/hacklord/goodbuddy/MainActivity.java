package au.com.hacklord.goodbuddy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import au.com.hacklord.goodbuddy.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {

    LoginFragment loginFragment;

    View fragmentContainer;
    Button button;
    static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentContainer = findViewById(R.id.main_fragment_container);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"button clicked!");
            }
        });

        initFragments();
    }

    @Override
    protected void onResume() {
        super.onResume();

        checkIsLoggedIn();
    }

    void checkIsLoggedIn()
    {

    }

    void initFragments()
    {
        loginFragment = LoginFragment.newInstance();
    }

    void swapFragment(Fragment fragment, boolean addToBackStack)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_fragment_container, fragment);

        if(addToBackStack)
        {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

}
