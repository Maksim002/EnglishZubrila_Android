package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.articles.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

public class TestArticles extends AppCompatActivity{
        private TextView countLabel;
        ProgressBar mProgressBar;
        private TextView questionLabel;
        private TextView quizTimer;
        private Button answerButton1;
        private Button answerButton2;
        private Button answerButton3;
        private Button answerButton4;
        private CountDownTimer mCountDownTimer;
        private String rightAnswer;
        private int rightAnswerCount = 0;
        private int quizCount = 1;

        static final private int QUIZ_COUNT = 10;
        static final long START_TIME_IN_MILIS = 60000;
        private long mTimeLeftinMillis = START_TIME_IN_MILIS;
        int PROGRESS_BAR_INCREMENT = 100 / QUIZ_COUNT;

        private String corect = "Correct";
        private String wrong = "Wrong";

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
                {" Выбрать слово, перед которым  ставится артикль «a» ", " butterfly  (бабочка)", "English dictionary (английский словарь)", "ice-cream", "elephant (слон)"},
                {" Выбрать слово, перед которым ставится артикль «an» ", " onion (лук) ", " strawberry (клубника) ", " twins (близнецы) ", " bird (птица)"},
                {" Выбрать вариант, перед которым ставится артикль «a» " , " red apple (красное яблоко)", " old town (старый город) ", "interesting book (интересная книга)", " orange dress (оранжевое платье) "},
                {" Выбрать слово, перед которым ставится артикль «an» " , " uncle (дядя)"," union (союз) "," youth (юноша) ", " year (год) "},
                {" Выбрать слово, перед которым ставится артикль «a» ", " Нет правильного ответа", " honey (мед)", " water ( вода)", " tea ( чай)"},
                {" Выбрать правильный перевод: У нас кофе на завтрак ", " We have coffee for breakfast. ", " We have a coffee for breakfast. ", " We have coffee for a breakfast. ", "Нет правильного ответа"},
                {" Определенный артикль употребляется перед существительным, обозначающим предмет:", " Все ответы верны.", " Единственный в данной ситуации.", " Единственный вообще, во всех ситуациях.", " Уже известный слушающему (читающему) из предыдущего опыта."},
                {" Выбрать необходимый артикль: ___ farmer has two sons "," The"," A"," An", "Нет правильного ответа"},
                {" Выбрать необходимые артикли: We see ___roof of ___house. ", " the , a "," a , a"," a, the", " нет артикля, the"},
                {" Выбрать необходимые артикли: Tim wants to become ___captain of ___ship. ", " the , a "," нет артикля , a"," a, the", " a, нет артикля"}
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
            answerButton1 = findViewById(R.id.answer1);
            answerButton2 = findViewById(R.id.answer2);
            answerButton3 = findViewById(R.id.answer3);
            answerButton4 = findViewById(R.id.answer4);
            mActivity = TestArticles.this;

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

            answerButton1.setText(quiz.get(0));
            answerButton2.setText(quiz.get(1));
            answerButton3.setText(quiz.get(2));
            answerButton4.setText(quiz.get(3));

            quizArray.remove(randomNum);
        }

        @SuppressLint({"NewApi", "ResourceType"})
        public String checkAnswer(View view) {

            Button answerBtn = (Button) findViewById(view.getId());
            String btnText = answerBtn.getText().toString();

            final String alertTitle;

            if (btnText.equals(rightAnswer)) {
                alertTitle = corect;
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

            if (alertTitle == corect) {
                LayoutInflater factory = LayoutInflater.from(TestArticles.this);
                final View view2 = factory.inflate(R.layout.sample, null);
                builder.setView(view2);
            } else {
                LayoutInflater factory = LayoutInflater.from(TestArticles.this);
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

            if (alertTitle.equals(corect)){
                Objects.requireNonNull(dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorTrue)));
            } else {
                Objects.requireNonNull(dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorFalse)));
            }
            dialog1.show();
            return corect;
        }

}
