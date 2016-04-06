package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.DefaultClockModel;

class IncrementState implements SimpleTimerState {

    public IncrementState(final SimpleTimerSMStateView sm) {
        this.sm = sm;
    }

    private final SimpleTimerSMStateView sm;

    private int clickcount = getValue();

    @Override
    public void onIncrement(){
        sm.actionIncrement();
        sm.actionUpdateView();
        if(clickcount == 99 || (clickcount < 99 && tickcount == 3)) {
            sm.actionBeep();
            sm.actionStart();
            sm.updateButtonName();
            sm.toDecrementState();
        }
        else
            sm.toIncrementState();
    }

    @Override
    public void onTick() {
        throw new UnsupportedOperationException("onTick");
    }

    @Override
    public void onCancel() {
           //do nothing, because there is no Cancel Button in this state
    }

    @Override
    public void updateView() {
        sm.actionUpdateView();
    }

    @Override
    public int getId() {
        return R.string.SETTIME;
    }

    @Override
    public int getValue(){
        return sm.getValue();
    }

    @Override
    public void onStop(){

    }

}


