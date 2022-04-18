package piano;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.NoteEvent;
import music.Pitch;
//
public class PianoMachine {

	private Midi midi;
	private Instrument instrument = Instrument.PIANO;
    private ArrayList<Pitch> picthArray = new ArrayList<>();
    private int semitones=0;
    private boolean record_state = false;
    private ArrayList<NoteEvent> eventArrayList = new ArrayList<>();
	/**
	 * constructor for PianoMachine.
	 *
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    //TODO write method spec
    public void beginNote(Pitch rawPitch) {
    	int sig=0;
    	if (!picthArray.contains(rawPitch)){
            midi.beginNote(rawPitch.transpose(semitones).toMidiFrequency(),instrument);
            picthArray.add(rawPitch);
            if (record_state){
                long start = System.currentTimeMillis();
                NoteEvent ne = new NoteEvent(rawPitch.transpose(semitones), start, instrument, NoteEvent.Kind.start);
                eventArrayList.add(ne);
            }
        }
    }

    //TODO write method spec
    public void endNote(Pitch rawPitch) {
        Pitch raw = rawPitch.transpose(semitones);
        if (picthArray.contains(rawPitch)){
            midi.endNote(raw.toMidiFrequency(),instrument);
            picthArray.remove(rawPitch);
            //TODO implement for question 1
            if (record_state){
                long end = System.currentTimeMillis();
                NoteEvent ne = new NoteEvent(raw, end, instrument, NoteEvent.Kind.stop);
                eventArrayList.add(ne);
            }
        }
    }

    //TODO write method spec
    public void changeInstrument() {
       	//TODO: implement for question 2
        instrument = instrument.next();
    }

    //TODO write method spec
    public void shiftUp() {
    	//TODO: implement for question 3
        if (semitones<24){
        semitones += 12;}
    }

    //TODO write method spec
    public void shiftDown() {
    	//TODO: implement for question 3
        if (semitones>-24){
        semitones -=12;}
    }

    //TODO write method spec
    public boolean toggleRecording() {
    	//TODO: implement for question 4
        if (record_state){
            record_state=false;
            return false;
        }
        else{
            record_state=true;
            return true;
        }
    }

//    //TODO write method spec
//    public void playback() {
//        //TODO: implement for question 4
//        long time=eventArrayList.get(0).getTime();
//        for (NoteEvent ne:eventArrayList){
//            if (ne.getKind()==NoteEvent.Kind.start){
//                midi.beginNote(ne.getPitch().toMidiFrequency(),ne.getInstr());
//            }
//            else {
//                midi.endNote(ne.getPitch().toMidiFrequency(),ne.getInstr());
//            }
//            long newTime = ne.getTime();
//            if (ne!=eventArrayList.get(0)) {
//                try {
//                    Thread.sleep((int) (newTime - time));
//                } catch (InterruptedException e) {
//                }
//            }
//            time = newTime;
//        }
//    }
    public void playback() {
        NoteEvent firstEvent = eventArrayList.get(0);
        midi.beginNote(firstEvent.getPitch().toMidiFrequency(), firstEvent.getInstr());
        for (int i=1; i<eventArrayList.size(); i++){
            NoteEvent event = eventArrayList.get(i);
            // sleep
            try {
                Thread.sleep((int)(event.getTime()-eventArrayList.get(i-1).getTime()));
            } catch (InterruptedException e){
            }

            if (event.getKind()== NoteEvent.Kind.start){
                // start
                midi.beginNote(event.getPitch().toMidiFrequency(), event.getInstr());
            }
            else{
                // end
                midi.endNote(event.getPitch().toMidiFrequency(), event.getInstr());
            }
        }

        // clear everything
        eventArrayList.clear();
        //TODO: implement for question 4
    }
}

//public class PianoMachine {
//    private Instrument currentIns = Instrument.PIANO;
//    private int octaveAdder=0;
//    private Midi midi;
//    private ArrayList<Pitch> currentPitch = new ArrayList<>();
//    private boolean recordState = false;
//    private ArrayList<NoteEvent> record = new ArrayList<>();
//    /**
//     * constructor for PianoMachine.
//     *
//     * initialize midi device and any other state that we're storing.
//     */
//    public PianoMachine() {
//        try {
//            midi = Midi.getInstance();
//        } catch (MidiUnavailableException e1) {
//            System.err.println("Could not initialize midi device");
//            e1.printStackTrace();
//            return;
//        }
//    }
//
//    //TODO write method spec
//    public void beginNote(Pitch rawPitch) {
//        if (!currentPitch.contains(rawPitch)) {
//            currentPitch.add(rawPitch);
//            midi.beginNote((rawPitch.transpose(octaveAdder).toMidiFrequency()), currentIns);
//            // record
//            if (this.recordState)
//            {
//                record.add(new NoteEvent(rawPitch.transpose(octaveAdder), System.currentTimeMillis(), currentIns, NoteEvent.Kind.start));
//            }
//
//            //TODO implement for question 1
//        }
//    }
//
//    //TODO write method spec
//    public void endNote(Pitch rawPitch) {
//        if (currentPitch.contains(rawPitch)) {
//            currentPitch.remove(rawPitch);
//            midi.endNote((rawPitch.transpose(octaveAdder).toMidiFrequency()), currentIns);
//            // record
//            if (this.recordState)
//            {
//                record.add(new NoteEvent(rawPitch.transpose(octaveAdder), System.currentTimeMillis(), currentIns, NoteEvent.Kind.stop));
//            }
//            //TODO implement for question 1
//        }
//    }
//
//    //TODO write method spec
//    public void changeInstrument() {
//        currentIns = currentIns.next();
//        //TODO: implement for question 2
//    }
//
//    //TODO write method spec
//    public void shiftUp() {
//        if (octaveAdder<24) {
//            octaveAdder += 12;
//        }
//        //TODO: implement for question 3
//    }
//
//    //TODO write method spec
//    public void shiftDown() {
//        if (octaveAdder>-24){
//            octaveAdder -= 12;
//        }
//        //TODO: implement for question 3
//    }
//
//    //TODO write method spec
//    public boolean toggleRecording() {
//        recordState = (!recordState);
//        return recordState;
//        //TODO: implement for question 4
//    }
//
//    //TODO write method spec
//    public void playback() {
//        NoteEvent firstEvent = record.get(0);
//        midi.beginNote(firstEvent.getPitch().toMidiFrequency(), firstEvent.getInstr());
//        for (int i=1; i<record.size(); i++){
//            NoteEvent event = record.get(i);
//            // sleep
//            try {
//                Thread.sleep((int)(event.getTime()-record.get(i-1).getTime()));
//            } catch (InterruptedException e){
//            }
//
//            if (event.getKind()== NoteEvent.Kind.start){
//                // start
//                midi.beginNote(event.getPitch().toMidiFrequency(), event.getInstr());
//            }
//            else{
//                // end
//                midi.endNote(event.getPitch().toMidiFrequency(), event.getInstr());
//            }
//        }
//
//        // clear everything
//        record.clear();
//        //TODO: implement for question 4
//    }
//}