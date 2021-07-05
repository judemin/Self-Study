package kplo.com;

import java.io.Serializable;

public class NewsDataParsing implements Serializable {
    private String _title; // 캡슐화 위해서 private로 선언
    private String _urlImage;
    private String _content;

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_urlImage() {
        return _urlImage;
    }

    public void set_urlImage(String _urlImage) {
        this._urlImage = _urlImage;
    }

    public String get_content() {
        return _content;
    }

    public void set_content(String _content) {
        this._content = _content;
    }
}
