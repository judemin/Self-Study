package kplo.com;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
    private String[] _myDataset = {"1","2"};

    private RecyclerView _mRecyclerView;
    private RecyclerView.Adapter _mAdapter;
    private RecyclerView.LayoutManager _mLayoutManager;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        _mRecyclerView = (RecyclerView) findViewById(R.id.my_recy_view);

        _mRecyclerView.setHasFixedSize(true);

        _mLayoutManager = new LinearLayoutManager(this);
        _mRecyclerView.setLayoutManager(_mLayoutManager);

        /// 1. 화면 로딩 -> 뉴스 정보 받아오기 ///
        queue = Volley.newRequestQueue(this); // queue 작업 변수 초기화
        getNews();

        /// 2. 정보 -> 어댑터에 넘겨준다 ///
        /// 3. 어댑터 -> 받아온 정보 세팅 ///
    }

    public void getNews(){
        // Instantiate the RequestQueue.
        String url ="https://newsapi.org/v2/top-headlines?country=kr&apiKey=2ddd51b6b50d418f92204e71201e778b";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) { // 필요한 내용만 getter setter로 담는 class 필요
                        Log.d("NewsActivity",response);

                        try {
                            // respnse 데이터 -> NewsDataParsing Class로 넣어서 분류
                            List<NewsDataParsing> news = new ArrayList<>();

                            JSONObject jsonObj = new JSONObject(response);

                            JSONArray jsonArr = jsonObj.optJSONArray("articles");

                            for(int i = 0;i < jsonArr.length();i++){
                                JSONObject tObj = jsonArr.getJSONObject(i);
                                Log.d("NewsActivity",tObj.toString());

                                NewsDataParsing newsData = new NewsDataParsing();
                                newsData.set_title(tObj.getString("title"));
                                newsData.set_urlImage(tObj.getString("urlToImage"));
                                newsData.set_content(tObj.getString("content"));

                                news.add(newsData);
                            }

                            _mAdapter = new MyAdapter(news);
                            _mRecyclerView.setAdapter(_mAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("NewsActivity","String Request Error!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
