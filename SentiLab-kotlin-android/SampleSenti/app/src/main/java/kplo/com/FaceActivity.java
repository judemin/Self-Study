package kplo.com;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceContour;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.google.mlkit.vision.face.FaceLandmark;

import java.util.List;

public class FaceActivity extends Activity {

    Context mContext; // 컨텍스트는 앱의 기능들을 자유롭게 사용하기 위한 매개체

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_face);

       mContext = this;

       final RelativeLayout relLay_main = findViewById(R.id.act_face_relLay); // final로 다른 블록에서 사용

        FaceDetectorOptions highAccuracyOpts =
                new FaceDetectorOptions.Builder()
                        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                        .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
                        .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
                        .build();

        final Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.yua); // final로 다른 블록에서 사용

        InputImage inpImage = InputImage.fromBitmap(bitmap, 0);
        FaceDetector detector = FaceDetection.getClient();

        Task<List<Face>> result =
                detector.process(inpImage)
                        .addOnSuccessListener(
                                new OnSuccessListener<List<Face>>() {
                                    @Override
                                    public void onSuccess(List<Face> faces) {

                                        Log.d("Faces",faces.toString());

                                        Point p = new Point(); // p는 디스플레이
                                        Display display = getWindowManager().getDefaultDisplay();
                                        // window에서 display가져와 실제 사이즈 세팅
                                        display.getSize(p);

                                        // p.x; p.y; // 실제 포인트, 랜드마크 좌표와의 계산 필요
                                        // 1 : 10 = 10 : x
                                        // 실제 : 이미지 위치 = 추가할 이미지 : 위치

                                        for (Face face : faces) {
                                            // 왼쪽 눈을 랜드마크로서 꺼내올 수 있다
                                            FaceLandmark lefteye = face.getLandmark(FaceLandmark.LEFT_EYE);
                                            if(lefteye != null) {
                                                float lex = lefteye.getPosition().x;
                                                float ley = lefteye.getPosition().y;
                                                // 변수명 너무 짧게 (의미 알 수 없게) 짓지 말 것

                                                // 스티커 이미지를 가져와서 기존 이미지 뷰에 올려야 함
                                                ImageView imageLE = new ImageView(mContext);
                                                imageLE.setImageResource(R.drawable.blush);
                                                imageLE.setX(p.x * lex / bitmap.getWidth() - 100);
                                                // 100을 빼는 이유는  faceDetec에서 주는 값과 실제 값이 다르기 때문
                                                imageLE.setY(p.y * ley / bitmap.getHeight() - 100);
                                                imageLE.setLayoutParams(new RelativeLayout.LayoutParams(200, 200));
                                                // relative layout에서 크기 조정
                                                relLay_main.addView(imageLE);
                                            }


                                            FaceLandmark leftcheek = face.getLandmark(FaceLandmark.LEFT_CHEEK);
                                            if(leftcheek != null) {
                                                float lcx = leftcheek.getPosition().x;
                                                float lcy = leftcheek.getPosition().y;

                                                ImageView imageLC = new ImageView(mContext);
                                                imageLC.setImageResource(R.drawable.left_cat);
                                                imageLC.setX(p.x * lcx / bitmap.getWidth() - 100);
                                                imageLC.setY(p.y * lcy / bitmap.getHeight() - 100);
                                                imageLC.setLayoutParams(new RelativeLayout.LayoutParams(200, 200));
                                                relLay_main.addView(imageLC);
                                            }


                                            FaceLandmark rightcheek = face.getLandmark(FaceLandmark.RIGHT_CHEEK);
                                            if(rightcheek != null) {
                                                float rcx = rightcheek.getPosition().x;
                                                float rcy = rightcheek.getPosition().y;

                                                ImageView imageRC = new ImageView(mContext);
                                                imageRC.setImageResource(R.drawable.right_cat);
                                                imageRC.setX(p.x * rcx / bitmap.getWidth() - 100);
                                                imageRC.setY(p.y * rcy / bitmap.getHeight() - 100);
                                                imageRC.setLayoutParams(new RelativeLayout.LayoutParams(200, 200));
                                                relLay_main.addView(imageRC);
                                            }
                                        }
                                    }
                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // Task failed with an exception
                                        // ...
                                    }
                                });
    }
}
