package liophan.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import liophan.mvvmdemo.databinding.ActivityMainBinding;
import liophan.mvvmdemo.model.User;
import liophan.mvvmdemo.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mUserViewModel = new UserViewModel(this, User.randomUser());
        binding.setUserViewModel(mUserViewModel);
    }

    @Override
    protected void onDestroy() {
        mUserViewModel.destroy();
        super.onDestroy();
    }
}
