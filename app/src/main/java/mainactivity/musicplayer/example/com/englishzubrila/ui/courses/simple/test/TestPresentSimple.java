package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.simple.test;

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

public class TestPresentSimple extends AppCompatActivity {
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
    static final long START_TIME_IN_MILIS = 60000;
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
            {"Выберите правильный вариант.  I .... Spanish with my sister.", " study", "studies", " studying ", "Нет правильного ответа"},
            {" Выберите правильный вариант. My sister .... a shower every morning. ", " takes ", " take", " taking", " Нет правильного ответа"},
            {" Выберите правильный вариант. This house .... to my grandmother. " , "belongs", " belong", " belonges", " Нет правильного ответа "},
            {" Выберите правильный вариант. My husband and I .... a lot of money on books. " , " spend ", " spends ", " spending", " spendes "},
            {" Выберите правильный вариант. John .... milk twice a day. ", " drinks", " drink", " drinking ", " drinkes"},
            {" Выберите правильный вариант. It .... in Russia in winter. ", " snows ", " snow ", " snowes", " Нет правильного ответа"},
            {" Выберите правильный вариант. Plants .... well in a warm climate. ", " grow", " growing", " grows ", " growes"},
            {" Выберите правильный вариант.  .... they often watch TV at night? ", " Do", "Does", "Are", " Is"},
            {" Выберите правильный вариант. .... you like pizza? ", " Do ", " Does", "Are", " Is"},
            {" Выберите правильный вариант. Where .... he live in Prague? ", " does ", " do", "Are", " Is"}
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
        mActivity = TestPresentSimple.this;

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
            LayoutInflater factory = LayoutInflater.from(TestPresentSimple.this);
            final View viewE = factory.inflate(R.layout.sample, null);
            builder.setView(viewE);
        } else {
            LayoutInflater factory = LayoutInflater.from(TestPresentSimple.this);
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
        AlertDialog dialoging = builder.create();
        dialoging = builder.create();
        dialoging.show();

        WindowManager.LayoutParams wmlp = dialoging.getWindow().getAttributes();

        if (alertTitle.equals(correct)){
            Objects.requireNonNull(dialoging.getWindow()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorTrue)));
        } else {
            Objects.requireNonNull(dialoging.getWindow()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorFalse)));
        }
        dialoging.show();
        return correct;
    }
}
