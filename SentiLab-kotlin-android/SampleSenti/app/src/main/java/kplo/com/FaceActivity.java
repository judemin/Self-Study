package kplo.com;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
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

        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.yua);

        InputImage image = InputImage.fromBitmap(bitmap, 0);
        FaceDetector detector = FaceDetection.getClient();

        Task<List<Face>> result =
                detector.process(image)
                        .addOnSuccessListener(
                                new OnSuccessListener<List<Face>>() {
                                    @Override
                                    public void onSuccess(List<Face> faces) {

                                        Log.d("Faces",faces.toString());

                                        for (Face face : faces) {
                                            // 왼쪽 눈을 랜드마크로서 꺼내올 수 있다
                                            FaceLandmark lefteye = face.getLandmark(FaceLandmark.LEFT_EYE);
                                            lefteye.getPosition();

                                            // 스티커 이미지를 가져와서 기존 이미지 뷰에 올려야 함

                                            FaceLandmark leftcheek = face.getLandmark(FaceLandmark.LEFT_CHEEK);
                                            leftcheek.getPosition();

                                            FaceLandmark rightcheek = face.getLandmark(FaceLandmark.RIGHT_CHEEK);
                                            rightcheek.getPosition();

                                            ImageView imageLE = new ImageView(mContext);
                                            imageLE.setImageResource(R.drawable.blush);
                                            relLay_main.addView(imageLE);

                                            ImageView imageLC = new ImageView(mContext);
                                            imageLC.setImageResource(R.drawable.left_cat);
                                            relLay_main.addView(imageLC);

                                            ImageView imageRC = new ImageView(mContext);
                                            imageRC.setImageResource(R.drawable.right_cat);
                                            relLay_main.addView(imageRC);
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
