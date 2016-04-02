package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class AlarmState implements SimpleTimerState {

    public AlarmStateState(final SimpleTimerSMStateView sm) {
        this.sm = sm;
    }

    private final SimpleTimerSMStateView sm;

    @Override
    public void onStop() {
        sm.stopBeeping();
        sm.buttonChgToInc();
        sm.toStoppedState();
    }

    @Override
    public void onBeep() {
        sm.beep();
    }

    @Override
    public void actionUpdateView() {
        sm.updateUILaptime();
    }

    @Override
    public int getId() {
        return R.string.ALARM;
    }
}