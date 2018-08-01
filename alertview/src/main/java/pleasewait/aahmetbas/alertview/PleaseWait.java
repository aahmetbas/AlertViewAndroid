package pleasewait.aahmetbas.alertview;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PleaseWait extends ProgressDialog {
    private RelativeLayout pleaseWait, alertMessage;
    private ImageView progress;
    private TextView progressMessage;
    private TextView alertMessageTitle, alertMessageMessage;
    private Button alertMessageDone;

    private String title = "", message = "";
    private AnimationDrawable spinner;

    private String pleaseWaitText = "Please wait....", doneButton = "OK";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.please_wait);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        pleaseWait      = (RelativeLayout)(findViewById(R.id.pleaseWait));
        alertMessage    = (RelativeLayout)(findViewById(R.id.alertMessage));

        progressMessage = (TextView)(findViewById(R.id.progressMessage));
        progress        = (ImageView) (findViewById(R.id.progress));
        spinner         = (AnimationDrawable) progress.getBackground();
        spinner.start();
        progressMessage.setText(pleaseWaitText);

        alertMessageDone    = (Button) (findViewById(R.id.alertMessageCancel));
        alertMessageTitle   = (TextView)(findViewById(R.id.alertMessageTitle));
        alertMessageMessage = (TextView)(findViewById(R.id.alertMessageMessage));
        alertMessageDone.setText(doneButton);
        alertMessageDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        if(!title.equals("") || !message .equals("")){
            alertMessage.setVisibility(View.VISIBLE);
            pleaseWait.setVisibility(View.GONE);
            spinner.stop();
            alertMessageTitle.setText(title);
            alertMessageMessage.setText(message);
        }else{
            pleaseWait.setVisibility(View.VISIBLE);
            alertMessage.setVisibility(View.GONE);
        }
    }

    public PleaseWait(Context context) {
        super(context);
        setCancelable(false);
        show();
    }

    public PleaseWait(Context context, String message) {
        super(context);
        setCancelable(false);
        this.pleaseWaitText = message;
        show();
    }

    public void showResult(final String title, final String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable(){
            @Override
            public void run() {
                spinner.stop();
                pleaseWait.setVisibility(View.GONE);
                alertMessage.setVisibility(View.VISIBLE);
                setCancelable(false);
            }
        });

        this.alertMessageTitle.post(new Runnable() {
            public void run() {
                alertMessageTitle.setText(title);
            }
        });

        this.alertMessageMessage.post(new Runnable() {
            public void run() {
                alertMessageMessage.setText(message);
            }
        });
    }

    public void showResult(final String title, final String message, final String buttonText) {
        new Handler(Looper.getMainLooper()).post(new Runnable(){
            @Override
            public void run() {
                spinner.stop();
                pleaseWait.setVisibility(View.GONE);
                alertMessage.setVisibility(View.VISIBLE);
                setCancelable(false);
            }
        });

        this.alertMessageTitle.post(new Runnable() {
            public void run() {
                alertMessageTitle.setText(title);
            }
        });

        this.alertMessageMessage.post(new Runnable() {
            public void run() {
                alertMessageMessage.setText(message);
            }
        });

        this.alertMessageDone.post(new Runnable() {
            @Override
            public void run() {
                alertMessageDone.setText(buttonText);
            }
        });
    }

    public void updateMessage(final String message){
        this.progressMessage.post(new Runnable() {
            public void run() {
                progressMessage.setText(message);
            }
        });
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}