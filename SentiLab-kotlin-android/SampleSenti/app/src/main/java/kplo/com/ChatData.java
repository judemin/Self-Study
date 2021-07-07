package kplo.com;

import java.io.Serializable;

// chat을 위한 dto
public class ChatData implements Serializable {
    private String _msg;
    private String _nickname;

    public String get_msg() {
        return _msg;
    }

    public void set_msg(String _msg) {
        this._msg = _msg;
    }

    public String get_nickname() {
        return _nickname;
    }

    public void set_nickname(String _nickname) {
        this._nickname = _nickname;
    }
}
