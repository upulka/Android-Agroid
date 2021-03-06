package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class card1details extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView menuIcon;

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuicon;

    TextView a,b,c,d;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card1details);

         menuIcon = findViewById(R.id.menuIcon);

        a=(TextView)findViewById(R.id.texthead);
        b=(TextView)findViewById(R.id.textView4);
        c=(TextView)findViewById(R.id.textView6);
        d=(TextView)findViewById(R.id.textView8);


        reff= FirebaseDatabase.getInstance().getReference().child("DeisesID").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Name=dataSnapshot.child("name").getValue().toString();
                String Cause_it=dataSnapshot.child("cause_it").getValue().toString();
                String Look_like=dataSnapshot.child("look_like").getValue().toString();
                String Can_do=dataSnapshot.child("can_do").getValue().toString();
                a.setText(Name);
                b.setText(Cause_it);
                c.setText(Look_like);
                d.setText(Can_do);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//menu huk
        drawerLayout = findViewById(R.id.drawer_layout);
                navigationView = findViewById(R.id.navigation_view);
                menuicon = findViewById(R.id.menuIcon);


                //nav drawer


                navigationDrawer();
                }

private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuicon.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        if (drawerLayout.isDrawerVisible(GravityCompat.START))
        drawerLayout.closeDrawer(GravityCompat.START);

        else drawerLayout.openDrawer(GravityCompat.START);
        }
        });
        }

@Override
public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
        drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
        }



@Override
public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
        case R.id.nav_home:
        break;


        case R.id.nav_market:
        Intent intent2 = new Intent(card1details.this,price.class);
        startActivity(intent2);
        break;
        }
        return false;
        }
        }

