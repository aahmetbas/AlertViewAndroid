package pleasewait.aahmetbas.alertview;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AlertMessage extends ProgressDialog {
    private RelativeLayout alertMessage, alertWithButton;
    private TextView alertMessageTitle, alertWithButtonTitle;
    private TextView alertMessageMessage, alertWithButtonMessage;
    private Button alertMessageDone, alertWithButtonCancel, alertWithButtonOk;

    private String title = "", message = "";
    private AlertListener alertListener = null;

    private String possitiveButton = "Yes", negativeButton = "No", doneButton = "OK";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_view);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        alertMessage    = (RelativeLayout)(findViewById(R.id.alertMessage));
        alertWithButton = (RelativeLayout)(findViewById(R.id.alertWithCancel));

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

        alertWithButtonCancel   = (Button) (findViewById(R.id.alertWithCancelCancel));
        alertWithButtonOk       = (Button) (findViewById(R.id.alertWithCancelOk));
        alertWithButtonTitle    = (TextView) (findViewById(R.id.alertWithCancelTitle));
        alertWithButtonMessage  = (TextView) (findViewById(R.id.alertWithCancelMessage));
        alertWithButtonCancel.setText(negativeButton);
        alertWithButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        alertWithButtonOk.setText(possitiveButton);
        alertWithButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                alertListener.onAccepted();
            }
        });

        if(alertListener != null) {
            alertWithButton.setVisibility(View.VISIBLE);
            alertMessage.setVisibility(View.GONE);
            alertWithButtonTitle.setText(title);
            alertWithButtonMessage.setText(message);
        }else if((!title.equals("") || !message .equals("")) && alertListener == null){
            alertMessage.setVisibility(View.VISIBLE);
            alertWithButton.setVisibility(View.GONE);
            alertMessageTitle.setText(title);
            alertMessageMessage.setText(message);
        }else{
            alertMessage.setVisibility(View.GONE);
            alertWithButton.setVisibility(View.GONE);
        }
    }

    public AlertMessage(Context context, String title, String message){
        super(context);
        this.title = title;
        this.message = message;
        setCancelable(false);
        show();
    }

    public AlertMessage(Context context, String title, String message, String buttonText){
        super(context);
        this.title = title;
        this.message = message;
        this.doneButton = buttonText;
        setCancelable(false);
        show();
    }

    public AlertMessage(Context context, String title, String message, AlertListener alertListener){
        super(context);
        this.title = title;
        this.message = message;
        this.alertListener = alertListener;
        setCancelable(false);
        show();
    }

    public AlertMessage(Context context, String title, String message, String positiveButtonText, String negativeButtonText, AlertListener alertListener){
        super(context);
        this.title = title;
        this.message = message;
        this.possitiveButton = positiveButtonText;
        this.negativeButton = negativeButtonText;
        this.alertListener = alertListener;
        setCancelable(false);
        show();
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
