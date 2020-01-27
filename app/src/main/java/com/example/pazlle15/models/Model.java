package com.example.pazlle15.models;

import com.example.pazlle15.contracts.Contract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Model implements Contract.Model {
    ArrayList<Integer> data = new ArrayList();

    public Model() {
                for (int i = 1;  i < 16 ; i++) {
            data.add(i);
        }

    }

    @Override
    public ArrayList getData() {
      //  Collections.shuffle(data);

        return data;
    }
}
