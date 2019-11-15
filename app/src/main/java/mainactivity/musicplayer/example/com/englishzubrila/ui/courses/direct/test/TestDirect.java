package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.direct.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

import mainactivity.musicplayer.example.com.englishzubrila.R;
import mainactivity.musicplayer.example.com.englishzubrila.ui.courses.alphabet.test.resultActivity;

import static android.view.Gravity.CENTER;

public class TestDirect extends AppCompatActivity {
    private TextView countLabel;
    ProgressBar mProgressBar;
    private TextView questionLabel;
    private TextView quizTimer;
    private Button answerButtonE;
    private Button answerButtonB;
    private Button answerButtonS;
    private Button answerButtonD;
    private CountDownTimer mCountDownTimer;
    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 10;
    static final long START_TIME_IN_MILIS = 300000;
    private long mTimeLeftinMillis = START_TIME_IN_MILIS;
    int PROGRESS_BAR_INCREMENT = 100 / QUIZ_COUNT;
    private String correct = "Correct";
    private String wrong = "Wrong";

    private Toolbar toolbar;
    private ActionBar actionBar;

    private Activity mActivity;

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftinMillis, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftinMillis = millisUntilFinished;
                quizTimer.setText("Time: " + millisUntilFinished / 2000);
            }

            @Override
            public void onFinish() {
                quizTimer.setText("DONE!");
            }
        }.start();

    }

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    String quizData[][] = {
            //{"Question", "right answer", "choicea", "choiceb", "choicec", "choiced"}
            {"Выбрать правильный вариант предложения в косвенной речи. предложения в косвенной речи. «Help me to get up,» Mr Day says to Mr Bliss.", " Mr Day tells Mr Bliss to help him to get up.", "Mr Day tell Mr Bliss to helps him to get up.", "Mr Day is telling Mr Bliss to help him to get up.", "Mr Day tells to Mr Bliss help him to get up."},
            {" Выберите правильный вариант предложения в косвенной речи. He says, «Now I cannot walk.».", "He says that now he cannot walk.", "He is says that now he cannot walk.", "He is saying that now he cannot walk.", " He says that now he don’t can walk."},
            {" Выберите правильный вариант предложения в косвенной речи. He says, «I cannot make it go faster.»" , "He says that he cannot make it go faster.", " He is saying that he cannot make it go faster.", "He is says that he cannot make it go faster.", " He say that he cannot makes it go faster."},
            {" Выберите правильный вариант предложения в косвенной речи. He says, «If I do not stop, I will run over them!»" , "He says that if he does not stop he will run over them.", "He say that if he do not stops he will run over them.", "He is says that if he do not stop he will run over them.", " He say that if he does not stop he will runs over them."},
            {" Выберите правильный вариант предложения в косвенной речи. «I like bananas,» says Teddy.", "Teddy says that he likes bananas.", "Teddy say that he like bananas.", "Teddy is says that he doesn’t like bananas.", " Teddy says that he don’t like bananas."},
            {" Выберите правильный вариант предложения в косвенной речи. «And we want a car,» they all say.", "They all say that they want a car.", " They are all say that they want a car.", " They all says that they wants a car.", " They all say that they are want a car."},
            {" Выберите правильный вариант предложения в косвенной речи.  «You cannot have my car,» says Mr Bliss.", " Mr Bliss says that they cannot have his car.", " Mr Bliss say that they cannot have to his car.", " Mr Bliss is say that they cannot have his car.", "Mr Bliss says that they don’t can have his car."},
            {" Выберите правильный вариант предложения в косвенной речи. «We will eat you all up!» say the bears. ", "The bears say that they will eat them all up.", "The bears says that they will eat them all up.", "The bears are say that they will eat them all up.", " The bears say that they are will eat them all up."},
            {" Выберите правильный вариант предложения в косвенной речи. «Stop!» the bears cry to Mr Bliss.", " The bears cry to Mr Bliss to stop.", " The bears are crying to Mr Bliss to stop.", "The bears cry Mr Bliss stop.", " Mr Bliss cry to the bears to stop."},
            {" Выберите правильный вариант предложения в косвенной речи. Mr Bliss says, «I have to stop.»", " Mr Bliss says that he has to stop. ", " Mr Bliss is says that he has to stop.", " Mr Bliss says that he have to stop. ", " Mr Bliss is say that he have to stop. "}
    };

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_alphabet);

        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.question_text_view);
        quizTimer = findViewById(R.id.timer);
        mProgressBar = findViewById(R.id.progress_bar);
        answerButtonE = findViewById(R.id.answerE);
        answerButtonB = findViewById(R.id.answerB);
        answerButtonS = findViewById(R.id.answerS);
        answerButtonD = findViewById(R.id.answerD);
        mActivity = TestDirect.this;

        toolbar = findViewById(R.id.toolTesting);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        actionBar = getSupportActionBar();
        actionBar.setTitle("Test");

        startTimer();

        for (int i = 0; i < quizData.length; i++) {

            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); //Country
            tmpArray.add(quizData[i][1]); //Right Answer
            tmpArray.add(quizData[i][2]); //Choice1
            tmpArray.add(quizData[i][3]); //Choice2
            tmpArray.add(quizData[i][4]); //Choice3

            quizArray.add(tmpArray);
        }
        showNextQuiz();
    }

    public void showNextQuiz() {

        countLabel.setText("Вопрос" + quizCount);
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);

        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        answerButtonE.setText(quiz.get(0));
        answerButtonB.setText(quiz.get(1));
        answerButtonS.setText(quiz.get(2));
        answerButtonD.setText(quiz.get(3));

        quizArray.remove(randomNum);
    }

    @SuppressLint({"NewApi", "ResourceType"})
    public String checkAnswer(View view) {

        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        final String alertTitle;

        if (btnText.equals(rightAnswer)) {
            alertTitle = correct;
            rightAnswerCount++;
        } else {
            alertTitle = wrong;
        }

        ContextThemeWrapper cw = new ContextThemeWrapper(this, R.style.AlertDialogTheme);
        AlertDialog.Builder builder = new AlertDialog.Builder(cw);
        TextView dialogTitle = new TextView (getApplicationContext ());
        dialogTitle.setText (alertTitle);
        dialogTitle.setTextSize (TypedValue.COMPLEX_UNIT_DIP, 40);
        dialogTitle.setGravity(CENTER);
        dialogTitle.setTextColor(getResources().getColor(R.color.color1));
        builder.setCustomTitle (dialogTitle);
        builder.setTitle(alertTitle);

        if (alertTitle == correct) {
            LayoutInflater factory = LayoutInflater.from(TestDirect.this);
            final View viewE = factory.inflate(R.layout.sample, null);
            builder.setView(viewE);
        } else {
            LayoutInflater factory = LayoutInflater.from(TestDirect.this);
            final View viewB = factory.inflate(R.layout.smale_fols, null);
            builder.setView(viewB);
        }
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    Intent intent = new Intent(getApplicationContext(), resultActivity.class);
                    mProgressBar.setProgress(0);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);
                } else {
                    quizCount++;
                    mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
                    showNextQuiz();
                }
            }
        });
        AlertDialog dialogE = builder.create();
        dialogE = builder.create();
        dialogE.show();

        WindowManager.LayoutParams wmlp = dialogE.getWindow().getAttributes();

        if (alertTitle.equals(correct)){
            Objects.requireNonNull(dialogE.getWindow()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorTrue)));
        } else {
            Objects.requireNonNull(dialogE.getWindow()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorFalse)));
        }
        dialogE.show();
        return correct;
    }
}
