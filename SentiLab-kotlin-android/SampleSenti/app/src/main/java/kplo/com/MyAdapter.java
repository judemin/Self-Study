package kplo.com;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<NewsDataParsing> localDataSet;
    private static View.OnClickListener _mOnClick;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView _mtextView;
        private final TextView _mtextViewTitle;
        private SimpleDraweeView _mImageView;
        public View rootView;

        public ViewHolder(View view) {
            super(view);

            _mtextViewTitle = (TextView) view.findViewById(R.id.row_news_tv_title);
            _mtextView = (TextView) view.findViewById(R.id.row_news_tv_content);
            _mImageView = (SimpleDraweeView) view.findViewById(R.id.row_news_iv);
            rootView = view;

            view.setClickable(true);
            view.setEnabled(true);
            view.setOnClickListener(_mOnClick);
        }

        public TextView getTextView() {
            return _mtextView;
        }
    }

    public MyAdapter(List<NewsDataParsing> dataSet, Context context, View.OnClickListener onClick) { // 데이터 셋의 자료형을 자유롭게 설정 가능
        localDataSet = dataSet; // 초기 데이터 형태를 넣어주는데, 스트링 배열로 넣어줌
        // 뷰 홀더가 dataset의 길이만큼 반복한다
        Fresco.initialize(context);
        _mOnClick = onClick;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_news_card, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) { // 반복한 컨텐츠를 bind한다 (push)
        // position은 인덱스 번호

        NewsDataParsing tmpNews = localDataSet.get(position);

        viewHolder._mtextViewTitle.setText(tmpNews.get_title());
        viewHolder._mtextView.setText(tmpNews.get_content());
        // 이미지 url을 통해 이미지를 가져와야 함 => fresco
        Uri uri = Uri.parse(tmpNews.get_urlImage());
        viewHolder._mImageView.setImageURI(uri);

        // tag를 달아줘야 함
        viewHolder.rootView.setTag(position); // 루트뷰에게 태그(순서값)을 붙여줌
    }

    @Override
    public int getItemCount() {
        return localDataSet == null ? 0 : localDataSet.size(); // 삼항 연산자
    }

    public NewsDataParsing getNews(int position){ // NewsActivity에서 데이터 가져오기 위한 함수
        return localDataSet != null ? localDataSet.get(position) : null;
    }
}
