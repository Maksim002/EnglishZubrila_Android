package mainactivity.musicplayer.example.com.englishzubrila.ui.courses.alphabet.test;

public class Questions {

    // These are the placeholders for the question resource id and the correct answer
    private int mQuestionID;
    private int mAnswer;
    private int mChoices;

    // This is the constructor that will be called when a new quiz question is created.
    public Questions(int questionResourceID, int correctAnswer) {
        mQuestionID = questionResourceID;
        mAnswer = correctAnswer;
    }

    // This method gives us access to info stored in the (private) question id.
    public int getQuestionID() {
        return mQuestionID;
    }

    // This method gives us access to info stored in the (private) mAnswer.
    public int isAnswer() {
        return mAnswer;
    }

}
