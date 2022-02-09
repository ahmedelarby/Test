package com.example.countries.Ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countries.Model.Photo;
import com.example.countries.Model.Photos;
import com.example.countries.Model.Root;
import com.example.countries.R;
import com.example.countries.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MoveViewModel moveViewModel;
    boolean haveNextPage=true;

    Adapter adapter;
    int NextPage= 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        moveViewModel= ViewModelProviders.of(this).get(MoveViewModel.class);
        moveViewModel.getPosts(NextPage);


        adapter= new Adapter();
        binding.rec.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.rec.setLayoutManager(manager);
        binding.rec.setAdapter(adapter);
        binding.rec.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!binding.rec.canScrollVertically(1)&&newState==binding.rec.SCROLL_STATE_IDLE){
                    NextPage=NextPage+20;
                    moveViewModel.getPosts(NextPage);
                    Toast.makeText(getApplicationContext(), "last"+NextPage, Toast.LENGTH_SHORT).show();
                    binding.progressBar.setVisibility(View.VISIBLE);



                }
            }
        });


    moveViewModel.postsMutableLiveData.observe(this, new Observer<Root>() {
    @Override
    public void onChanged(Root roots) {

        adapter.setList(roots.getPhotos().getPhoto());

        binding.progressBar.setVisibility(View.GONE);



        Toast.makeText(MainActivity.this, "Get", Toast.LENGTH_SHORT).show();


     }

    });







    }

}
