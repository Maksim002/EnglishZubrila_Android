package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.prular.test;

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

public class TestPluralForm extends AppCompatActivity {
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
    static final long START_TIME_IN_MILIS = 240000;
    private long mTimeLeftinMillis = START_TIME_IN_MILIS;
    int PROGRESS_BAR_INCREMENT = 100 / QUIZ_COUNT;
    private String correct = "Correct";
    private String wrong = "Wrong";
    private Toolbar toolbar;
    private ActionBar actionBar;

    private Activity mActivity;

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftinMillis, 200) {
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
            {" После каких согласных окончание «-s» читается [s].", " socks (носки)", " doors (двери)", " cows (коровы)", " rooms (комнаты)"},
            {" После каких согласных окончание «-s» читается [s].", " cliffs (скалы) ", " ribs (ребра) ", " rooms (комнаты) ", " sons (сыновья)"},
            {" После каких согласных «-s» дает звонкое [z]." , " cups (чашки) ", " doors (двери) ", " gods (боги) ", " cars (машины)"},
            {" После каких  согласных «-s» дает звонкое [z]." , " uncle (дядя)"," union (союз) "," youth (юноша) ", " year (год) "},
            {" Выбрать правильный перевод: Cats have nine lives", " У кошек 9 жизней", " У кошки 3 жизни", " У кошки 9 жизней", " У кошек 9 жизней"},
            {" Выбрать правильный перевод: две чашки", " two cups ", " a two cups ", " a two cup ", " two cup"},
            {" Когда используется окончание «-s» и «-es» ", "Для образования множественного числа существительных и при образовании времени Present Simple.", " У глагола в 3 лице, единственном числе в утвердительной форме Present simple.", "Нет правильного ответа", " Для образования множественного числа существительных "},
            {" После каких существительных для образования множественного числа используется окончание  «-s» ", " apple "," peach"," box", " kiss"},
            {" После каких существительных для образования множественного числа используется окончание  «-s» ", " monkey"," crash"," match ", " Нет правильного ответа "},
            {" После каких существительных для образования множественного числа используется окончание  «-es» ", " body"," piano"," flower", " book"}
    };


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_alphabet);

        toolbar = findViewById(R.id.toolTesting);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Test");

        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.question_text_view);
        quizTimer = findViewById(R.id.timer);
        mProgressBar = findViewById(R.id.progress_bar);
        answerButtonE = findViewById(R.id.answerE);
        answerButtonB = findViewById(R.id.answerB);
        answerButtonS = findViewById(R.id.answerS);
        answerButtonD = findViewById(R.id.answerD);
        mActivity = TestPluralForm.this;

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
            LayoutInflater factory = LayoutInflater.from(TestPluralForm.this);
            final View view2 = factory.inflate(R.layout.sample, null);
            builder.setView(view2);
        } else {
            LayoutInflater factory = LayoutInflater.from(TestPluralForm.this);
            final View view1 = factory.inflate(R.layout.smale_fols, null);
            builder.setView(view1);
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
        AlertDialog dialog1 = builder.create();
        dialog1 = builder.create();
        dialog1.show();

        WindowManager.LayoutParams wmlp = dialog1.getWindow().getAttributes();

        if (alertTitle.equals(correct)){
            Objects.requireNonNull(dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorTrue)));
        } else {
            Objects.requireNonNull(dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorFalse)));
        }
        dialog1.show();
        return correct;
    }

}

