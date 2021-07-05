package kplo.com;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsActivity extends AppCompatActivity {
    private String[] _myDataset = {"1","2"};

    private RecyclerView _mRecyclerView;
    private RecyclerView.Adapter _mAdapter;
    private RecyclerView.LayoutManager _mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        _mRecyclerView = (RecyclerView) findViewById(R.id.my_recy_view);

        _mRecyclerView.setHasFixedSize(true);

        _mLayoutManager = new LinearLayoutManager(this);
        _mRecyclerView.setLayoutManager(_mLayoutManager);

        _mAdapter = new MyAdapter(_myDataset);
        _mRecyclerView.setAdapter(_mAdapter);
    }
}
