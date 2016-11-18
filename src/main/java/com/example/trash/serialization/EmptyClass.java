package com.example.trash.serialization;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EmptyClass implements Serializable {

    int number = 10;

//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        EmptyClass emptyClass = new EmptyClass();
//        System.out.println(emptyClass);
//
//        byte[] bytes;
//        try(
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//            ) {
//            objectOutputStream.writeObject(emptyClass);
//            bytes = byteArrayOutputStream.toByteArray();
//        }
//
//        try(ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
//            EmptyClass restoredObject = (EmptyClass) objectInputStream.readObject();
//            System.out.println(restoredObject);
//        }
//
//        float floatValue = 11.0f;
//        int intValue = 10;
//        intValue++;
//
//        if (floatValue == intValue) {
//            System.out.println("possible");
//        }
//    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("number", number)
                .toString();
    }
}
