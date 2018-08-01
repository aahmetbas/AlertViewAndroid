# KÜTÜPHANEYİ PROJEYE EKLEME

Add alertview folder to your project directory

### settings.gradle
```java
include ':app', ':alertview'
```

### build.gradle in dependecies add
```java
implementation project(path: ':alertview')
```

![Alt Text](https://github.com/aahmetbas/AlertViewAndroid/blob/master/video.gif)

```java
public class MainActivity extends AppCompatActivity {
    PleaseWait pleaseWait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**** Using Please Wait ***/
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pleaseWait = new PleaseWait(MainActivity.this);
                // For changing to text, use below code
                // new PleaseWait(MainActivity.this, "Please wait...");
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        pleaseWait.showResult("Title", "Message");
                        // For changing to button text, use below code
                        // pleaseWait.showResult("Title", "Message", "ButtonText");
                        //
                        // If you don't want to show result message use
                        // pleaseWait.dismiss();
                        //
                        // If you want to update text during to proccess use
                        // pleaseWait.updateMessage("Operation continues");
                    }
                }, 2000);
            }
        });

        /**** Using Alert Message ***/
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertMessage(MainActivity.this, "Title", "Mesasage");
                // For changing to button text, use below code
                // new AlertMessage(MainActivity.this, "Title", "Mesasage", "ButtonText");
            }
        });

        /**** Using Confirm Alert Message ***/
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertMessage(MainActivity.this, "Title", "Message", new AlertListener() {
                    @Override
                    public void onAccepted() {

                    }

                    @Override
                    public void onCanceled() {

                    }
                });

                // For changing to button text, use below code
                // new AlertMessage(MainActivity.this, "Title", "Message", "PositiveButtonText", "NegativeButtonText", new AlertListener() {
                //     @Override
                //     public void onAccepted() {
                //
                //    }
                //
                //    @Override
                //    public void onCanceled() {
                //
                //    }
                // });
            }
        });
    }
}
```