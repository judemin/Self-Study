package kplo.com;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<ChatData> localDataSet;
    private String _nickName;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView _tv_nick;
        private final TextView _tv_msg;
        public View rootView;

        public ViewHolder(View view) {
            super(view);

            _tv_nick = (TextView) view.findViewById(R.id.row_chat_tv_nickname);
            _tv_msg = (TextView) view.findViewById(R.id.row_chat_tv_msg);
            rootView = view;
        }
    }

    public ChatAdapter(List<ChatData> dataSet, Context context, String mNickName) { // 데이터 셋의 자료형을 자유롭게 설정 가능
        localDataSet = dataSet; // 초기 데이터 형태를 넣어주는데, 배열로 넣어줌
        _nickName = mNickName;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_chat, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) { // 반복한 컨텐츠를 bind한다 (push)
        // position은 인덱스 번호

        ChatData chat = localDataSet.get(position);

        viewHolder._tv_nick.setText(chat.get_nickname());
        viewHolder._tv_msg.setText(chat.get_msg());

        if(chat.get_nickname().equals(this._nickName)){
            viewHolder._tv_nick.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            viewHolder._tv_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return localDataSet == null ? 0 : localDataSet.size(); // 삼항 연산자
    }

    public ChatData getChat(int position){
        return localDataSet != null ? localDataSet.get(position) : null;
    }

    public void addChat(ChatData chat){
        localDataSet.add(chat);
        // 로컬 데이터 셋에 데이터를 넣어주면 notify해줘여 함
        notifyItemInserted(localDataSet.size() - 1); // position이 어디인지 같이 알려줘야 함
        // 데이터 갱신용 코드
    }
}
