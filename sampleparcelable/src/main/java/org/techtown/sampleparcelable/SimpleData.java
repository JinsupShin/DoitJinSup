package org.techtown.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jins on 2018-03-04.
 */

public class SimpleData implements Parcelable {
    int number;
    String message;

    public SimpleData(int num , String msg){
        number = num;
        message = msg;
    }

    public SimpleData(Parcel src){     //Parcel 객체에서 읽기
        number = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){  // CREATOR 상수 정의

        public SimpleData createFromParcel(Parcel in){
            return new SimpleData(in);    // SimpleData 생성자를 호출해 Parcel객체에서 읽기
        }

        public SimpleData[] newArray(int size){
            return new SimpleData[size];
        }
    };

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){    // Parcel 객체로 쓰기
        dest.writeInt(number);
        dest.writeString(message);
    }

    public  int getNumber(){
        return number;
    }

    public  void setNumber(int number){
        this.number = number;
    }

    public  String getMessage(){
        return message;
    }

    public  void setMessage(String message){
        this.message = message;
    }
}
