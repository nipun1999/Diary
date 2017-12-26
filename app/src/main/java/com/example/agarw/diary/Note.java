package com.example.agarw.diary;

/**
 * Created by agarw on 12/26/2017.
 */

public class Note {
    int _id;
    String _notes;
    String _heading;

    public Note(){

    }

    public Note(int id, String notes, String heading){
        this._notes = notes;
        this._id = id;
        this._heading = heading;
    }

    public int getID(){
        return this._id;
    }

    public String getHeading(){
        return this._heading;
    }

    public String getNotes(){
        return this._notes;
    }
    public void setID(int id ){
        this._id = id;
    }
    public void setNotes(String notes){
        this._notes = notes;
    }
    public void setNHeading(String heading){
        this._heading = heading;
    }
}
