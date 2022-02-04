package com.example.countries.Ui;

import android.os.Bundle;
import android.widget.Toast;

import com.example.countries.Ui.MoveViewModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.countries.Model.Root;
import com.example.countries.R;
import com.example.countries.databinding.ActivityMainBinding;

import java.util.List;


public class MainActivity extends AppCompatActivity {

ActivityMainBinding binding;
 MoveViewModel moveViewModel;
Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
moveViewModel= ViewModelProviders.of(this).get(MoveViewModel.class);
moveViewModel.getPosts();


        adapter= new Adapter();
        binding.rec.setHasFixedSize(true);
        binding.rec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        binding.rec.setAdapter(adapter);


moveViewModel.postsMutableLiveData.observe(this, new Observer<Root>() {
    @Override
    public void onChanged(Root roots) {
        adapter.setList(roots.getPhotos().getPhoto());
        Toast.makeText(MainActivity.this, ""+roots.getPhotos().getPage(), Toast.LENGTH_SHORT).show();
    }
});







    }
}
