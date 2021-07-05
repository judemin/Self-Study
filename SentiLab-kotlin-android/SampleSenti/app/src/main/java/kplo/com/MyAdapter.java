package kplo.com;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<NewsDataParsing> localDataSet;

    /**
     *
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView _mtextView;
        private final TextView _mtextViewTitle;
        private ImageView _mImageView;
        public ImageView mImageView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            _mtextViewTitle = (TextView) view.findViewById(R.id.row_news_tv_title);
            _mtextView = (TextView) view.findViewById(R.id.row_news_tv_content);
            _mImageView = (ImageView) view.findViewById(R.id.row_news_iv);
        }

        public TextView getTextView() {
            return _mtextView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public MyAdapter(List<NewsDataParsing> dataSet) { // 데이터 셋의 자료형을 자유롭게 설정 가능
        localDataSet = dataSet; // 초기 데이터 형태를 넣어주는데, 스트링 배열로 넣어줌
        // 뷰 홀더가 dataset의 길이만큼 반복한다
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_news, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) { // 반복한 컨텐츠를 bind한다 (push)

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        //viewHolder.getTextView().setText(localDataSet[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        //return localDataSet.length;
        return 0;
    }
}
