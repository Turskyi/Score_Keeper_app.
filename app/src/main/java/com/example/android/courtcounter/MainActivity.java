package com.example.android.courtcounter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int timeDelay;
    int timeDelayRun;
    int minTimeDelay;
    int timeDecrease;
    int scoreTeamA;
    int scoreTeamB;
    int foulsTeamA;
    int foulsTeamB;
    Message message;
    Bundle bundle;
    Handler handlerScoreA, handlerFoulsA, handlerScoreB, handlerFoulsB;
    Button btnReset, btnPlusA, btnPlusB, btnMinusA, btnMinusB,
            btnMinusFoulsA, btnMinusFoulB, btnPlusFoulA, btnPlusFoulB;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = new Message();
        bundle = new Bundle();
        btnReset = findViewById(R.id.reset);
        btnPlusA = findViewById(R.id.plus_one_a);
        btnPlusB = findViewById(R.id.plus_one_b);
        btnMinusA = findViewById(R.id.minus_one_a);
        btnMinusB = findViewById(R.id.minus_one_b);
        btnMinusFoulsA = findViewById(R.id.minus_foul_a);
        btnMinusFoulB = findViewById(R.id.minus_foul_b);
        btnPlusFoulA = findViewById(R.id.plus_foul_a);
        btnPlusFoulB = findViewById(R.id.plus_foul_b);

        handlerFoulsA = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(final Message msg) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayFoulsForTeamA(msg.getData().getInt("KEY"));
                    }
                });
                super.handleMessage(msg);
            }
        };

        handlerFoulsB = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(final Message msg) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayFoulsForTeamB(msg.getData().getInt("KEY"));
                    }
                });
                super.handleMessage(msg);
            }
        };

        handlerScoreA = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(final Message msg) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayForTeamA(msg.getData().getInt("KEY"));
                    }
                });
                super.handleMessage(msg);
            }
        };

        handlerScoreB = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(final Message msg) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayForTeamB(msg.getData().getInt("KEY"));
                    }
                });
                super.handleMessage(msg);
            }
        };

        //          Decrease the score for Team A by 1 point.
        btnMinusA.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, final MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            timeDelay = 1000;
                            timeDelayRun = 100;
                            minTimeDelay = 10;
                            timeDecrease = 2;
                            do {
                                if (scoreTeamA == 0) return;
                                scoreTeamA--;
                                bundle.putInt("KEY", scoreTeamA);
                                handlerScoreA.handleMessage(message);
                                speedUp();
                            } while (event.getAction() != MotionEvent.ACTION_UP);
                        }
                    }).start();
                    return true;
                } else return event.getAction() == MotionEvent.ACTION_UP;
            }
        });

        //          Decrease the score for Team B by 1 point.
        btnMinusB.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, final MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            timeDelay = 1000;
                            timeDelayRun = 100;
                            minTimeDelay = 10;
                            timeDecrease = 2;
                            do {
                                if (scoreTeamB == 0) return;
                                scoreTeamB--;
                                bundle.putInt("KEY", scoreTeamB);
                                handlerScoreB.handleMessage(message);
                                speedUp();
                            } while (event.getAction() != MotionEvent.ACTION_UP);
                        }
                    }).start();
                    return true;
                } else return event.getAction() == MotionEvent.ACTION_UP;
            }
        });

        //          Decrease fouls for Team A by 1.
        btnMinusFoulsA.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, final MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            timeDelay = 1000;
                            timeDelayRun = 100;
                            minTimeDelay = 10;
                            timeDecrease = 2;
                            do {
                                if (foulsTeamA == 0) return;
                                foulsTeamA--;
                                bundle.putInt("KEY", foulsTeamA);
                                handlerFoulsA.handleMessage(message);
                                speedUp();
                            } while (event.getAction() != MotionEvent.ACTION_UP);
                        }
                    }).start();
                    return true;
                } else return event.getAction() == MotionEvent.ACTION_UP;
            }
        });
        
        //          Decrease fouls for Team B by 1.
        btnMinusFoulB.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, final MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            timeDelay = 1000;
                            timeDelayRun = 100;
                            minTimeDelay = 10;
                            timeDecrease = 2;
                            do {
                                if (foulsTeamB == 0) return;
                                foulsTeamB--;
                                bundle.putInt("KEY", foulsTeamB);
                                handlerFoulsB.handleMessage(message);
                                speedUp();
                            } while (event.getAction() != MotionEvent.ACTION_UP);
                        }
                    }).start();
                    return true;
                } else return event.getAction() == MotionEvent.ACTION_UP;
            }
        });

//        Increase foul for Team A by 1 very fast.
        btnPlusFoulA.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, final MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            timeDelay = 1000;
                            timeDelayRun = 100;
                            minTimeDelay = 10;
                            timeDecrease = 2;
                            do {
                                foulsTeamA++;
                                bundle.putInt("KEY", foulsTeamA);
                                handlerFoulsA.handleMessage(message);
                                speedUp();
                            } while (event.getAction() != MotionEvent.ACTION_UP);
                        }
                    }).start();
                    return true;
                } else return event.getAction() == MotionEvent.ACTION_UP;
            }
        });

        /*
          Increase the score for Team A by 1 point.
         */
        btnPlusA.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, final MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            timeDelay = 1000;
                            timeDelayRun = 100;
                            minTimeDelay = 10;
                            timeDecrease = 2;
                            do {
                                scoreTeamA++;
                                bundle.putInt("KEY", scoreTeamA);
                                handlerScoreA.handleMessage(message);
                                speedUp();
                            } while (event.getAction() != MotionEvent.ACTION_UP);
                        }
                    }).start();
                    return true;
                } else return event.getAction() == MotionEvent.ACTION_UP;
            }
        });

        /*
          Increase the score for Team A by 1 point.
         */
        btnPlusB.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, final MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            timeDelay = 1000;
                            timeDelayRun = 100;
                            minTimeDelay = 10;
                            timeDecrease = 2;
                            do {
                                scoreTeamB++;
                                bundle.putInt("KEY", scoreTeamB);
                                handlerScoreB.handleMessage(message);
                                speedUp();
                            } while (event.getAction() != MotionEvent.ACTION_UP);
                        }
                    }).start();
                    return true;
                } else return event.getAction() == MotionEvent.ACTION_UP;
            }
        });

        /*
          Increase fouls for Team B by 1.
         */
        btnPlusFoulB.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, final MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            timeDelay = 1000;
                            timeDelayRun = 100;
                            minTimeDelay = 10;
                            timeDecrease = 2;
                            do {
                                foulsTeamB++;
                                bundle.putInt("KEY", foulsTeamB);
                                handlerFoulsB.handleMessage(message);
                                speedUp();
                            } while (event.getAction() != MotionEvent.ACTION_UP);
                        }
                    }).start();
                    return true;
                } else return event.getAction() == MotionEvent.ACTION_UP;
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreTeamA = 0;
                scoreTeamB = 0;
                foulsTeamA = 0;
                foulsTeamB = 0;
                displayForTeamA(scoreTeamA);
                displayForTeamB(scoreTeamB);
                displayFoulsForTeamA(foulsTeamA);
                displayFoulsForTeamB(foulsTeamB);
            }
        });
    }

    private void speedUp() {
        message.setData(bundle);
        try {
            Thread.sleep(timeDelay);
            if (timeDelay > minTimeDelay) {
                timeDelay -= timeDecrease;
            }
            if (timeDelay > timeDelayRun) {
                timeDelay = timeDelayRun;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given fouls for Team A.
     */
    public void displayFoulsForTeamA(int foul) {
        TextView foulsView = findViewById(R.id.team_a_fouls);
        foulsView.setText(String.valueOf(foul));
    }

    /**
     * Displays the given fouls for Team B.
     */
    public void displayFoulsForTeamB(int fouls) {
        TextView foulsView = findViewById(R.id.team_b_fouls);
        foulsView.setText(String.valueOf(fouls));
    }
}
