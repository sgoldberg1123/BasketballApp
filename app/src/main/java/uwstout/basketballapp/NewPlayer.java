package uwstout.basketballapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewPlayer extends AppCompatActivity {

    private static final int CAMERA_IMAGE_CAPTURE = 0;
    private static final int UPLOAD_IMAGE_FROM_GALLERY = 1;

    Button btnCamera, btnUpload, btnCreate, btnDelete;
    ImageView imgPlayer;
    Spinner positionSpinner;
    NumberPicker positionNP;
    TextView playerName;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_player);

        btnCamera = (Button) findViewById(R.id.btnCamera);
        btnUpload = (Button) findViewById(R.id.btnUpload);
        btnDelete = (Button) findViewById(R.id.btnDeletePlayer);
        imgPlayer = (ImageView) findViewById(R.id.playerPhoto);
        playerName = (TextView) findViewById(R.id.editPlayerName);
        positionNP = (NumberPicker) findViewById(R.id.playerNumberPicker);

        //activates camera function
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_IMAGE_CAPTURE);
            }
        });

        //activates upload function
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uploadIntent = new Intent();
                uploadIntent.setType("image/*");
                uploadIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(uploadIntent, "Select Picture"), UPLOAD_IMAGE_FROM_GALLERY);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(NewPlayer.this);
                alertBuilder.setTitle("Delete Player");
                alertBuilder.setMessage("Are you sure you want to delete this player?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deletePlayerStats();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick (DialogInterface dialog,int id){
                                dialog.cancel();
                            }
                        });

                AlertDialog alert2 = alertBuilder.create();

                alert2.show();
            }
        });

        populateItemsOnSpinner();
        populateNumberPicker();
    }

    private void deletePlayerStats() {
        imgPlayer.setImageDrawable(null);
        positionSpinner.setSelection(0);
        playerName.setText("Player Name");
        positionNP.setValue(0);
    }

    private void populateNumberPicker() {
        positionNP.setMinValue(0);
        positionNP.setMaxValue(99);
        positionNP.setWrapSelectorWheel(true);
    }

    private void populateItemsOnSpinner() {
        positionSpinner = (Spinner) findViewById(R.id.spinnerPosition);
        //  List<String> posList = new ArrayList<String>();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_IMAGE_CAPTURE) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imgPlayer.setImageBitmap(image);
        } else {
            Uri selectedImage = data.getData();
            Bitmap image = null;
            try {
                image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imgPlayer.setImageBitmap(image);
        }
    }

}
