package at.htl.todo;

import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;

import javax.inject.Inject;

import at.htl.todo.model.ModelStore;
import at.htl.todo.ui.layout.DetailView;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailActivity extends ComponentActivity {

    static final String TAG = DetailActivity.class.getSimpleName();

    @Inject
    DetailView detailView;

    @Inject
    ModelStore store;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Config.load(this);

        detailView.buildContent(this);
    }
}
