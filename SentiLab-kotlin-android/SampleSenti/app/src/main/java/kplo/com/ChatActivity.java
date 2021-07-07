package kplo.com;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView _mRecyclerView;
    private RecyclerView.Adapter _mAdapter;
    private RecyclerView.LayoutManager _mLayoutManager;
    private List<ChatData> _chatList;
    private String nick = "nick2"; // 1 : n

    private EditText _et_chat;
    private Button _btn_send;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // 입력 코드

        _btn_send = findViewById(R.id.act_chat_sendBtn);
        _et_chat = findViewById(R.id.act_chat_editText);

        _btn_send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String msg = _et_chat.getText().toString();
                if(msg != null) {
                    ChatData chat = new ChatData();
                    chat.set_nickname(nick);
                    chat.set_msg(msg);
                    myRef.push().setValue(chat); // 클래스를 넘겨주는 것이 가능
                    // 주의사항 : 특정한 형태의 클래스를 넣어서 쓸때는 뺄때 조심해야 함
                    _et_chat.setText("");
                }
            }
        });


        // 리사이클러 뷰
        _mRecyclerView = (RecyclerView) findViewById(R.id.act_chat_recLay);

        _mRecyclerView.setHasFixedSize(true);

        _mLayoutManager = new LinearLayoutManager(this);
        _mRecyclerView.setLayoutManager(_mLayoutManager);

        _chatList = new ArrayList<>();
        _mAdapter = new ChatAdapter(_chatList,ChatActivity.this, nick);
        _mRecyclerView.setAdapter(_mAdapter);

        /// 1. recycler view - 반복해서 보여주는 용도 ///
        /// 2. DB 내용 넣음 ///
        /// 3. 상대방 핸드폰에 내용이 보임 ///

        // DB
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

       myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                ChatData chat = (ChatData) snapshot.getValue(ChatData.class);
                ((ChatAdapter)_mAdapter).addChat(chat); // 다운캐스팅 해줘야 함
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
